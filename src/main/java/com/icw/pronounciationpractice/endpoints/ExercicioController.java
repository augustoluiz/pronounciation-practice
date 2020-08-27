package com.icw.pronounciationpractice.endpoints;

import com.icw.pronounciationpractice.entity.Exercicio;
import com.icw.pronounciationpractice.service.interfaces.ExercicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/exercicio")
public class ExercicioController {

    @Autowired
    private ExercicioService exercicioService;

    @GetMapping
    public List<Exercicio> findAll(){
        return exercicioService.findAll();
    }

    @GetMapping("/{id}")
    public Exercicio findById(@PathVariable("id") Long id){
        return exercicioService.findById(id).orElse(null);
    }

}
