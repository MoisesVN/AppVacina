package br.com.projeto.testeapi.controle.CarteiraVacina;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.projeto.testeapi.modelo.Cadastro;
import br.com.projeto.testeapi.modelo.CarteiraVacina;
import br.com.projeto.testeapi.repositorio.CadastroRepositorio;
import br.com.projeto.testeapi.repositorio.CarteiraVacinaReposirotorio;

@RestController
@RequestMapping("/carteira-vacina")
public class PostCarteiraVacina {

    @Autowired
    private CarteiraVacinaReposirotorio carteira_Vacina_Reposirotorio;

    @Autowired
    private CadastroRepositorio cadastroRepositorio;

    // cadastrar uma nova carteira de vacina
    // É apenas obrigatorio passar no corpo do Post a chave estrajeira de cadastro, a foto é opcional
    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestParam("id_cadastro") Long idCadastro,
                                   @RequestParam(value = "foto", required = false) MultipartFile file) {
    try {
        Optional<Cadastro> cadastroOptional = cadastroRepositorio.findById(idCadastro);
        if (!cadastroOptional.isPresent()) {
            return ResponseEntity.badRequest().body("Cadastro não encontrado.");
        }

        Cadastro cadastro = cadastroOptional.get();

        // Criar uma nova instância de CarteiraVacina com um novo ID único
        CarteiraVacina carteiraVacina = new CarteiraVacina();
        carteiraVacina.setCadastro(cadastro);

        // Verifica se a foto foi enviada
        if (file != null && !file.isEmpty()) {
            carteiraVacina.setFoto(file.getBytes());
        }

        carteira_Vacina_Reposirotorio.save(carteiraVacina);
        
        return ResponseEntity.ok("Carteira de vacina cadastrada com sucesso.");
    } catch (Exception e) {
        return ResponseEntity.status(500).body("Erro ao cadastrar carteira de vacina: " + e.getMessage());
    }
}

    
    /*@PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestParam("id_cadastro") Long idCadastro,
                                   @RequestParam(value = "foto", required = false) MultipartFile file) {
    try {
        Optional<Cadastro> cadastroOptional = cadastroRepositorio.findById(idCadastro);
        if (!cadastroOptional.isPresent()) {
            return ResponseEntity.badRequest().body("Cadastro não encontrado.");
        }

        Cadastro cadastro = cadastroOptional.get();
        CarteiraVacina carteiraVacina = new CarteiraVacina(idCadastro, null, cadastro);

        // Verifica se a foto foi enviada
        if (file != null && !file.isEmpty()) {
            carteiraVacina.setFoto(file.getBytes());
        }

        carteira_Vacina_Reposirotorio.save(carteiraVacina);
        return ResponseEntity.ok("Carteira de vacina cadastrada com sucesso.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro ao cadastrar carteira de vacina: " + e.getMessage());
        }
    }*/
   
}
