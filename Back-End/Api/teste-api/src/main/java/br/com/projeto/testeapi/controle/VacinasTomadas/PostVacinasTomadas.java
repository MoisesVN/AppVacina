package br.com.projeto.testeapi.controle.VacinasTomadas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.testeapi.modelo.VacinasTomadas;
import br.com.projeto.testeapi.repositorio.VacinasTomadasRepositorio;

@RestController
@RequestMapping("/vacinas-tomadas")
public class PostVacinasTomadas {

    @Autowired
    private VacinasTomadasRepositorio vacinas_Tomdas_Repositorio;

    //Cadastrar VacinasTomdas que uma entidade relacionamento
    /* Estrutura JSON de como deve passar via Post

        {
            "fk_idCarteiraVacina":1,
            "fk_idListaVacina":2,
            "doseTomadas":1,
            "dataVacinaTomda":"2021-05-22"
        }

     */
    @PostMapping("/cadastrar")
    public VacinasTomadas cadastrar(@RequestBody VacinasTomadas obj){
        return vacinas_Tomdas_Repositorio.save(obj);
    }
}
