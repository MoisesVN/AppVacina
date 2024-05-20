package br.com.projetovacina.testeapi02.modelo;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "CarteiraVacinas")
@Getter
@Setter
public class CarteiraVacina {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_carteiravacina;

    private byte[] foto;

    @OneToMany
    @JoinColumn(name = "fk_carteiravacina")
    private List<Cadastro> cadastros;
    
    

}
