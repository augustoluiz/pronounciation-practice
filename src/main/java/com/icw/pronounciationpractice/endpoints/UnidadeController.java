package com.icw.pronounciationpractice.endpoints;

import com.icw.pronounciationpractice.entity.Unidade;
import com.icw.pronounciationpractice.service.interfaces.UnidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/unidade")
public class UnidadeController {

    @Autowired
    private UnidadeService unidadeService;

    @GetMapping
    public List<Unidade> findAll(){
        return unidadeService.findAll();
    }

    @GetMapping("/{id}")
    public Unidade findById(@PathVariable("id") Long id){
        return unidadeService.findById(id).orElse(null);
    }

}
