package br.com.projeto.testeapi.modelo;




import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "vacinas_Tomadas")
@Getter
@Setter
public class VacinasTomadas {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

private int doseTomadas;

@OneToOne
@JoinColumn(name = "fk_carteiraVacina",referencedColumnName = "id_carteiraVacina")
private CarteiraVacina carteiraVacina;



}

