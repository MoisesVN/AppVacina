
package br.com.projeto.testeapi.modelo;





import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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
    @Email(message = "Email deve ser válido")
    private String email;
    @Size(min = 9, max = 11, message = "Telefone deve ter entre 9 e 11 dígitos")
    @Pattern(regexp = "\\d{9,11}", message = "Telefone deve conter apenas números")
    private String telefone;

    

}
