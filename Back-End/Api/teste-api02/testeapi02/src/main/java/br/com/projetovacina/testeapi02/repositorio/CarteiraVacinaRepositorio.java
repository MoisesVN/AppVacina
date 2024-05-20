package br.com.projetovacina.testeapi02.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.projetovacina.testeapi02.modelo.CarteiraVacina;

@Repository
public interface CarteiraVacinaRepositorio extends CrudRepository<CarteiraVacina, Long> {
    
}
