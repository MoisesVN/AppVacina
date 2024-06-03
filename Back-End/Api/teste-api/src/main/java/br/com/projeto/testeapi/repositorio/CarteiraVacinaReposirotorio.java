package br.com.projeto.testeapi.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.projeto.testeapi.modelo.CarteiraVacina;

@Repository
public interface CarteiraVacinaReposirotorio extends CrudRepository<CarteiraVacina, Long> {

    @Query("SELECT new br.com.projeto.testeapi.modelo.CarteiraVacina(cv.id_carteiraVacina, cv.foto) FROM CarteiraVacina cv WHERE cv.cadastro.id_cadastro = :id_cadastro")
    List<CarteiraVacina> findIdAndFoto(Long id_cadastro);

    /* @Query("SELECT cv.foto, cv.id_cadastro FROM CarteiraVacina cv WHERE cv.id_carteiraVacina = :id_CarteiraVacina")
    List<CarteiraVacina> findByIdCarteira(Long id_carteiraVacina); */
}
