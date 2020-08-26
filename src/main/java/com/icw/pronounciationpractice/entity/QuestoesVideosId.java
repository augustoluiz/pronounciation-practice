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
public class QuestoesVideosId implements Serializable {

    @ManyToOne
    private Video video;

    @ManyToOne
    private Questao questao;

}
