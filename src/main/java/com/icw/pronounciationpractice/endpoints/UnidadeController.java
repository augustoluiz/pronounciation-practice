package com.icw.pronounciationpractice.endpoints;

import com.icw.pronounciationpractice.dto.UnidadeDTO;
import com.icw.pronounciationpractice.entity.Unidade;
import com.icw.pronounciationpractice.mapper.UnidadeMapper;
import com.icw.pronounciationpractice.service.interfaces.UnidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/unidade")
public class UnidadeController {

    @Autowired
    private UnidadeService unidadeService;

    @Autowired
    private UnidadeMapper unidadeMapper;

    @GetMapping
    public List<UnidadeDTO> findAll(@RequestParam(required = true) Long usuarioId){
        return unidadeService.findAll()
                .stream()
                .map(unidadeMapper::map)
                .map(unidadeDTO -> addStatus(unidadeDTO, usuarioId))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public UnidadeDTO findById(@PathVariable("id") Long id,
                               @RequestParam(required = true) Long usuarioId){
        return unidadeService.findById(id)
                .map(unidadeMapper::map)
                .map(unidadeDTO -> addStatus(unidadeDTO, usuarioId))
                .orElse(null);
    }

    private UnidadeDTO addStatus(UnidadeDTO unidadeDTO, Long usuarioId){
        Integer qtdTotal = unidadeService.qtdTotalQuestoesPorUnidadeId(unidadeDTO.getId());
        if (qtdTotal != 0){
            Integer qtdCertas = unidadeService.qtdTotalQuestoesCertasPorUnidadeId(usuarioId, unidadeDTO.getId());
            unidadeDTO.setStatus((qtdCertas * 100)/qtdTotal);
        } else {
            unidadeDTO.setStatus(0);
        }
        return unidadeDTO;
    }

}
