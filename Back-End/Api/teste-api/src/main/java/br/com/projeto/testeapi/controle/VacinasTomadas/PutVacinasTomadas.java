package br.com.projeto.testeapi.controle.VacinasTomadas;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.testeapi.modelo.VacinasTomadas;
import br.com.projeto.testeapi.modelo.VacinasTomadasId;
import br.com.projeto.testeapi.repositorio.VacinasTomadasRepositorio;

@RestController
@RequestMapping("/vacinas-tomadas")
public class PutVacinasTomadas {

    @Autowired
    private VacinasTomadasRepositorio vacinas_Tomdas_Repositorio;
    
    // atualziar dose tomada
    // É nescessario que seja passado na URL do Put as chaves estranjeiras de ListaVacina e CarteiraVacina
    @PutMapping("dose/{fk_idListaVacina}/{fk_idCarteiraVacina}")
    public ResponseEntity<VacinasTomadas> updateDoseTomada(@PathVariable Long fk_idListaVacina, @PathVariable Long fk_idCarteiraVacina, @RequestBody VacinasTomadas vacinasTomadasDetails) {
        VacinasTomadasId id = new VacinasTomadasId(fk_idListaVacina, fk_idCarteiraVacina);
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
    // É nescessario que seja passado na URL do Put as chaves estranjeiras de ListaVacina e CarteiraVacina
    @PutMapping("data/{fk_idListaVacina}/{fk_idCarteiraVacina}")
    public ResponseEntity<VacinasTomadas> updateDataVacina(@PathVariable Long fk_idListaVacina, @PathVariable Long fk_idCarteiraVacina, @RequestBody VacinasTomadas vacinasTomadasDetails) {
        VacinasTomadasId id = new VacinasTomadasId(fk_idListaVacina, fk_idCarteiraVacina);
        Optional<VacinasTomadas> vacinasTomadasOptional = vacinas_Tomdas_Repositorio.findById(id);
        if (!vacinasTomadasOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        VacinasTomadas vacinasTomadas = vacinasTomadasOptional.get();
        vacinasTomadas.setDataVacinaTomda(vacinasTomadasDetails.getDataVacinaTomda());
        final VacinasTomadas updatedVacinasTomadas = vacinas_Tomdas_Repositorio.save(vacinasTomadas);
        return ResponseEntity.ok(updatedVacinasTomadas);
    }
}
