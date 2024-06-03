package br.com.projeto.testeapi.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.projeto.testeapi.dto.VacinasTomadasDTO;
import br.com.projeto.testeapi.modelo.VacinasTomadas;
import br.com.projeto.testeapi.modelo.VacinasTomadasId;

@Repository
public interface VacinasTomadasRepositorio extends JpaRepository<VacinasTomadas, VacinasTomadasId> {
    @Query("SELECT vt FROM VacinasTomadas vt WHERE vt.fk_idListaVacina = :fk_idListaVacina")
    List<VacinasTomadas> findByFk_idListaVacina(@Param("fk_idListaVacina") Long fk_idListaVacina);

    @Query("SELECT new br.com.projeto.testeapi.dto.VacinasTomadasDTO(lv.id_listavacina, lv.vacina, lv.descricao, lv.quantidadeDose, lv.dataParaVacinar, vt.doseTomadas, vt.dataVacinaTomda) " +
    "FROM ListaVacina lv " +
    "INNER JOIN VacinasTomadas vt ON vt.fk_idListaVacina = lv.id_listavacina " +
    "INNER JOIN CarteiraVacina cv ON cv.id_carteiraVacina = vt.fk_idCarteiraVacina " +
    "WHERE cv.id_carteiraVacina = :fk_idCarteiraVacina")
List<VacinasTomadasDTO> findByFk_idCarteiraVacina(@Param("fk_idCarteiraVacina") Long fk_idCarteiraVacina);


    /* @Query("SELECT new br.com.projeto.testeapi.dto.VacinasTomadasDTO(lv.id_listavacina, lv.vacina, lv.descricao, lv.quantidadeDose, lv.dataParaVacinar, vt.doseTomadas, vt.dataVacinaTomda) " +
           "FROM ListaVacina lv " +
           "INNER JOIN VacinasTomadas vt ON vt.fk_idListaVacina = lv.id_listavacina " +
           "INNER JOIN CarteiraVacina cv ON cv.id_carteiraVacina = vt.fk_idCarteiraVacina " +
           "WHERE cv.id_carteiraVacina = :fk_idCarteiraVacina")
    List<VacinasTomadasDTO> findByFk_idCarteiraVacina(@Param("fk_idCarteiraVacina") Long fk_idCarteiraVacina);
 */

   

    @Query("SELECT vt FROM VacinasTomadas vt WHERE vt.fk_idListaVacina = :fk_idListaVacina AND vt.fk_idCarteiraVacina = :fk_idCarteiraVacina")
    VacinasTomadas findByFk_idListaAndFk_idCarteiraVacina(@Param("fk_idListaVacina") Long fk_idListaVacina, @Param("fk_idCarteiraVacina") Long fk_idCarteiraVacina);
}
