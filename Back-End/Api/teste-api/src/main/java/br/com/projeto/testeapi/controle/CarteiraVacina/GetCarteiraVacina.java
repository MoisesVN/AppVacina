package br.com.projeto.testeapi.controle.CarteiraVacina;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.testeapi.modelo.Cadastro;
import br.com.projeto.testeapi.modelo.CarteiraVacina;
import br.com.projeto.testeapi.repositorio.CarteiraVacinaReposirotorio;

@RestController
@RequestMapping("/carteira-vacina")
public class GetCarteiraVacina {
    
    @Autowired
    private CarteiraVacinaReposirotorio carteira_Vacina_Reposirotorio;

    /* @Autowired
    private CadastroRepositorio cadastroRepositorio; */

    //listar todas as carteiras de vacina
    @GetMapping("/listar")
    public Iterable<CarteiraVacina> listar(){
        return carteira_Vacina_Reposirotorio.findAll();
    }

    // listar carteira pelo id de cadastro
    @GetMapping("/listar-id/{id_cadastro}")
    public ResponseEntity<List<CarteiraVacina>> listarCVbyIDconta(@PathVariable Long id_cadastro) {
        List<CarteiraVacina> carteiraVacinas = carteira_Vacina_Reposirotorio.findIdAndFoto(id_cadastro);
        if (carteiraVacinas.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(carteiraVacinas);
    }

    // lista uma carteira de vacina pelo seu id
    @GetMapping("/carteira/{id_carteira}")
    public ResponseEntity<CarteiraVacina> exibirCarteiraID(@PathVariable Long id_carteira) {
        Optional<CarteiraVacina> carteiraVacina = carteira_Vacina_Reposirotorio.findById(id_carteira);
        return carteiraVacina.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

   /*  @GetMapping("/carteira/{id_carteiraVacina}")
    public ResponseEntity<List<CarteiraVacina>> carteriaById(@PathVariable Long id_carteiraVacina) {
        List<CarteiraVacina> carteiraVacina = carteira_Vacina_Reposirotorio.findByIdCarteira(id_carteiraVacina);
        if (carteiraVacina.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(carteiraVacina);
    } */
    @GetMapping("/foto/{id_carteira}")
    public ResponseEntity<byte[]> fotoCarteiraID(@PathVariable Long id_carteira) {
        Optional<CarteiraVacina> carteiraVacinaOptional = carteira_Vacina_Reposirotorio.findById(id_carteira);
        if (carteiraVacinaOptional.isPresent()) {
            CarteiraVacina carteiraVacina = carteiraVacinaOptional.get();
            // Retornar a imagem como um array de bytes com o tipo de conteúdo adequado
            return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG) // ou MediaType.IMAGE_PNG, dependendo do tipo de imagem
                .body(carteiraVacina.getFoto());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
