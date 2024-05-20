package br.com.projeto.testeapi.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.projeto.testeapi.modelo.Cadastro;

@Repository
public interface CadastroRepositorio extends CrudRepository<Cadastro, Long>{
    
}
