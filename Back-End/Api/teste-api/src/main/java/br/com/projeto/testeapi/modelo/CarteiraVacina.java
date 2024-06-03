
package br.com.projeto.testeapi.modelo;



import jakarta.persistence.Column;
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
@Table(name = "carteiraVacinas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarteiraVacina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_carteiraVacina;

    @Column(columnDefinition = "MEDIUMBLOB") // Defina o tamanho adequado para suas imagens
    private byte[] foto;
    
    public CarteiraVacina(Long id_carteiraVacina, byte[] foto) {
        this.id_carteiraVacina = id_carteiraVacina;
        this.foto = foto;
    }
    
    @ManyToOne
    @JoinColumn(name = "id_cadastro"/* , nullable = false */)
    private Cadastro cadastro;

}
