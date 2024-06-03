package br.com.projeto.testeapi.controle.VacinasTomadas;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.testeapi.controle.VacinasTomadasControle;
import br.com.projeto.testeapi.dto.VacinasTomadasDTO;
import br.com.projeto.testeapi.modelo.VacinasTomadas;
import br.com.projeto.testeapi.repositorio.VacinasTomadasRepositorio;

@RestController
@RequestMapping("/vacinas-tomadas")
public class GetVacinasTomadas {
    
    @Autowired
    private VacinasTomadasRepositorio vacinas_Tomdas_Repositorio;  


    //Lista todfa tabela de vacinas tomdas
    @GetMapping("/listar")
    public Iterable<VacinasTomadas> listar(){
        return vacinas_Tomdas_Repositorio.findAll();
    }

    private static final Logger logger = LoggerFactory.getLogger(VacinasTomadasControle.class);

    // Lista vacinas tomdas ao passar o ID da carteira de vacinação
    @GetMapping("/por-carteira/{idCarteira}")
    public ResponseEntity<List<VacinasTomadasDTO>> buscarPorCarteira(@PathVariable Long idCarteira) {
        logger.info("Buscando vacinas tomadas para a carteira de vacina com ID: {}", idCarteira);
        List<VacinasTomadasDTO> vacinas = vacinas_Tomdas_Repositorio.findByFk_idCarteiraVacina(idCarteira);
        logger.info("Número de vacinas encontradas: {}", vacinas.size());
        if (vacinas.isEmpty()) {
            logger.warn("Nenhuma vacina encontrada para a carteira de vacina com ID: {}", idCarteira);
            return ResponseEntity.notFound().build();
        }
        for (VacinasTomadasDTO vacina : vacinas) {
            logger.info("Vacina encontrada: {}", vacina);
        }
        return ResponseEntity.ok(vacinas);
    }



}
