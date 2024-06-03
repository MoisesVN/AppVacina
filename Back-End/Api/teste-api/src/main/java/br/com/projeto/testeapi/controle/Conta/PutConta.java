package br.com.projeto.testeapi.controle.Conta;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.testeapi.modelo.Conta;
import br.com.projeto.testeapi.repositorio.ContaRepositorio;

@RestController
@RequestMapping("/conta")
public class PutConta {
    @Autowired
    private ContaRepositorio conta_Repositorio;

    // Atualiza o email da conta com o ID informado
    /*
       Este endpoint faz uma chamada PUT para atualizar o email de uma conta específica.
       Parâmetros:
       - id: o ID da conta a ser atualizada
       - obj: o objeto Conta contendo o novo email
       Retorna:
       - ResponseEntity com a conta atualizada (HTTP 200)
       - ResponseEntity com status 404 (não encontrado) se a conta não for encontrada

        Exmplo:
        http://localhost:8080/conta/email/1 
        Body:
            {
            "email":"novo@email.com"
            }
    */
    @PutMapping("/email/{id}")
    public ResponseEntity<String> atualizarEmail(@PathVariable Long id, @RequestBody Conta obj){
    Conta conta = conta_Repositorio.findById(id).orElse(null);
    if (conta == null){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Conta não encontrada para atualização do email");
    }
    conta.setEmail(obj.getEmail());
    final Conta atualizarEmail = conta_Repositorio.save(conta);
    // Retornar uma mensagem indicando que o email foi atualizado com sucesso
    String mensagem = "Email atualizado com sucesso para: " + atualizarEmail.getEmail();
    return ResponseEntity.ok(mensagem);       
}

    // Atualiza a senha da conta com o ID informado
    /*
       Este endpoint faz uma chamada PUT para atualizar a senha de uma conta específica.
       Parâmetros:
       - id: o ID da conta a ser atualizada
       - obj: o objeto Conta contendo a nova senha
       Retorna:
       - ResponseEntity com a conta atualizada (HTTP 200)
       - ResponseEntity com status 404 (não encontrado) se a conta não for encontrada

       Exmplo:
        http://localhost:8080/conta/senha/1
        Body:
            {
            "senha":"nov@Senha"
            }       
    */
    @PutMapping("/senha/{id}")
    public ResponseEntity<String> atualizarSenha(@PathVariable Long id, @RequestBody Conta obj){
    Conta conta = conta_Repositorio.findById(id).orElse(null);
    if (conta == null){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Conta não encontrada para atualização da senha");
        }
    
    try {
        // Convertendo a nova senha em um hash utilizando SHA-256
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hashBytes = digest.digest(obj.getSenha().getBytes());
        
        // Convertendo o hash para uma string em Base64
        String senhaHash = Base64.getEncoder().encodeToString(hashBytes);
        
        // Atualizando a senha hasheada no objeto Conta
        conta.setSenha(senhaHash);
        
        // Salvando a conta com a senha atualizada no repositório
        final Conta atualizarSenha = conta_Repositorio.save(conta);
        
        // Retornando uma mensagem de sucesso
        String mensagem = "Senha atualizada com sucesso";
        return ResponseEntity.ok(mensagem);
        } catch (NoSuchAlgorithmException e) {
        // Tratamento de erro para o caso de o algoritmo de hash não ser suportado
        e.printStackTrace();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                             .body("Erro ao atualizar a senha.");
        }
}

    // Atualiza o telefone da conta com o ID informado
    /*
       Este endpoint faz uma chamada PUT para atualizar o telefone de uma conta específica.
       Parâmetros:
       - id: o ID da conta a ser atualizada
       - obj: o objeto Conta contendo o novo telefone
       Retorna:
       - ResponseEntity com a conta atualizada (HTTP 200)
       - ResponseEntity com status 404 (não encontrado) se a conta não for encontrada

       Exmplo:
        http://localhost:8080/conta/telefone/1
        Body:
            {
            "telefone":"81912345678"
            }        
    */
    @PutMapping("/telefone/{id}")
    public ResponseEntity<String> atualizarTelefone(@PathVariable Long id, @RequestBody Conta obj){
        Conta conta = conta_Repositorio.findById(id).orElse(null);
        if (conta == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Conta não encontrada para atualização do telefone");
        }
        conta.setTelefone(obj.getTelefone());
        final Conta atualizarTelefone = conta_Repositorio.save(conta);
        // Retornar uma mensagem indicando que o telefone foi atualizado com sucesso
        String mensagem = "Telefone atualizado com sucesso para: " + atualizarTelefone.getTelefone();
        return ResponseEntity.ok(mensagem);       
    }
}
