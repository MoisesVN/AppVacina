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

import br.com.projeto.testeapi.modelo.CarteiraVacina;
import br.com.projeto.testeapi.repositorio.CarteiraVacinaReposirotorio;

@RestController
@RequestMapping("/carteira-vacina")
public class CarteiraVacinaControle {

    @Autowired
    private CarteiraVacinaReposirotorio carteira_Vacina_Reposirotorio;
    
    //listar todas as carteiras de vacina
    @GetMapping("/listar")
    public Iterable<CarteiraVacina> listar(){
        return carteira_Vacina_Reposirotorio.findAll();
    }
    //cadastra uma carteira de vacina
    @PostMapping("/cadastrar")
    public CarteiraVacina cadastrar(@RequestBody CarteiraVacina obj){
        return carteira_Vacina_Reposirotorio.save(obj);
    }
    // lista uma carteira de vacina pelo id de cadastro
    @GetMapping("carteira/{id}")
    public ResponseEntity<CarteiraVacina> exibirCarteiraID(@PathVariable Long id) {
        Optional<CarteiraVacina> carteiraVacina = carteira_Vacina_Reposirotorio.findById(id);
        return carteiraVacina.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // atualizar foto da carteira de vacinação
    @PutMapping("foto/{id}")
    public ResponseEntity<CarteiraVacina> atualizarFoto(@PathVariable Long id, @RequestBody CarteiraVacina obj){
        Optional<CarteiraVacina> carteiraOptional = carteira_Vacina_Reposirotorio.findById(id);
        if(!carteiraOptional.isPresent()){
            return ResponseEntity.notFound().build();
        }
        CarteiraVacina carteiraVacina = carteiraOptional.get();
        carteiraVacina.setFoto(obj.getFoto());
        final CarteiraVacina atualizarFoto = carteira_Vacina_Reposirotorio.save(carteiraVacina);
        return ResponseEntity.ok(atualizarFoto);
    }

    // deletar carteira
    @DeleteMapping("deletar/{id}")
    public ResponseEntity<Void> deleteCarteiraVacina(@PathVariable Long id) {
        if (!carteira_Vacina_Reposirotorio.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        carteira_Vacina_Reposirotorio.deleteById(id);
        return ResponseEntity.noContent().build();
    }



















}
