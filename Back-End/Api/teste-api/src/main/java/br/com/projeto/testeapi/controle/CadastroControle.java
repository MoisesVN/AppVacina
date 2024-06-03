package br.com.projeto.testeapi.controle;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.testeapi.modelo.Cadastro;

import br.com.projeto.testeapi.repositorio.CadastroRepositorio;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/ofcadastros")
public class CadastroControle {
    
    @Autowired
    private CadastroRepositorio cadastro_Repositorio;

    //metado que retorna todas os cadastros que uma conta possue
    @GetMapping("/conta/{id_conta}")
    public ResponseEntity<List<Cadastro>> getCadastrosByConta(@PathVariable Long id_conta) {
        List<Cadastro> cadastros = cadastro_Repositorio.findByConta_IdConta(id_conta);
        if (cadastros.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cadastros);
    }

    // lista todos os cadastros
    @GetMapping("/listar")
    public Iterable<Cadastro> listar(){
        return cadastro_Repositorio.findAll();
    }

    // Cria um novo registro de Cadastro.
    @PostMapping("/cadastrar")
    public Cadastro cadastrar(@RequestBody Cadastro obj){
        return cadastro_Repositorio.save(obj);
    }
    // lista Cadastro pelo id
    @GetMapping("/{id}")
    public ResponseEntity<Cadastro> exibirConta(@PathVariable Long id) {
        Optional<Cadastro> cadastro = cadastro_Repositorio.findById(id);
        return cadastro.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Atualizar Nº Documento do SUS do id informado
    @PutMapping("/docsus/{id}")
    public ResponseEntity<Cadastro> atualizarDocSUS(@PathVariable Long id, @RequestBody Cadastro obj){
        Cadastro cadastro = cadastro_Repositorio.findById(id).orElse(null);
        if (cadastro == null){
            return ResponseEntity.notFound().build();
        }
        cadastro.setDocSUS(obj.getDocSUS());
        final Cadastro atualizarDocSUS = cadastro_Repositorio.save(cadastro);
        return ResponseEntity.ok(atualizarDocSUS);       
    }
    // Atualizar nome do id informado
    @PutMapping("/nome/{id}")
    public ResponseEntity<Cadastro> atualizarNome(@PathVariable Long id, @RequestBody Cadastro obj){
        Cadastro cadastro = cadastro_Repositorio.findById(id).orElse(null);
        if (cadastro == null){
            return ResponseEntity.notFound().build();
        }
        cadastro.setNome(obj.getNome());
        final Cadastro atualizarNome = cadastro_Repositorio.save(cadastro);
        return ResponseEntity.ok(atualizarNome);       
    }

    // Atualizar  data de nascimento do id informado
    @PutMapping("/datnasc/{id}")
    public ResponseEntity<Cadastro> atualizarDataNasc(@PathVariable Long id, @RequestBody Cadastro obj){
        Cadastro cadastro = cadastro_Repositorio.findById(id).orElse(null);
        if (cadastro == null){
            return ResponseEntity.notFound().build();
        }
        cadastro.setDataNasc(obj.getDataNasc());
        final Cadastro atualizarDataNasc = cadastro_Repositorio.save(cadastro);
        return ResponseEntity.ok(atualizarDataNasc);       
    }

    //Deleta um registro pelo id
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deleteCadastro(@PathVariable Long id){
        if(!cadastro_Repositorio.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        cadastro_Repositorio.deleteById(id);
        return ResponseEntity.noContent().build();
    }












}
