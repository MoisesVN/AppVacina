package br.com.projeto.testeapi.controle.Conta;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.testeapi.modelo.Conta;
import br.com.projeto.testeapi.repositorio.ContaRepositorio;

@RestController
@RequestMapping("/conta")
public class GetConta {
    
    @Autowired
    private ContaRepositorio conta_Repositorio;

    // lista todas as contas
    /* 
        Este endpoint faz uma chamada GET para listar todas as contas.
        Retorna um Iterable contendo todas as contas armazenadas no repositório.
    */
    @GetMapping("/listar")
    public Iterable<Conta> listar(){
        return conta_Repositorio.findAll();
    }



    // Retorna todas as informações de uma conta atravez do seu ID
    // exemplo: http://localhost:8080/conta/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Conta> listarPorID(@PathVariable Long id) {
        // Obter o resultado da consulta
        List<Object[]> result = conta_Repositorio.findByContaIdNot(id);
        
        // Verificar se a lista não está vazia e obter o primeiro resultado
        if (!result.isEmpty()) {
            Object[] obj = result.get(0);
            
            // Criar um novo objeto Conta com os campos retornados
            Conta conta = new Conta();
            conta.setId_conta((Long)obj[0]);
            conta.setEmail((String) obj[1]);
            conta.setTelefone((String) obj[2]);
            
            // Retornar a resposta com o objeto Conta
            return ResponseEntity.ok(conta);
        } else {
            // Se não houver resultados, retornar 404 - Not Found
            return ResponseEntity.notFound().build();
        }
    }

    // Acessa a conta através de email e senha
    /*
        Este endpoint realiza uma chamada GET para autenticar uma conta utilizando o email e a senha fornecidos.
        Parâmetros:
            - email: o email associado à conta
            - senha: a senha da conta
        Retorna:
            - ID da conta
            - ResponseEntity com status 404 (não encontrado) se a conta não existir ou se as credenciais estiverem incorretas
            - ResponseEntity com o ID da conta se a autenticação for bem-sucedida (HTTP 200)
            - ResponseEntity com status 400 (bad request) se ocorrer uma exceção NonUniqueResultException
    */
    // exemplo: http://localhost:8080/conta/email.com/senha
    @GetMapping("/{email}/{senha}")
    public ResponseEntity<?> acessoLoginn(@PathVariable String email, @PathVariable String senha) {
    try {
        // Convertendo a senha recebida na URL para um hash SHA-256
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hashBytes = digest.digest(senha.getBytes());
        String senhaHash = Base64.getEncoder().encodeToString(hashBytes);

        // Buscando a conta no banco de dados pelo email
        Conta conta = conta_Repositorio.findByEmail(email);
        
        // Verificando se a conta existe e se a senha coincide
        if (conta != null && conta.getSenha().equals(senhaHash)) {
            return ResponseEntity.ok(conta.getId_conta());
            } else {
                // Retornando uma mensagem de erro personalizada
                String mensagemErro = "Conta não encontrada ou senha incorreta para o email: " + email;
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagemErro);
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Erro interno ao processar a solicitação."); // Retorna um erro 400
            }
    }


}
