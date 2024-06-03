package br.com.projeto.testeapi.controle.VacinasTomadas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.testeapi.modelo.VacinasTomadasId;
import br.com.projeto.testeapi.repositorio.VacinasTomadasRepositorio;

@RestController
@RequestMapping("/vacinas-tomadas")
public class DeleteVacinasTomdas {

    @Autowired
    private VacinasTomadasRepositorio vacinas_Tomdas_Repositorio;

    // Deleta a tabela Entidade Relacionamento de ListaVacina e CarteiraVacina
    // É nescessario que seja passado na URL do Put as chaves estranjeiras de ListaVacina e CarteiraVacina
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
