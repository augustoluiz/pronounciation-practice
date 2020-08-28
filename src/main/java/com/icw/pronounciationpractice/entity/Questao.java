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
    private Exercicio exercicio;

    @OneToMany
    @JsonIgnore
    private List<QuestoesAudios> questoesVideos;

    @OneToMany
    @JsonIgnore
    private List<UsuarioQuestao> usuarioQuestao;

}
