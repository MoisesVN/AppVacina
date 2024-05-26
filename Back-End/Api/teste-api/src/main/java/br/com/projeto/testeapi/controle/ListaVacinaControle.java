package br.com.projeto.testeapi.controle;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    // lista todas as vacinas
    @GetMapping("/listar")
    public Iterable<ListaVacina> listar(){
        return lista_Vacina_Repositorio.findAll();
    }
    // cadastrar uma nova vacina
    @PostMapping("/cadastrar")
    public ListaVacina cadastrar(@RequestBody ListaVacina obj){
        return lista_Vacina_Repositorio.save(obj);
    }
    // lista vacina por ID
    @GetMapping("vacina/{id}")
    public ResponseEntity<ListaVacina> exibirVacinaID(@PathVariable Long id) {
        Optional<ListaVacina> listavacina = lista_Vacina_Repositorio.findById(id);
        return listavacina.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    // atualizar informações da vacina
    @PutMapping("vacina/{id}")
    public ResponseEntity<ListaVacina> atualizarVacina(@PathVariable Long id, @RequestBody ListaVacina obj) {
        Optional<ListaVacina> listaVacinasOptional = lista_Vacina_Repositorio.findById(id);
        if (!listaVacinasOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        ListaVacina listaVacina = listaVacinasOptional.get();
        listaVacina.setDescricao(obj.getDescricao());
        listaVacina.setVacina(obj.getVacina());
        listaVacina.setQuantidadeDose(obj.getQuantidadeDose());
        listaVacina.setDataParaVacinar(obj.getDataParaVacinar());
        final ListaVacina atualizarVacina = lista_Vacina_Repositorio.save(listaVacina);
        return ResponseEntity.ok(atualizarVacina);
    }
    // deletar vacina
    @DeleteMapping("vacina/{id}")
    public ResponseEntity<Void> deleteListaVacinas(@PathVariable Long id) {
        if (!lista_Vacina_Repositorio.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        lista_Vacina_Repositorio.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
