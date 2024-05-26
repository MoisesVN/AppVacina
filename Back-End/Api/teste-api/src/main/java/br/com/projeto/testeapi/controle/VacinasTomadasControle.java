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

import br.com.projeto.testeapi.modelo.VacinasTomadas;
import br.com.projeto.testeapi.modelo.VacinasTomdasId;
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

    @GetMapping("/{fk_idListaVacina}/{fk_idCarteiraVacina}")
    public ResponseEntity<VacinasTomadas> exibirVacinaTomadaIDs(@PathVariable Long fk_idListaVacina, @PathVariable Long fk_idCarteiraVacina) {
         VacinasTomdasId id = new VacinasTomdasId(fk_idListaVacina,fk_idCarteiraVacina);
        Optional<VacinasTomadas> vacinasTomadas = vacinas_Tomdas_Repositorio.findById(id);
        return vacinasTomadas.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    // atualziar dose tomada
    @PutMapping("dose/{fk_idListaVacina}/{fk_idCarteiraVacina}")
    public ResponseEntity<VacinasTomadas> updateDoseTomada(@PathVariable Long fk_idListaVacina, @PathVariable Long fk_idCarteiraVacina, @RequestBody VacinasTomadas vacinasTomadasDetails) {
        VacinasTomdasId id = new VacinasTomdasId(fk_idListaVacina, fk_idCarteiraVacina);
        Optional<VacinasTomadas> vacinasTomadasOptional = vacinas_Tomdas_Repositorio.findById(id);
        if (!vacinasTomadasOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        VacinasTomadas vacinasTomadas = vacinasTomadasOptional.get();
        vacinasTomadas.setDoseTomadas(vacinasTomadasDetails.getDoseTomadas());
        final VacinasTomadas updatedVacinasTomadas = vacinas_Tomdas_Repositorio.save(vacinasTomadas);
        return ResponseEntity.ok(updatedVacinasTomadas);
    }
    // atualziar data da vacina tomada
    @PutMapping("data/{fk_idListaVacina}/{fk_idCarteiraVacina}")
    public ResponseEntity<VacinasTomadas> updateDataVacina(@PathVariable Long fk_idListaVacina, @PathVariable Long fk_idCarteiraVacina, @RequestBody VacinasTomadas vacinasTomadasDetails) {
        VacinasTomdasId id = new VacinasTomdasId(fk_idListaVacina, fk_idCarteiraVacina);
        Optional<VacinasTomadas> vacinasTomadasOptional = vacinas_Tomdas_Repositorio.findById(id);
        if (!vacinasTomadasOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        VacinasTomadas vacinasTomadas = vacinasTomadasOptional.get();
        vacinasTomadas.setDataVacinaTomda(vacinasTomadasDetails.getDataVacinaTomda());
        final VacinasTomadas updatedVacinasTomadas = vacinas_Tomdas_Repositorio.save(vacinasTomadas);
        return ResponseEntity.ok(updatedVacinasTomadas);
    }









    @DeleteMapping("/{fk_idListaVacina}/{fk_idCarteiraVacina}")
    public ResponseEntity<Void> deleteVacinasTomadas(@PathVariable Long fk_idListaVacina, @PathVariable Long fk_idCarteiraVacina) {
        VacinasTomdasId id = new VacinasTomdasId(fk_idListaVacina, fk_idCarteiraVacina);
        if (!vacinas_Tomdas_Repositorio.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        vacinas_Tomdas_Repositorio.deleteById(id);
        return ResponseEntity.noContent().build();
    }



}
