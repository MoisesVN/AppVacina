package br.com.projeto.testeapi.modelo;




import java.time.LocalDate;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "vacinas_Tomadas")
@Getter
@Setter
@IdClass(VacinasTomdasId.class)
public class VacinasTomadas {

@Id
private Long fk_idListaVacina;

@Id
private Long fk_idCarteiraVacina;

private Integer doseTomadas;
private LocalDate dataVacinaTomda;

}

