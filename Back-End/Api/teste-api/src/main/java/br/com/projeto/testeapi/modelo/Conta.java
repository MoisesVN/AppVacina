
package br.com.projeto.testeapi.modelo;



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
@Table(name  = "contas")
@Getter
@Setter
public class Conta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_conta;

    private String senha;
    private String email;
    private String telefone;

    @OneToMany
    @JoinColumn(name = "id_conta" )
    private List<Cadastro> cadastro;

}
