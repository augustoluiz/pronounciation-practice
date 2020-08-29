package com.icw.pronounciationpractice.endpoints;

import com.icw.pronounciationpractice.dto.UsuarioQuestaoDTO;
import com.icw.pronounciationpractice.entity.UsuarioQuestao;
import com.icw.pronounciationpractice.entity.UsuarioQuestaoId;
import com.icw.pronounciationpractice.mapper.UsuarioQuestaoMapper;
import com.icw.pronounciationpractice.service.interfaces.QuestaoService;
import com.icw.pronounciationpractice.service.interfaces.UsuarioQuestaoService;
import com.icw.pronounciationpractice.service.interfaces.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/v1/usuario-questao")
public class UsuarioQuestaoController {

    @Autowired
    private UsuarioQuestaoService usuarioQuestaoService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private QuestaoService questaoService;

    @Autowired
    private UsuarioQuestaoMapper usuarioQuestaoMapper;


    @GetMapping("/questao/{id}")
    public UsuarioQuestaoDTO findByQuestaoId(@PathVariable("id") Long questaoId,
                                             @RequestParam(required = true) Long usuarioId){
        return usuarioQuestaoService.findByQuestaoId(usuarioId, questaoId).map(usuarioQuestaoMapper::map).orElse(null);
    }

    @PostMapping
    public UsuarioQuestaoDTO save(@RequestBody UsuarioQuestaoDTO usuarioQuestaoDTO){
        return usuarioQuestaoMapper.map(usuarioQuestaoService.save(formataUsuarioQuestao(usuarioQuestaoDTO)));
    }

    @PutMapping
    public UsuarioQuestaoDTO update(@RequestBody UsuarioQuestaoDTO usuarioQuestaoDTO){
        return usuarioQuestaoMapper.map(usuarioQuestaoService.save(formataUsuarioQuestao(usuarioQuestaoDTO)));
    }

    private UsuarioQuestao formataUsuarioQuestao(UsuarioQuestaoDTO usuarioQuestaoDTO){
        UsuarioQuestao usuarioQuestao = new UsuarioQuestao();
        UsuarioQuestaoId usuarioQuestaoId = new UsuarioQuestaoId();

        usuarioQuestaoId.setQuestao(questaoService.findById(usuarioQuestaoDTO.getQuestaoId()).orElse(null));
        usuarioQuestaoId.setUsuario(usuarioService.findById(usuarioQuestaoDTO.getUsuarioId()).orElse(null));

        usuarioQuestao.setDataAtualizacao(LocalDateTime.now());
        usuarioQuestao.setId(usuarioQuestaoId);
        usuarioQuestao.setPontuacao(usuarioQuestaoDTO.getPontuacao());

        return usuarioQuestao;
    }

}
