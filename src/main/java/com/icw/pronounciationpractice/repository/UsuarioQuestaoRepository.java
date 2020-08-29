package com.icw.pronounciationpractice.repository;

import com.icw.pronounciationpractice.entity.UsuarioQuestao;
import com.icw.pronounciationpractice.entity.UsuarioQuestaoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface UsuarioQuestaoRepository extends JpaRepository<UsuarioQuestao, UsuarioQuestaoId> {

    @Query(value = "SELECT * FROM USUARIO_QUESTAO WHERE USUARIO_ID = :usuarioId AND QUESTAO_ID = :questaoId", nativeQuery = true)
    Optional<UsuarioQuestao> findByQuestaoId(@Param("usuarioId") Long usuarioId,
                                             @Param("questaoId") Long questaoId);
/*
    @Modifying
    @Query(value = "INSERT INTO USUARIO_QUESTAO\n" +
            "(USUARIO_ID, QUESTAO_ID, PONTUACAO, DATA_ATUALIZACAO)\n" +
            "VALUES (:usuarioId, :questaoId, :pontuacao, :dataAtualizacao)\n" +
            "SELECT * FROM USUARIO_QUESTAO WHERE USUARIO_ID = :usuarioId AND QUESTAO_ID = :questaoId", nativeQuery = true)
    UsuarioQuestao save(@Param("usuarioId") Long usuarioId,
                        @Param("questaoId") Long questaoId,
                        @Param("pontuacao") float pontuacao,
                        @Param("dataAtualizacao") LocalDateTime dataAtualizacao);*/

}
