package com.icw.pronounciationpractice.mapper;

import com.icw.pronounciationpractice.dto.UnidadeDTO;
import com.icw.pronounciationpractice.entity.Unidade;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface UnidadeMapper {

    default UnidadeDTO map(Unidade unidade){
        return converteLayout(unidade);
    }

    default List<UnidadeDTO> map(List<Unidade> unidades){
        return unidades.stream().map(unidade -> converteLayout(unidade)).collect(Collectors.toList());
    }

    default UnidadeDTO converteLayout(Unidade unidade){
        UnidadeDTO unidadeDTO = new UnidadeDTO();
        unidadeDTO.setId(unidade.getId());
        unidadeDTO.setNome(unidade.getNome());
        unidadeDTO.setDescricao(unidade.getDescricao());
        unidadeDTO.setStatus(0);
        return unidadeDTO;
    }
}
