package br.com.projetovacina.testeapi02.modelo;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "listavacinas")
@Getter
@Setter
public class ListaVacina {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_listavacina;

    private String vacina;
    private String discricao;
    private int quantdose;
    private int datproxvacina;



}
