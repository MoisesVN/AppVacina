
package br.com.projeto.testeapi.modelo;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "carteiraVacinas")
@Getter
@Setter
public class CarteiraVacina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_carteiraVacina;

    @Lob
    private byte[] foto;
    
    

    


}
