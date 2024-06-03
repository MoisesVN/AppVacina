package br.com.projeto.testeapi.controle.Conta;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.testeapi.modelo.Conta;
import br.com.projeto.testeapi.repositorio.ContaRepositorio;

@RestController
@RequestMapping("/conta")
public class PostConta {

    @Autowired
    private ContaRepositorio conta_Repositorio;

    // Cria um novo cadastro
    /* 
    Este endpoint faz uma chamada POST para criar uma nova conta.

    Parâmetros:
    - obj: o objeto Conta contendo os dados da nova conta
    Retorna:
    - ResponseEntity com uma mensagem de sucesso (HTTP 201)

    Para cadastrar uma conta, deve-se fazer a chamada via POST onde, no corpo da requisição, devem ser passados os seguintes parâmetros JSON:
    http://localhost:8080/conta/cadastrar
    Body:{
        "senha": "ExemploSenh@123",
        "email": "email@exemplo.com",
        "telefone": "9 1234-5678)"
         } 
        */
    @PostMapping("/cadastrar")
    public ResponseEntity<String> cadastrar(@RequestBody Conta obj) {
        try {
            // Convertendo a senha em um hash utilizando SHA-256
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(obj.getSenha().getBytes());
            
            // Convertendo o hash para uma string em Base64
            String senhaHash = Base64.getEncoder().encodeToString(hashBytes);
            
            // Salvando a senha hasheada no objeto Conta
            obj.setSenha(senhaHash);
            
            // Salvando a conta no repositório
            conta_Repositorio.save(obj);
            
            // Retornando uma mensagem de sucesso
            return ResponseEntity.status(HttpStatus.CREATED)
                                 .body("Conta criada com sucesso.");
        } catch (NoSuchAlgorithmException e) {
            // Tratamento de erro para o caso de o algoritmo de hash não ser suportado
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Erro ao criar a conta.");
        }
    }
    
}
