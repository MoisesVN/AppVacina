package br.com.projetovacina.testeapi02.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.projetovacina.testeapi02.modelo.Cadastro;

@Repository
public interface CadastroRepositorio  extends CrudRepository<Cadastro, Long>{
    
}
