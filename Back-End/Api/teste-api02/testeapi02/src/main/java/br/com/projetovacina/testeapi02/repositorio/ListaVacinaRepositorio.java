package br.com.projetovacina.testeapi02.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.projetovacina.testeapi02.modelo.ListaVacina;

@Repository
public interface ListaVacinaRepositorio extends CrudRepository<ListaVacina, Long>{
    
}
