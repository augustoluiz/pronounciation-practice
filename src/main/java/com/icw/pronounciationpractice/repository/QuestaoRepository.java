package com.icw.pronounciationpractice.repository;

import com.icw.pronounciationpractice.entity.Questao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuestaoRepository extends JpaRepository<Questao, Long> {

    @Query(value = "SELECT * FROM QUESTAO \n" +
            "WHERE EXERCICIO_ID = :id \n" +
            "ORDER BY ORDEM_APRESENTACAO ASC", nativeQuery = true)
    Optional<List<Questao>> findByExercicioId(@Param("id") Long id);


    @Query(value = "SELECT COUNT(*) FROM QUESTAO WHERE EXERCICIO_ID = :exercicioId", nativeQuery = true)
    Integer findQtdTotalByExercicioId(@Param("exercicioId") Long exercicioId);


    @Query(value = "SELECT COUNT(*) FROM USUARIO_QUESTAO AS USQ INNER JOIN QUESTAO AS QUE\n" +
            "ON (USQ.QUESTAO_ID = QUE.ID)\n" +
            "INNER JOIN EXERCICIO AS EXE\n" +
            "ON (QUE.EXERCICIO_ID = EXE.ID)\n" +
            "WHERE USQ.USUARIO_ID = :usuarioId\n" +
            "AND EXE.ID = :exercicioId\n" +
            "AND USQ.PONTUACAO >= :valorMinimoCorreto", nativeQuery = true)
    Integer findQtdConcluidoByExercicioId(@Param("exercicioId") Long exercicioId,
                                          @Param("usuarioId") Long usuarioId,
                                          @Param("valorMinimoCorreto") float valorMinimoCorreto);

}
