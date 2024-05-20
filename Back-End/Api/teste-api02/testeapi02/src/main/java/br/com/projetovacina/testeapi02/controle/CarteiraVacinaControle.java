package br.com.projetovacina.testeapi02.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projetovacina.testeapi02.modelo.CarteiraVacina;
import br.com.projetovacina.testeapi02.repositorio.CarteiraVacinaRepositorio;

@RestController
@RequestMapping("/carteiravacina")
public class CarteiraVacinaControle {
    
    @Autowired
    private CarteiraVacinaRepositorio carteira_Vacina_Repositorio;

    @GetMapping("/listar")
    public Iterable<CarteiraVacina> listar(){
        return carteira_Vacina_Repositorio.findAll();
    }

    @PostMapping("/cadastrar")
    public CarteiraVacina cadastrar(@RequestBody CarteiraVacina obj){
        return carteira_Vacina_Repositorio.save(obj);
    }


}
