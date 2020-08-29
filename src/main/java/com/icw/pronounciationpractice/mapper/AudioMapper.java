package com.icw.pronounciationpractice.mapper;

import com.icw.pronounciationpractice.dto.AudioDTO;
import com.icw.pronounciationpractice.entity.Audio;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface AudioMapper {

    default AudioDTO map(Audio audio){
        return converteLayout(audio);
    }

    default List<AudioDTO> map(List<Audio> audios){
        return audios.stream().map(audio -> converteLayout(audio)).collect(Collectors.toList());
    }

    default AudioDTO converteLayout(Audio audio){
        AudioDTO audioDTO = new AudioDTO();
        audioDTO.setId(audio.getId());
        audioDTO.setLink(audio.getLink());
        audioDTO.setTitulo(audio.getTitulo());
        audioDTO.setDescricao(audio.getDescricao());
        return audioDTO;
    }

}
