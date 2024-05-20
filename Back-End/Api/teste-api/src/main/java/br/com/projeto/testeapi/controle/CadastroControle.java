package br.com.projeto.testeapi.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.testeapi.modelo.Cadastro;
import br.com.projeto.testeapi.repositorio.CadastroRepositorio;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/cadastros")
public class CadastroControle {
    
    @Autowired
    private CadastroRepositorio cadastro_Repositorio;
  
    // lista todos os cadastros
    @GetMapping("/listar")
    public Iterable<Cadastro> listar(){
        return cadastro_Repositorio.findAll();
    }

    // metado para cadastrar
    @PostMapping("/cadastrar")
    public Cadastro cadastrar(@RequestBody Cadastro obj){
        return cadastro_Repositorio.save(obj);
    }


}
