package com.icw.pronounciationpractice.mapper;

import com.icw.pronounciationpractice.dto.ExercicioDTO;
import com.icw.pronounciationpractice.entity.Exercicio;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface ExercicioMapper {

    default ExercicioDTO map(Exercicio exercicio){
        return converteLayout(exercicio);
    };

    default List<ExercicioDTO> map(List<Exercicio> exercicios){
        return exercicios.stream().map(e -> converteLayout(e)).collect(Collectors.toList());
    };

    default ExercicioDTO converteLayout(Exercicio exercicio){
        ExercicioDTO exercicioDTO = new ExercicioDTO();
        exercicioDTO.setId(exercicio.getId());
        exercicioDTO.setTitulo(exercicio.getTitulo());
        exercicioDTO.setOrdemApresentacao(exercicio.getOrdemApresentacao());
        exercicioDTO.setUnidadeId(exercicio.getUnidade().getId());
        System.out.println(exercicio.getUnidade().toString());
        return exercicioDTO;
    }


}
