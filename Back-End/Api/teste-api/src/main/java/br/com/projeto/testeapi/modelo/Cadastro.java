package br.com.projeto.testeapi.modelo;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cadastros")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cadastro{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cadastro;

    private String cpf;
    private String docSUS;
    private String nome;
    private LocalDate dataNasc;

    public Cadastro(Long id_cadastro, String cpf, String docSUS, String nome, LocalDate dataNasc) {
        this.id_cadastro = id_cadastro;
        this.cpf = cpf;
        this.docSUS = docSUS;
        this.nome = nome;
        this.dataNasc = dataNasc;
    }
  

   @ManyToOne
   @JoinColumn(name = "id_conta"/* , nullable = false */)
    private Conta conta;

}
