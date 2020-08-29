package com.icw.pronounciationpractice.repository;

import com.icw.pronounciationpractice.entity.UsuarioQuestao;
import com.icw.pronounciationpractice.entity.UsuarioQuestaoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioQuestaoRepository extends JpaRepository<UsuarioQuestao, UsuarioQuestaoId> {

    @Query(value = "SELECT * FROM USUARIO_QUESTAO WHERE USUARIO_ID = :usuarioId AND QUESTAO_ID = :questaoId", nativeQuery = true)
    Optional<UsuarioQuestao> findByQuestaoId(@Param("usuarioId") Long usuarioId,
                                             @Param("questaoId") Long questaoId);

}
