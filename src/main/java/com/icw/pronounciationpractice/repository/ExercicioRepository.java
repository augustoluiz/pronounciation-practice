package com.icw.pronounciationpractice.repository;

import com.icw.pronounciationpractice.entity.Exercicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExercicioRepository extends JpaRepository<Exercicio, Long> {

    @Query(value = "SELECT * FROM EXERCICIO \n" +
            "WHERE UNIDADE_ID = :unidadeId \n"+
            "ORDER BY ORDEM_APRESENTACAO ASC", nativeQuery = true)
    List<Exercicio> findByUnidadeId(@Param("unidadeId") Long unidadeId);

    @Query(value = "SELECT COUNT(*) FROM QUESTAO\n" +
            "WHERE EXERCICIO_ID = :id", nativeQuery = true)
    Integer qtdTotalQuestoesPorExercicioId(@Param("id") Long id);

    @Query(value = "SELECT COUNT(*) FROM USUARIO_QUESTAO AS USQ INNER JOIN QUESTAO AS QUE\n" +
            "ON (USQ.QUESTAO_ID = QUE.ID)\n" +
            "INNER JOIN EXERCICIO AS EXE\n" +
            "ON (QUE.EXERCICIO_ID = EXE.ID)\n" +
            "WHERE USQ.USUARIO_ID = :usuarioId\n" +
            "AND EXE.ID = :id\n" +
            "AND USQ.PONTUACAO >= :valorMinimoCorreto", nativeQuery = true)
    Integer qtdTotalQuestoesCertasPorExercicioId(@Param("usuarioId") Long usuarioId,
                                                 @Param("id") Long id,
                                                 @Param("valorMinimoCorreto") float valorMinimoCorreto);


}