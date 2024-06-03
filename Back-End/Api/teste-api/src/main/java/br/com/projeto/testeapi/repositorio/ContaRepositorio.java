package br.com.projeto.testeapi.repositorio;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.projeto.testeapi.modelo.Conta;

@Repository
public interface ContaRepositorio extends CrudRepository<Conta, Long> {
    Conta findByEmailAndSenha(String email, String senha);
    Conta findByEmail(String email);
    
    @Query("SELECT ct.id_conta, ct.email, ct.telefone FROM Conta ct WHERE ct.id_conta = :id_conta")
    List<Object[]> findByContaIdNot(@Param("id_conta") Long id_conta);

}
