package br.com.projeto.testeapi.controle.Cadastro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.testeapi.modelo.Cadastro;
import br.com.projeto.testeapi.repositorio.CadastroRepositorio;

@RestController
@RequestMapping("/cadastros")
public class PutCadastro {

    @Autowired
    private CadastroRepositorio cadastro_Repositorio;

    
    // Atualizar Nº Documento do SUS do id informado
    @PutMapping("/docsus/{id}")
    public ResponseEntity<?> atualizarDocSUS(@PathVariable Long id, @RequestBody Cadastro obj) {
        Cadastro cadastro = cadastro_Repositorio.findById(id).orElse(null);
        if (cadastro == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro: ID inválido.");
        }
        cadastro.setDocSUS(obj.getDocSUS());
        Cadastro atualizarDocSUS = cadastro_Repositorio.save(cadastro);
        return ResponseEntity.ok("O documento SUS foi atualizado com sucesso.");
    }

    // Atualizar nome do id informado
    @PutMapping("/nome/{id}")
    public ResponseEntity<?> atualizarNome(@PathVariable Long id, @RequestBody Cadastro obj) {
        Cadastro cadastro = cadastro_Repositorio.findById(id).orElse(null);
        if (cadastro == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro: ID inválido.");
        }
        cadastro.setNome(obj.getNome());
        Cadastro atualizarNome = cadastro_Repositorio.save(cadastro);
        return ResponseEntity.ok("O nome foi atualizado com sucesso.");
    }

    // Atualizar data de nascimento do id informado
    @PutMapping("/datanasc/{id}")
    public ResponseEntity<?> atualizarDataNasc(@PathVariable Long id, @RequestBody Cadastro obj) {
        Cadastro cadastro = cadastro_Repositorio.findById(id).orElse(null);
        if (cadastro == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro: ID inválido.");
        }
        cadastro.setDataNasc(obj.getDataNasc());
        Cadastro atualizarDataNasc = cadastro_Repositorio.save(cadastro);
        return ResponseEntity.ok("A data de nascimento foi atualizada com sucesso.");
    }

}
