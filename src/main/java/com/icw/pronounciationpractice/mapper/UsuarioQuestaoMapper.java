package com.icw.pronounciationpractice.mapper;

import com.icw.pronounciationpractice.dto.UsuarioQuestaoDTO;
import com.icw.pronounciationpractice.entity.UsuarioQuestao;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface UsuarioQuestaoMapper {

    @Mappings({
            @Mapping(source = "id.usuario.id", target = "usuarioId"),
            @Mapping(source = "id.questao.id", target = "questaoId"),
            @Mapping(source = "pontuacao", target = "pontuacao"),
            @Mapping(source = "dataAtualizacao", target = "dataAtualizacao", dateFormat = "yyyy-MM-dd HH:mm")
    })
    UsuarioQuestaoDTO map(UsuarioQuestao usuarioQuestao);

}
