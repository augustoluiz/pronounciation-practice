package com.icw.pronounciationpractice.mapper;

import com.icw.pronounciationpractice.dto.QuestaoDTO;
import com.icw.pronounciationpractice.entity.Questao;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface QuestaoMapper {

    default QuestaoDTO map(Questao questao){
        return converteLayout(questao);
    }

    default List<QuestaoDTO> map(List<Questao> questoes){
        return questoes.stream().map(questao -> converteLayout(questao)).collect(Collectors.toList());
    }

    default QuestaoDTO converteLayout (Questao questao){
        QuestaoDTO questaoDTO = new QuestaoDTO();
        questaoDTO.setId(questao.getId());
        questaoDTO.setTexto(questao.getTexto());
        questaoDTO.setOrdemApresentacao(questao.getOrdemApresentacao());
        questaoDTO.setExercicioId(questao.getExercicio().getId());
        return questaoDTO;
    }
}
