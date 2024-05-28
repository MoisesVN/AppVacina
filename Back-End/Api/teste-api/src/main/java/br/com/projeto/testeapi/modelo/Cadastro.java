package br.com.projeto.testeapi.modelo;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cadastros")
@Getter
@Setter
public class Cadastro{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cadastro;

    private String cpf;
    private String docSUS;
    private String nome;
    private LocalDate dataNasc;

  

   @ManyToOne
   @JoinColumn(name = "id_conta"/* , nullable = false */)
    private Conta conta;

}
