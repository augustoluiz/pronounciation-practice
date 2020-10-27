package com.icw.pronounciationpractice.endpoints;

import com.icw.pronounciationpractice.entity.Usuario;
import com.icw.pronounciationpractice.service.interfaces.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/{id}")
    public Usuario findById(@PathVariable("id") Long id){
        return usuarioService.findById(id).orElse(null);
    }

    @GetMapping("/findIdByLoginSenha")
    public Long findIdByLoginSenha(@RequestParam(required = true) String usuarioLogin, String usuarioSenha){
        return usuarioService.findIdByLoginSenha(usuarioLogin, usuarioSenha).orElse(null);
    }

}
