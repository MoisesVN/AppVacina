package br.com.projeto.testeapi.controle.CarteiraVacina;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.testeapi.repositorio.CarteiraVacinaReposirotorio;

@RestController
@RequestMapping("/carteira-vacina")
public class DeleteCarteiraVacina {

    @Autowired
    private CarteiraVacinaReposirotorio carteira_Vacina_Reposirotorio;

    // deletar carteira
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deleteCarteiraVacina(@PathVariable Long id) {
        if (!carteira_Vacina_Reposirotorio.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        carteira_Vacina_Reposirotorio.deleteById(id);
        return ResponseEntity.ok("Carteira deletada");
        }
}
