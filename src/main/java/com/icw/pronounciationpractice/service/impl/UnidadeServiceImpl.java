package com.icw.pronounciationpractice.service.impl;

import com.icw.pronounciationpractice.entity.Unidade;
import com.icw.pronounciationpractice.repository.UnidadeRepository;
import com.icw.pronounciationpractice.service.interfaces.UnidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UnidadeServiceImpl implements UnidadeService {

    @Autowired
    private UnidadeRepository unidadeRepository;

    @Override
    public List<Unidade> findAll() {
        return unidadeRepository.findAll();
    }

    @Override
    public Optional<Unidade> findById(Long id) {
        return unidadeRepository.findById(id);
    }

    @Override
    public Unidade save(Unidade unidade) {
        return unidadeRepository.save(unidade);
    }
}
