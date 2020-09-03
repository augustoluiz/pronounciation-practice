package com.icw.pronounciationpractice.service.interfaces;

import com.icw.pronounciationpractice.entity.Questao;

import java.util.List;
import java.util.Optional;

public interface QuestaoService {

    List<Questao> findAll();

    Optional<Questao> findById(Long id);

    Optional<List<Questao>> findByExercicioId(Long id);

    Integer findQtdTotalByExercicioId(Long exercicioId);

    Integer findQtdConcluidoByExercicioId(Long usuarioId, Long exercicioId);

}
