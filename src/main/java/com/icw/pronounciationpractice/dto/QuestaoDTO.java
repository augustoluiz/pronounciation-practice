package com.icw.pronounciationpractice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuestaoDTO {

    private Long id;
    private String texto;
    private int ordemApresentacao;
    private Long exercicioId;
    private Float stauts;
    private List<AudioDTO> audios;

    public Long getId() {
        return id;
    }

    public Float getStauts() {
        return stauts;
    }

    public void setStauts(Float stauts) {
        this.stauts = stauts;
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

    public Long getExercicioId() {
        return exercicioId;
    }

    public void setExercicioId(Long exercicioId) {
        this.exercicioId = exercicioId;
    }

    public List<AudioDTO> getAudios() {
        return audios;
    }

    public void setAudios(List<AudioDTO> audios) {
        this.audios = audios;
    }
}
