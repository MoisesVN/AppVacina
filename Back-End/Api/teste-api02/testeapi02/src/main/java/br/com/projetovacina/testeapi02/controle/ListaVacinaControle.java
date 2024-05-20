package br.com.projetovacina.testeapi02.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projetovacina.testeapi02.modelo.ListaVacina;
import br.com.projetovacina.testeapi02.repositorio.ListaVacinaRepositorio;

@RestController
@RequestMapping("/listavacina")
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
