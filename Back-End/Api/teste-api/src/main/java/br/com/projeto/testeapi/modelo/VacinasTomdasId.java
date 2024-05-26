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
public class VacinasTomdasId implements Serializable {

    private Long fk_idListaVacina;
    private Long fk_idCarteiraVacina;

    /* public VacinasTomdasId() {}

    public VacinasTomdasId(Long fk_idListaVacina, Long fk_idCarteiraVacina) {
        this.fk_idListaVacina = fk_idListaVacina;
        this.fk_idCarteiraVacina = fk_idCarteiraVacina;
    } */
}
