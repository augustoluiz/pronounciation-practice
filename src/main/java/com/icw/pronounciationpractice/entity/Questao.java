package com.icw.pronounciationpractice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Questao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Size(max = 255)
    @NotNull
    @NotEmpty
    private String texto;

    @Column
    @Size(min = 0)
    @NotNull
    private int ordemApresentacao;

    @ManyToOne
    @JsonIgnore
    private Exercicio exercicio;

    @OneToMany
    @JsonIgnore
    private List<QuestoesAudios> questoesAudios;

    @OneToMany
    @JsonIgnore
    private List<UsuarioQuestao> usuarioQuestao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getOrdemApresentacao() {
        return ordemApresentacao;
    }

    public void setOrdemApresentacao(int ordemApresentacao) {
        this.ordemApresentacao = ordemApresentacao;
    }

    public Exercicio getExercicio() {
        return exercicio;
    }

    public void setExercicio(Exercicio exercicio) {
        this.exercicio = exercicio;
    }

    public List<QuestoesAudios> getQuestoesAudios() {
        return questoesAudios;
    }

    public void setQuestoesAudios(List<QuestoesAudios> questoesAudios) {
        this.questoesAudios = questoesAudios;
    }

    public List<UsuarioQuestao> getUsuarioQuestao() {
        return usuarioQuestao;
    }

    public void setUsuarioQuestao(List<UsuarioQuestao> usuarioQuestao) {
        this.usuarioQuestao = usuarioQuestao;
    }

    @Override
    public String toString() {
        return "Questao{" +
                "id=" + id +
                ", texto='" + texto + '\'' +
                ", ordemApresentacao=" + ordemApresentacao +
                ", exercicio=" + exercicio +
                ", questoesVideos=" + questoesAudios +
                ", usuarioQuestao=" + usuarioQuestao +
                '}';
    }
}
