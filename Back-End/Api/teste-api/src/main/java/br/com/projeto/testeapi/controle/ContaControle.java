package br.com.projeto.testeapi.controle;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.testeapi.modelo.Conta;
import br.com.projeto.testeapi.repositorio.ContaRepositorio;

@RestController
@RequestMapping("/conta")
public class ContaControle {
    
    @Autowired
    private ContaRepositorio conta_Repositorio;
    // lista todas as contas
    @GetMapping("/listar")
    public Iterable<Conta> listar(){
        return conta_Repositorio.findAll();
    }
    // cria um novo cadastro
    @PostMapping("/cadastrar")
    public Conta cadastrar(@RequestBody Conta obj){
        return conta_Repositorio.save(obj);
    }
    // lista conta pelo id
    @GetMapping("/{id}")
    public ResponseEntity<Conta> exibirConta(@PathVariable Long id) {
        Optional<Conta> conta = conta_Repositorio.findById(id);
        return conta.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Atualizar email do id informado
    @PutMapping("/email/{id}")
    public ResponseEntity<Conta> atualizarEmail(@PathVariable Long id, @RequestBody Conta obj){
        Conta conta = conta_Repositorio.findById(id).orElse(null);
        if (conta == null){
            return ResponseEntity.notFound().build();
        }
        conta.setEmail(obj.getEmail());
        final Conta atualizarEmail = conta_Repositorio.save(conta);
        return ResponseEntity.ok(atualizarEmail);       
    }
    // Atualizar senha do id informado
    @PutMapping("/senha/{id}")
    public ResponseEntity<Conta> atualizarSenha(@PathVariable Long id, @RequestBody Conta obj){
        Conta conta = conta_Repositorio.findById(id).orElse(null);
        if (conta == null){
            return ResponseEntity.notFound().build();
        }
        conta.setSenha(obj.getSenha());
        final Conta atualizarSenha = conta_Repositorio.save(conta);
        return ResponseEntity.ok(atualizarSenha);       
    }

    // Atualizar  telefone do id informado
    @PutMapping("/telefone/{id}")
    public ResponseEntity<Conta> atualizarTelefone(@PathVariable Long id, @RequestBody Conta obj){
        Conta conta = conta_Repositorio.findById(id).orElse(null);
        if (conta == null){
            return ResponseEntity.notFound().build();
        }
        conta.setTelefone(obj.getTelefone());
        final Conta atualizarTelefone = conta_Repositorio.save(conta);
        return ResponseEntity.ok(atualizarTelefone);       
    }
    //Deleta um registro pelo id
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deleteConta(@PathVariable Long id){
        if(!conta_Repositorio.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        conta_Repositorio.deleteById(id);
        return ResponseEntity.noContent().build();
    }















}
