package br.com.projetovacina.testeapi02.modelo;

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
@Table(name = "vacinastomadas")
@Getter
@Setter
public class VacinaTomada {
  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_vacinatomada;

    private int dosetomada;

    /* @OneToOne
    @JoinColumn(name = "fk_carteiravacina",referencedColumnName = "id_carteiravacina")
    private CarteiraVacina carteiraVacina; */

    @OneToMany
    @JoinColumn(name = "fk_vacinatomada")
    private List<ListaVacina> listaVacinas;

}
