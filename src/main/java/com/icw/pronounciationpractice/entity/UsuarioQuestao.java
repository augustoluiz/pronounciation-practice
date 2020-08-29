package com.icw.pronounciationpractice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class UsuarioQuestao {

    @EmbeddedId
    private UsuarioQuestaoId id;

    @Column
    @Size(min = 0, max = 1)
    @NotNull
    private float pontuacao;

    @Column
    @CreatedDate
    @NotNull
    private LocalDateTime dataAtualizacao;

    public UsuarioQuestaoId getId() {
        return id;
    }

    public void setId(UsuarioQuestaoId id) {
        this.id = id;
    }

    public float getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(float pontuacao) {
        this.pontuacao = pontuacao;
    }

    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    @Override
    public String toString() {
        return "UsuarioQuestao{" +
                "id=" + id.toString() +
                ", pontuacao=" + pontuacao +
                ", dataAtualizacao=" + dataAtualizacao +
                '}';
    }
}
