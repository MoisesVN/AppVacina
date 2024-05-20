package br.com.projeto.testeapi.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.testeapi.modelo.ListaVacina;
import br.com.projeto.testeapi.repositorio.ListaVacinaRepositorio;

@RestController
@RequestMapping("/lista-vacina")
public class ListaVacinaControle {
    
    @Autowired
    private ListaVacinaRepositorio lista_Vacina_Repositorio;

    @GetMapping("/listar")
    public Iterable<ListaVacina> listar(){
        return lista_Vacina_Repositorio.findAll();
    }

    @PostMapping("/cadastrar")
    public ListaVacina cadastrar(@RequestBody ListaVacina obj){
        return lista_Vacina_Repositorio.save(obj);
    }


}
