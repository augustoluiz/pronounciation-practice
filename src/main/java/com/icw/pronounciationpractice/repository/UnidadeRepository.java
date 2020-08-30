package com.icw.pronounciationpractice.repository;

import com.icw.pronounciationpractice.entity.Unidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UnidadeRepository extends JpaRepository<Unidade, Long> {

    @Query(value = "SELECT COUNT (*) FROM QUESTAO AS QUE \n" +
            "INNER JOIN EXERCICIO AS EXE\n" +
            "ON (QUE.EXERCICIO_ID = EXE.ID)\n" +
            "INNER JOIN UNIDADE AS UNI\n" +
            "ON (EXE.UNIDADE_ID = UNI.ID)\n" +
            "WHERE UNI.ID = :unidadeId", nativeQuery = true)
    Integer qtdTotalQuestoesPorUnidadeId(@Param("unidadeId") Long unidadeId);


    @Query(value = "SELECT COUNT (*) FROM USUARIO_QUESTAO AS USQ\n" +
            "INNER JOIN QUESTAO AS QUE\n" +
            "ON (USQ.QUESTAO_ID = QUE.ID)\n" +
            "INNER JOIN EXERCICIO AS EXE\n" +
            "ON (QUE.EXERCICIO_ID = EXE.ID)\n" +
            "INNER JOIN UNIDADE AS UNI\n" +
            "ON (EXE.UNIDADE_ID = UNI.ID)\n" +
            "WHERE USQ.USUARIO_ID = :usuarioId\n" +
            "AND UNI.ID = :unidadeId\n" +
            "AND USQ.PONTUACAO >= :valorMinimoCorreto", nativeQuery = true)
    Integer qtdTotalQuestoesCertasPorUnidadeId(@Param("usuarioId") Long usuarioId,
                                               @Param("unidadeId") Long unidadeId,
                                               @Param("valorMinimoCorreto") float valorMinimoCorreto);
}
