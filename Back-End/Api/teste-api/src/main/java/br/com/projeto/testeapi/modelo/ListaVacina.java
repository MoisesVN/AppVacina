
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
@Table(name = "listaVacinas")
@Getter
@Setter
public class ListaVacina {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_listavacina;

    private String vacina;
    private String descricao;
    private int quantidadeDose;
    private int dataParaVacinar;

    @OneToMany
    @JoinColumn(name = "id_listavacina" )
    private List<VacinasTomadas> vacinasTomadas;

}
