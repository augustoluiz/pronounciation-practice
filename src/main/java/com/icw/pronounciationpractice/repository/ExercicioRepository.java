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
            "WHERE UNIDADE_ID = :unidadeId", nativeQuery = true)
    List<Exercicio> findByUnidadeId(@Param("unidadeId") Long unidadeId);

}