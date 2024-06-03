package br.com.projeto.testeapi.controle.CarteiraVacina;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.testeapi.modelo.CarteiraVacina;
import br.com.projeto.testeapi.repositorio.CadastroRepositorio;
import br.com.projeto.testeapi.repositorio.CarteiraVacinaReposirotorio;

@RestController
@RequestMapping("/carteira-vacina")
public class PutCarteiraVacina {
    
     @Autowired
    private CarteiraVacinaReposirotorio carteira_Vacina_Reposirotorio;

    /* @Autowired
    private CadastroRepositorio cadastroRepositorio; */

    // atualizar foto da carteira de vacinação
    @PutMapping("foto/{id}")
    public ResponseEntity<String> atualizarFoto(@PathVariable Long id, @RequestBody CarteiraVacina obj){
        Optional<CarteiraVacina> carteiraOptional = carteira_Vacina_Reposirotorio.findById(id);
            if(!carteiraOptional.isPresent()){
            return ResponseEntity.notFound().build();
            }
        CarteiraVacina carteiraVacina = carteiraOptional.get();
        carteiraVacina.setFoto(obj.getFoto());
        carteira_Vacina_Reposirotorio.save(carteiraVacina);
            return ResponseEntity.ok("Foto atualizada");
            }

}
