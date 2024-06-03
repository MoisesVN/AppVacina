package br.com.projeto.testeapi.controle.Cadastro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.testeapi.modelo.Cadastro;
import br.com.projeto.testeapi.repositorio.CadastroRepositorio;

@RestController
@RequestMapping("/cadastros")
public class GetCadastro {

    @Autowired
    private CadastroRepositorio cadastro_Repositorio;

    // Retorna todos os cadastros associados a uma conta específica
    /*
       Este endpoint retorna todos os cadastros associados a uma conta específica.
       Parâmetros:
       - id_conta: o ID da conta para a qual deseja-se recuperar os cadastros
       Retorna:
       - ResponseEntity com uma lista de cadastros associados à conta (HTTP 200) se houver cadastros
       - ResponseEntity com uma mensagem de erro (HTTP 404) se não houver cadastros associados à conta

       Exemplo:
        http://localhost:8080/cadastros/conta/{id_conta}
    */
    @GetMapping("/conta/{id_conta}")
    public ResponseEntity<?> getCadastrosByConta(@PathVariable Long id_conta) {
        List<Cadastro> cadastros = cadastro_Repositorio.findByConta_IdConta(id_conta);
        if (cadastros.isEmpty()) {
            // Se não houver cadastros, retorna uma resposta com status 404 (Not Found) e uma mensagem indicando que o cadastro não foi encontrado
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cadastro não encontrado");
        }
        // Se houver cadastros, retorna uma resposta com status 200 (OK) e a lista de cadastros
        return ResponseEntity.ok(cadastros);
    }

    // Lista todos os cadastros
    /*
       Este endpoint retorna todos os cadastros presentes no sistema.
       Exemplo:
        http://localhost:8080/cadastros/listar
    */
    @GetMapping("/listar")
    public Iterable<Cadastro> listar(){
        return cadastro_Repositorio.findAll();
    }

    // Retorna cadastro solicitado pela URL
        /*
           Este endpoint retorna o cadastro pelo seu ID -> id_cadastro
           Parâmetros:
           - id_cadastro: o ID da conta para a qual deseja-se recuperar os cadastros
           Retorna:
           - ResponseEntity com uma lista de cadastros associados à conta (HTTP 200) se houver cadastro
           - ResponseEntity com uma mensagem de erro (HTTP 404) se não houver cadastro associados ao ID informado

           Exemplo:
            http://localhost:8080/cadastros/{id_conta}
        */
    @GetMapping("/{id_cadastro}")
    public ResponseEntity<?> cadastroById(@PathVariable Long id_cadastro) {
        List<Cadastro> cadastro = cadastro_Repositorio.findByIdCadastro(id_cadastro);
        if (cadastro.isEmpty()) {
            // Se não houver cadastros, retorna uma resposta com status 404 (Not Found) e uma mensagem indicando que o cadastro não foi encontrado
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cadastro não encontrado");
        }
        // Se houver cadastros, retorna uma resposta com status 200 (OK) e a lista de cadastros
        return ResponseEntity.ok(cadastro);
    }


}
