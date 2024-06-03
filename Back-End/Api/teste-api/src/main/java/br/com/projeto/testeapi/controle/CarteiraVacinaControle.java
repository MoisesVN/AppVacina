package br.com.projeto.testeapi.controle;

import java.util.List;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.projeto.testeapi.modelo.Cadastro;
import br.com.projeto.testeapi.modelo.CarteiraVacina;
import br.com.projeto.testeapi.repositorio.CadastroRepositorio;
import br.com.projeto.testeapi.repositorio.CarteiraVacinaReposirotorio;

@RestController
@RequestMapping("/ofcarteira-vacina")
public class CarteiraVacinaControle {

    @Autowired
    private CarteiraVacinaReposirotorio carteira_Vacina_Reposirotorio;

    @Autowired
    private CadastroRepositorio cadastroRepositorio;
    
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


    // cadastrar uma nova carteira de vacina
    // Deve passar na URL o chave estrajeira de cadastro como id_cadastro e foto
    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestParam("id_cadastro") Long idCadastro,
                                       @RequestParam("foto") MultipartFile file) {
        try {
            Optional<Cadastro> cadastroOptional = cadastroRepositorio.findById(idCadastro);
            if (!cadastroOptional.isPresent()) {
                return ResponseEntity.badRequest().body("Cadastro não encontrado.");
            }

            Cadastro cadastro = cadastroOptional.get();
            CarteiraVacina carteiraVacina = new CarteiraVacina(idCadastro, null, cadastro);
            carteiraVacina.setCadastro(cadastro);
            carteiraVacina.setFoto(file.getBytes());

            carteira_Vacina_Reposirotorio.save(carteiraVacina);
            return ResponseEntity.ok("Carteira de vacina cadastrada com sucesso.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro ao cadastrar carteira de vacina: " + e.getMessage());
        }
    }

    // lista uma carteira de vacina pelo id de cadastro
    @GetMapping("/carteira/{id}")
    public ResponseEntity<CarteiraVacina> exibirCarteiraID(@PathVariable Long id) {
        Optional<CarteiraVacina> carteiraVacina = carteira_Vacina_Reposirotorio.findById(id);
        return carteiraVacina.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // atualizar foto da carteira de vacinação
    @PutMapping("/foto/{id}")
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
