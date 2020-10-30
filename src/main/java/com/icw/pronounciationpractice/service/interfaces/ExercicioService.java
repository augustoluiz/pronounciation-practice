package com.icw.pronounciationpractice.service.interfaces;

import com.icw.pronounciationpractice.entity.Exercicio;

import java.util.List;
import java.util.Optional;

public interface ExercicioService {

    List<Exercicio> findAll();

    Optional<Exercicio> findById(Long id);

    List<Exercicio> findByUnidadeId(Long unidadeId);

    Integer qtdTotalQuestoesPorExercicioId(Long id);

    Integer qtdTotalQuestoesPorExercicioId(Long usuarioId, Long id);

}
