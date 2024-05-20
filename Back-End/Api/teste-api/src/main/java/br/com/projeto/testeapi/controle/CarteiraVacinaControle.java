package br.com.projeto.testeapi.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    
    @GetMapping("/listar")
    public Iterable<CarteiraVacina> listar(){
        return carteira_Vacina_Reposirotorio.findAll();
    }

    @PostMapping("/cadastrar")
    public CarteiraVacina cadastrar(@RequestBody CarteiraVacina obj){
        return carteira_Vacina_Reposirotorio.save(obj);
    }

}
