package br.com.projeto.testeapi.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.projeto.testeapi.modelo.VacinasTomadas;
import br.com.projeto.testeapi.modelo.VacinasTomdasId;

@Repository
public interface VacinasTomdasRepositorio extends JpaRepository <VacinasTomadas, VacinasTomdasId> {
    
}
