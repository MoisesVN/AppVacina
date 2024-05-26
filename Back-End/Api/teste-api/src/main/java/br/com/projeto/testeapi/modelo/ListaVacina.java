
package br.com.projeto.testeapi.modelo;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "listaVacinas")
@Getter
@Setter
public class ListaVacina {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_listavacina;

    private String vacina;
    private String descricao;
    private Integer quantidadeDose;
    private Integer dataParaVacinar;

}
