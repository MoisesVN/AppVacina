package br.com.projetovacina.testeapi02.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projetovacina.testeapi02.modelo.VacinaTomada;
import br.com.projetovacina.testeapi02.repositorio.VacinaTomadaRepositorio;

@RestController
@RequestMapping("/vacinatomada")
public class VacinaTomadaConrtrole {
    
    @Autowired
    private VacinaTomadaRepositorio vacina_Tomada_Repositorio;

    @GetMapping("/listar")
    public Iterable<VacinaTomada> listar(){
        return vacina_Tomada_Repositorio.findAll();
    }
    @PostMapping("/cadastrar")
    public VacinaTomada cadastrar(@RequestBody VacinaTomada obj){
        return vacina_Tomada_Repositorio.save(obj);
    }

}
