package com.icw.pronounciationpractice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioQuestaoId implements Serializable {

    @ManyToOne
    private Usuario usuario;

    @ManyToOne
    private Questao questao;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Questao getQuestao() {
        return questao;
    }

    public void setQuestao(Questao questao) {
        this.questao = questao;
    }

    @Override
    public String toString() {
        return "UsuarioQuestaoId{" +
                "usuario=" + usuario +
                ", questao=" + questao +
                '}';
    }
}
