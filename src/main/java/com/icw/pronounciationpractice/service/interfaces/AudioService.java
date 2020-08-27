package com.icw.pronounciationpractice.service.interfaces;

import com.icw.pronounciationpractice.entity.Audio;

import java.util.List;
import java.util.Optional;

public interface AudioService {

    List<Audio> findAll();

    Optional<Audio> findById(Long id);

}
