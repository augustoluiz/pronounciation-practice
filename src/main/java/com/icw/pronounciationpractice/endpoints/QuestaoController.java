package com.icw.pronounciationpractice.endpoints;

import com.icw.pronounciationpractice.dto.AudioDTO;
import com.icw.pronounciationpractice.dto.QuestaoDTO;
import com.icw.pronounciationpractice.mapper.AudioMapper;
import com.icw.pronounciationpractice.mapper.QuestaoMapper;
import com.icw.pronounciationpractice.service.interfaces.AudioService;
import com.icw.pronounciationpractice.service.interfaces.QuestaoService;
import com.icw.pronounciationpractice.service.interfaces.UsuarioQuestaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/v1/questao", produces = "application/json;charset=UTF-8")
public class QuestaoController {

    @Autowired
    private QuestaoService questaoService;

    @Autowired
    private AudioService audioService;

    @Autowired
    private UsuarioQuestaoService usuarioQuestaoService;

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
                    questao.setStauts(calculateStatusByQuestionId(1L, questao.getId()));
                    questao.setAudios(findAudiosByQuestionId(questao.getId()));
                    return questao;
                }).orElse(null);
    }

    @GetMapping("/exercicio/{id}")

    public List<QuestaoDTO> findByExercicioId(@PathVariable("id") Long id){
        return questaoService.findByExercicioId(id).map(questaoMapper::map)
                .map(questao -> {
                    questao.forEach(e -> {
                        e.setAudios(findAudiosByQuestionId(e.getId()));
                        e.setStauts(calculateStatusByQuestionId(1L, e.getId()));
                    });
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

    private float calculateStatusByQuestionId(Long usuarioId, Long questionId){
        return usuarioQuestaoService.calculateStatusByQuestionId(usuarioId, questionId);
    }

}
