package br.com.projeto.testeapi.controle.Conta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.testeapi.repositorio.ContaRepositorio;

@RestController
@RequestMapping("/conta")
public class DeleteConta {

    @Autowired
    private ContaRepositorio conta_Repositorio;    

    // Deleta uma conta pelo ID informado
    /*
       Este endpoint faz uma chamada DELETE para remover uma conta específica.
       Parâmetros:
       - id: o ID da conta a ser deletada
       Retorna:
       - ResponseEntity com uma mensagem de sucesso (HTTP 200) se a exclusão for bem-sucedida
       - ResponseEntity com uma mensagem de erro (HTTP 200) se a conta não for encontrada

       Exmplo:
        http://localhost:8080/conta/deletar/1
    */
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deleteConta(@PathVariable Long id){
        if(!conta_Repositorio.existsById(id)){
            return ResponseEntity.ok("Conta não encontrada.");
        }
        conta_Repositorio.deleteById(id);
        return ResponseEntity.ok("Conta deletada com sucesso.");
    }
}
