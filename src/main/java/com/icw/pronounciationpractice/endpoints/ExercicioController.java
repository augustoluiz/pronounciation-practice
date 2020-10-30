package com.icw.pronounciationpractice.endpoints;

import com.icw.pronounciationpractice.dto.ExercicioDTO;

import com.icw.pronounciationpractice.mapper.ExercicioMapper;
import com.icw.pronounciationpractice.service.interfaces.ExercicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/exercicio")
public class ExercicioController {

    @Autowired
    private ExercicioService exercicioService;

    @Autowired
    private ExercicioMapper exercicioMapper;

    @GetMapping
    public List<ExercicioDTO> findAll(){
        return exercicioMapper.map(exercicioService.findAll());
    }

    @GetMapping("/{id}")
    public ExercicioDTO findById(@PathVariable("id") Long id){
        return exercicioService.findById(id).map(exercicioMapper::map).orElse(null);
    }

    @GetMapping("/unidade/{id}")
    public List<ExercicioDTO> findByUnidadeId(@PathVariable("id") Long id){
        return exercicioMapper.map(exercicioService.findByUnidadeId(id));
    }

    @GetMapping("/totalQuestaoById/{id}")
    public Integer totalQuestaoById(@PathVariable("id") Long id){
        return exercicioService.qtdTotalQuestoesPorExercicioId(id);
    }

    @GetMapping("/totalQuestaoCertaById/{id}/{usuarioId}")
    public Integer totalQuestaoById(@PathVariable("id") Long id,
                                    @PathVariable("usuarioId") Long usuarioId){
        return exercicioService.qtdTotalQuestoesPorExercicioId(usuarioId, id);
    }

}
