package com.icw.pronounciationpractice.repository;

import com.icw.pronounciationpractice.entity.Audio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AudioRepository extends JpaRepository<Audio, Long> {

    @Query(value = "SELECT * FROM AUDIO AS AUD \n" +
            "INNER JOIN QUESTOES_AUDIOS AS QAU \n" +
            "ON (AUD.ID = QAU.AUDIO_ID) \n" +
            "WHERE QAU.QUESTAO_ID = :id", nativeQuery = true)
    List<Audio> findByQuestaoId(@Param("id") Long id);

}
