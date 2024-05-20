package br.com.projeto.testeapi.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.testeapi.modelo.VacinasTomadas;
import br.com.projeto.testeapi.repositorio.VacinasTomdasRepositorio;

@RestController
@RequestMapping("/vacinas-tomadas")
public class VacinasTomadasControle {

    @Autowired
    private VacinasTomdasRepositorio vacinas_Tomdas_Repositorio;
    
    @GetMapping("/listar")
    public Iterable<VacinasTomadas> listar(){
        return vacinas_Tomdas_Repositorio.findAll();
    }

    @PostMapping("/cadastrar")
    public VacinasTomadas cadastrar(@RequestBody VacinasTomadas obj){
        return vacinas_Tomdas_Repositorio.save(obj);
    }

}
