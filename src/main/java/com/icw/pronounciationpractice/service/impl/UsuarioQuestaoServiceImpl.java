package com.icw.pronounciationpractice.service.impl;

import com.icw.pronounciationpractice.entity.UsuarioQuestao;
import com.icw.pronounciationpractice.repository.UsuarioQuestaoRepository;
import com.icw.pronounciationpractice.service.interfaces.UsuarioQuestaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioQuestaoServiceImpl implements UsuarioQuestaoService {

    @Autowired
    private UsuarioQuestaoRepository usuarioQuestaoRepository;

    @Override
    public Optional<UsuarioQuestao> findByQuestaoId(Long usuarioId, Long questaoId) {
        return usuarioQuestaoRepository.findByQuestaoId(usuarioId, questaoId);
    }

    @Override
    public UsuarioQuestao save(UsuarioQuestao usuarioQuestao) {
        return usuarioQuestaoRepository.save(usuarioQuestao);
    }
}
