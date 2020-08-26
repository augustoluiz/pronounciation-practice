package com.icw.pronounciationpractice.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Exercicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Size(max = 50)
    @NotNull
    @NotEmpty
    private String titulo;

    @Column
    @Min(0)
    @NotNull
    private int ordemApresentacao;

    @ManyToOne
    private Unidade unidade;

    @OneToMany
    private List<Questao> questao;

}
