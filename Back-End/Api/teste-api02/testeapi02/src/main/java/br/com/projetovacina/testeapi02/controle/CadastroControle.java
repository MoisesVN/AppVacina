package br.com.projetovacina.testeapi02.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projetovacina.testeapi02.modelo.Cadastro;
import br.com.projetovacina.testeapi02.repositorio.CadastroRepositorio;

@RestController
@RequestMapping("/cadastro")
public class CadastroControle {

    @Autowired
    private CadastroRepositorio cadastro_Repositorio;

    @GetMapping("/listar")
    public Iterable<Cadastro> listar(){
        return cadastro_Repositorio.findAll();
    }

    @PostMapping("/cadastrar")
    public Cadastro cadastrar(@RequestBody Cadastro obj){
        return cadastro_Repositorio.save(obj);
    }

}
