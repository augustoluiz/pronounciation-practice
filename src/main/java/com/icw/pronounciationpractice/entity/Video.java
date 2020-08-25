package com.icw.pronounciationpractice.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Video {

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

}
