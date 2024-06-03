package br.com.projeto.testeapi.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class VacinasTomadasId implements Serializable {

    private Long fk_idListaVacina;
    private Long fk_idCarteiraVacina;

}
