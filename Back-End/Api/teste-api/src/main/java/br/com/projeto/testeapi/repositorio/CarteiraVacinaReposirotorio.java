package br.com.projeto.testeapi.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.projeto.testeapi.modelo.CarteiraVacina;

@Repository
public interface CarteiraVacinaReposirotorio extends CrudRepository<CarteiraVacina, Long> {
    
}
