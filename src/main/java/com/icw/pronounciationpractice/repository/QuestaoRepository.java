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

}
