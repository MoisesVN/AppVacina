package br.com.projeto.testeapi.controle.Cadastro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.testeapi.repositorio.CadastroRepositorio;

@RestController
@RequestMapping("/cadastros")
public class DeleteCadastro {

    @Autowired
    private CadastroRepositorio cadastro_Repositorio;

    // Deleta um registro pelo id
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<?> deleteCadastro(@PathVariable Long id) {
        if (!cadastro_Repositorio.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro: ID inválido.");
        }
        cadastro_Repositorio.deleteById(id);
        return ResponseEntity.ok("O cadastro com ID " + id + " foi deletado com sucesso.");
    }
}
