package br.com.projetovacina.testeapi02.modelo;

import java.time.LocalDate;
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
@Table(name = "cadastros")
@Getter
@Setter
public class Cadastro {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_cadastro;

    private String cpf;
    private String docsus;
    private String nome;
    private LocalDate datanasc;

    

    @OneToMany
    @JoinColumn(name = "fk_cadastro")
    private List<Conta> contas;

}
