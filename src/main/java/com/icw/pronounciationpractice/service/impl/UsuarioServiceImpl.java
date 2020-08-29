package com.icw.pronounciationpractice.service.impl;

import com.icw.pronounciationpractice.entity.Usuario;
import com.icw.pronounciationpractice.repository.UsuarioRepository;
import com.icw.pronounciationpractice.service.interfaces.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Optional<Usuario> findById(Long id) {
        return usuarioRepository.findById(id);
    }
}
