package com.icw.pronounciationpractice.service.impl;

import com.icw.pronounciationpractice.entity.Audio;
import com.icw.pronounciationpractice.repository.AudioRepository;
import com.icw.pronounciationpractice.service.interfaces.AudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AudioServiceImpl implements AudioService {

    @Autowired
    private AudioRepository audioRepository;

    @Override
    public List<Audio> findAll() {
        return audioRepository.findAll();
    }

    @Override
    public Optional<Audio> findById(Long id) {
        return audioRepository.findById(id);
    }

    @Override
    public List<Audio> findByQuestaoId(Long id) {
        return audioRepository.findByQuestaoId(id);
    }
}
