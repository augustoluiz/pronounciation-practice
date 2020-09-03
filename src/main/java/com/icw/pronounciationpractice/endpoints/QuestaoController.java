package com.icw.pronounciationpractice.endpoints;

import com.icw.pronounciationpractice.dto.AudioDTO;
import com.icw.pronounciationpractice.dto.QuestaoDTO;
import com.icw.pronounciationpractice.mapper.AudioMapper;
import com.icw.pronounciationpractice.mapper.QuestaoMapper;
import com.icw.pronounciationpractice.service.interfaces.AudioService;
import com.icw.pronounciationpractice.service.interfaces.QuestaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/questao")
public class QuestaoController {

    @Autowired
    private QuestaoService questaoService;

    @Autowired
    private AudioService audioService;

    @Autowired
    private QuestaoMapper questaoMapper;

    @Autowired
    private AudioMapper audioMapper;

    @GetMapping
    public List<QuestaoDTO> findAll(){
        return questaoMapper.map(questaoService.findAll())
                .stream()
                .map(questao -> {
                    questao.setAudios(findAudiosByQuestionId(questao.getId()));
                    return questao;
                }).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public QuestaoDTO findById(@PathVariable("id") Long id){
        return questaoService.findById(id)
                .map(questaoMapper::map)
                .map(questao -> {
                    questao.setAudios(findAudiosByQuestionId(questao.getId()));
                    return questao;
                }).orElse(null);
    }

    @GetMapping("/exercicio/{id}")
    public List<QuestaoDTO> findByExercicioId(@PathVariable("id") Long id){
        return questaoService.findByExercicioId(id).map(questaoMapper::map)
                .map(questao -> {
                    questao.forEach(e -> e.setAudios(findAudiosByQuestionId(e.getId())));
                    return questao;
                }).orElse(null);
    }

    @GetMapping("/totalByExercicio/{exercicioId}")
    public Integer findQtdTotalByExercicioId(@PathVariable("exercicioId") Long exercicioId){
        return questaoService.findQtdTotalByExercicioId(exercicioId);
    }

    @GetMapping("/concluidoByExercicio/{exercicioId}")
    public Integer findQtdConcluidoByExercicioId(@RequestParam(required = true) Long usuarioId,
                                                 @PathVariable("exercicioId") Long exercicioId){
        return questaoService.findQtdConcluidoByExercicioId(usuarioId, exercicioId);
    }

    private List<AudioDTO> findAudiosByQuestionId(Long questionId){
       return audioMapper.map(audioService.findByQuestaoId(questionId));
    }

}
