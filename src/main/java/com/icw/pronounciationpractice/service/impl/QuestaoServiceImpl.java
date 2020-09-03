package com.icw.pronounciationpractice.service.impl;

import com.icw.pronounciationpractice.entity.Questao;
import com.icw.pronounciationpractice.repository.QuestaoRepository;
import com.icw.pronounciationpractice.service.interfaces.QuestaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestaoServiceImpl implements QuestaoService {

    private final float VALOR_MINIMO_CORRETO = 0.70f;

    @Autowired
    private QuestaoRepository questaoRepository;

    @Override
    public List<Questao> findAll() {
        questaoRepository.findAll().forEach(e -> System.out.println(e.toString()));
        return questaoRepository.findAll();
    }

    @Override
    public Optional<Questao> findById(Long id) {
        return questaoRepository.findById(id);
    }

    @Override
    public Optional<List<Questao>> findByExercicioId(Long id) {
        return questaoRepository.findByExercicioId(id);
    }

    @Override
    public Integer findQtdTotalByExercicioId(Long exercicioId) {
        return questaoRepository.findQtdTotalByExercicioId(exercicioId);
    }

    @Override
    public Integer findQtdConcluidoByExercicioId(Long usuarioId, Long exercicioId) {
        return questaoRepository.findQtdConcluidoByExercicioId(exercicioId, usuarioId, VALOR_MINIMO_CORRETO);
    }
}
