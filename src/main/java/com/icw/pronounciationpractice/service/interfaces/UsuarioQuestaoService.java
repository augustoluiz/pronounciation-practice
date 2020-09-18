package com.icw.pronounciationpractice.service.interfaces;
import com.icw.pronounciationpractice.entity.UsuarioQuestao;

import java.util.Optional;

public interface UsuarioQuestaoService {

    Optional<UsuarioQuestao> findByQuestaoId(Long usuarioId, Long questaoId);

    UsuarioQuestao save(UsuarioQuestao usuarioQuestao);

    int calculateStatusByQuestionId(Long usuarioId, Long questionId);
}
