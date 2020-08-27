package com.icw.pronounciationpractice.endpoints;

import com.icw.pronounciationpractice.entity.Audio;
import com.icw.pronounciationpractice.service.interfaces.AudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/audio")
public class AudioController {

    @Autowired
    private AudioService audioService;

    @GetMapping
    public List<Audio> findAll(){
        return audioService.findAll();
    }

    @GetMapping("/{id}")
    public Audio findById(@PathVariable("id") Long id){
        return audioService.findById(id).orElse(null);
    }

}
