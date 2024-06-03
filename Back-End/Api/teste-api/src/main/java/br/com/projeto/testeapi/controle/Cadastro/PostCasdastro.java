package br.com.projeto.testeapi.controle.Cadastro;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.testeapi.modelo.Cadastro;
import br.com.projeto.testeapi.modelo.Conta;
import br.com.projeto.testeapi.repositorio.CadastroRepositorio;
import br.com.projeto.testeapi.repositorio.ContaRepositorio;
import lombok.Getter;
import lombok.Setter;

@RestController
@RequestMapping("/cadastros")
public class PostCasdastro {
    
    @Autowired
    private CadastroRepositorio cadastro_Repositorio;

    @Autowired
    private ContaRepositorio conta_Repositorio;

    // Cria um novo registro de Cadastro.
    @PostMapping("/cadastrar")
    public ResponseEntity<?> criarCadastro(@RequestBody CadastroRequest cadastroRequest) {
        // Verifica se a conta associada existe
        Optional<Conta> optionalConta = conta_Repositorio.findById(cadastroRequest.getIdConta());
        if (optionalConta.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Conta não encontrada");
        }

        // Cria um novo objeto Cadastro com os dados recebidos na requisição
        Cadastro novoCadastro = new Cadastro();
        novoCadastro.setCpf(cadastroRequest.getCpf());
        novoCadastro.setDocSUS(cadastroRequest.getDocSUS());
        novoCadastro.setNome(cadastroRequest.getNome());
        novoCadastro.setDataNasc(cadastroRequest.getDataNasc());

        // Associa a conta ao cadastro
        novoCadastro.setConta(optionalConta.get());

        // Salva o novo cadastro no banco de dados
        Cadastro cadastroSalvo = cadastro_Repositorio.save(novoCadastro);

        return ResponseEntity.status(HttpStatus.CREATED).body(cadastroSalvo);
    }



}
// Classe para representar o objeto JSON recebido na requisição
@Getter
@Setter
class CadastroRequest {
    private String cpf;
    private String docSUS;
    private String nome;
    private LocalDate dataNasc;
    private Long idConta;
}