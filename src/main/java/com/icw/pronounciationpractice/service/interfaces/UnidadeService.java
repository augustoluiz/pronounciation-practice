package com.icw.pronounciationpractice.service.interfaces;

import com.icw.pronounciationpractice.entity.Unidade;

import java.util.List;
import java.util.Optional;

public interface UnidadeService {

    List<Unidade> findAll();

    Optional<Unidade> findById(Long id);

    Integer qtdTotalQuestoesPorUnidadeId(Long unidadeId);

    Integer qtdTotalQuestoesCertasPorUnidadeId(Long usuarioId, Long unidadeId);

    Optional<String> findNomebyId(Long id);

}
