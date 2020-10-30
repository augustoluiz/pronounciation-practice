package com.icw.pronounciationpractice.service.impl;

import com.icw.pronounciationpractice.entity.Exercicio;
import com.icw.pronounciationpractice.repository.ExercicioRepository;
import com.icw.pronounciationpractice.service.interfaces.ExercicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExercicioServiceImpl implements ExercicioService {

    private final float VALOR_MINIMO_CORRETO = 0.70f;

    @Autowired
    private ExercicioRepository exercicioRepository;

    @Override
    public List<Exercicio> findAll() {
        return exercicioRepository.findAll();
    }

    @Override
    public Optional<Exercicio> findById(Long id) {
        return exercicioRepository.findById(id);
    }

    @Override
    public List<Exercicio> findByUnidadeId(Long unidadeId) {
        return exercicioRepository.findByUnidadeId(unidadeId);
    }

    @Override
    public Integer qtdTotalQuestoesPorExercicioId(Long id) {
        return exercicioRepository.qtdTotalQuestoesPorExercicioId(id);
    }

    @Override
    public Integer qtdTotalQuestoesPorExercicioId(Long usuarioId, Long id) {
        return exercicioRepository.qtdTotalQuestoesCertasPorExercicioId(usuarioId, id, VALOR_MINIMO_CORRETO);
    }

}
