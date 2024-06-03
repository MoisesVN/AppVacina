package br.com.projeto.testeapi.controle;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import br.com.projeto.testeapi.dto.VacinasTomadasDTO;
import br.com.projeto.testeapi.modelo.VacinasTomadas;
import br.com.projeto.testeapi.modelo.VacinasTomadasId;
import br.com.projeto.testeapi.repositorio.VacinasTomadasRepositorio;

@RestController
@RequestMapping("/ofvacinas-tomadas")
public class VacinasTomadasControle {

    @Autowired
    private VacinasTomadasRepositorio vacinas_Tomdas_Repositorio;
    
    @GetMapping("/listar")
    public Iterable<VacinasTomadas> listar(){
        return vacinas_Tomdas_Repositorio.findAll();
    }


    private static final Logger logger = LoggerFactory.getLogger(VacinasTomadasControle.class);
    
    @GetMapping("/por-carteira/{idCarteira}")
    public ResponseEntity<List<VacinasTomadasDTO>> buscarPorCarteira(@PathVariable Long idCarteira) {
        logger.info("Buscando vacinas tomadas para a carteira de vacina com ID: {}", idCarteira);
        List<VacinasTomadasDTO> vacinas = vacinas_Tomdas_Repositorio.findByFk_idCarteiraVacina(idCarteira);
        logger.info("Número de vacinas encontradas: {}", vacinas.size());
        if (vacinas.isEmpty()) {
            logger.warn("Nenhuma vacina encontrada para a carteira de vacina com ID: {}", idCarteira);
            return ResponseEntity.notFound().build();
        }
        for (VacinasTomadasDTO vacina : vacinas) {
            logger.info("Vacina encontrada: {}", vacina);
        }
        return ResponseEntity.ok(vacinas);
    }
    

    /* @GetMapping("/por-carteira/{idCarteira}")
    public ResponseEntity<List<VacinasTomadasDTO>> buscarPorCarteira(@PathVariable Long idCarteira) {
        logger.info("Buscando vacinas tomadas para a carteira de vacina com ID: {}", idCarteira);
        List<VacinasTomadasDTO> vacinas = vacinas_Tomdas_Repositorio.findByFk_idCarteiraVacina(idCarteira);
        if (vacinas.isEmpty()) {
            logger.warn("Nenhuma vacina encontrada para a carteira de vacina com ID: {}", idCarteira);
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(vacinas);
    } */


    @GetMapping("/{fk_idListaVacina}/{fk_idCarteiraVacina}")
    public ResponseEntity<VacinasTomadas> exibirVacinaTomadaIDs(@PathVariable Long fk_idListaVacina, @PathVariable Long fk_idCarteiraVacina) {
         VacinasTomadasId id = new VacinasTomadasId(fk_idListaVacina,fk_idCarteiraVacina);
        Optional<VacinasTomadas> vacinasTomadas = vacinas_Tomdas_Repositorio.findById(id);
        return vacinasTomadas.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/cadastrar")
    public VacinasTomadas cadastrar(@RequestBody VacinasTomadas obj){
        return vacinas_Tomdas_Repositorio.save(obj);
    }

    // atualziar dose tomada
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









    @DeleteMapping("/{fk_idListaVacina}/{fk_idCarteiraVacina}")
    public ResponseEntity<Void> deleteVacinasTomadas(@PathVariable Long fk_idListaVacina, @PathVariable Long fk_idCarteiraVacina) {
        VacinasTomadasId id = new VacinasTomadasId(fk_idListaVacina, fk_idCarteiraVacina);
        if (!vacinas_Tomdas_Repositorio.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        vacinas_Tomdas_Repositorio.deleteById(id);
        return ResponseEntity.noContent().build();
    }



}
