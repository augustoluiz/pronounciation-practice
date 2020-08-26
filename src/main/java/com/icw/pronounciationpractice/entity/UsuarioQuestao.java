package com.icw.pronounciationpractice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioQuestao {

    @EmbeddedId
    private UsuarioQuestaoId id;

    @Column
    @Size(min = 0)
    @NotNull
    private float pontuacao;

    @Column
    @CreatedDate
    @NotNull
    private LocalDateTime dataAtualizacao;
}
