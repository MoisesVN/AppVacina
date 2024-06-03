package br.com.projeto.testeapi.repositorio;




import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.projeto.testeapi.modelo.Cadastro;


@Repository
public interface CadastroRepositorio extends CrudRepository<Cadastro, Long>{
    @Query("SELECT new br.com.projeto.testeapi.modelo.Cadastro(c.id_cadastro, c.cpf, c.docSUS, c.nome, c.dataNasc) FROM Cadastro c WHERE c.conta.id_conta = :id_conta")
    List<Cadastro> findByConta_IdConta(Long id_conta);

    @Query("SELECT new br.com.projeto.testeapi.modelo.Cadastro(c.id_cadastro, c.cpf, c.docSUS, c.nome, c.dataNasc) FROM Cadastro c WHERE c.id_cadastro = :id_cadastro")
    List<Cadastro> findByIdCadastro(Long id_cadastro);
}
