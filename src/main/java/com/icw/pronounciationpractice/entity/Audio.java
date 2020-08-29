package com.icw.pronounciationpractice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Audio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Size(max = 255)
    @NotNull
    @NotEmpty
    private String link;

    @Column
    @Size(max = 100)
    @NotNull
    @NotEmpty
    private String titulo;

    @Column
    @Size(max = 255)
    private String descricao;

    @OneToMany
    @JsonIgnore
    private List<QuestoesAudios> questoesAudios;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<QuestoesAudios> getQuestoesAudios() {
        return questoesAudios;
    }

    public void setQuestoesAudios(List<QuestoesAudios> questoesAudios) {
        this.questoesAudios = questoesAudios;
    }

    @Override
    public String toString() {
        return "Audio{" +
                "id=" + id +
                ", link='" + link + '\'' +
                ", titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", questoesAudios=" + questoesAudios +
                '}';
    }
}
