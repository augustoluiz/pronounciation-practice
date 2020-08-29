package com.icw.pronounciationpractice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Size(max = 250)
    @NotNull
    @NotEmpty
    private String nome;

    @Column
    @CreatedDate
    private LocalDateTime dataCriacao;

    @OneToMany
    @JsonIgnore
    private List<UsuarioQuestao> usuarioQuestao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public List<UsuarioQuestao> getUsuarioQuestao() {
        return usuarioQuestao;
    }

    public void setUsuarioQuestao(List<UsuarioQuestao> usuarioQuestao) {
        this.usuarioQuestao = usuarioQuestao;
    }
}
