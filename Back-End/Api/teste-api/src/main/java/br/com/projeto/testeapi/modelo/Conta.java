
package br.com.projeto.testeapi.modelo;





import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name  = "contas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Conta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_conta;

    private String senha;
    private String email;
    private String telefone;

    

}
