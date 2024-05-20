package br.com.projeto.testeapi.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.testeapi.modelo.Conta;
import br.com.projeto.testeapi.repositorio.ContaRepositorio;

@RestController
@RequestMapping("/conta")
public class ContaControle {
    
    @Autowired
    private ContaRepositorio conta_Repositorio;

    @GetMapping("/listar")
    public Iterable<Conta> listar(){
        return conta_Repositorio.findAll();
    }

    @PostMapping("/cadastrar")
    public Conta cadastrar(@RequestBody Conta obj){
        return conta_Repositorio.save(obj);
    }






}
