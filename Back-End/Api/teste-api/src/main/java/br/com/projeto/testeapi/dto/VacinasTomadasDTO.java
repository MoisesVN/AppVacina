package br.com.projeto.testeapi.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VacinasTomadasDTO {
    private Long id_listavacina;
    private String vacina;
    private String descricao;
    private Integer quantidadeDose;
    private Integer dataParaVacinar;
    private Integer doseTomadas;
    private LocalDate dataVacinaTomda;

    


}
