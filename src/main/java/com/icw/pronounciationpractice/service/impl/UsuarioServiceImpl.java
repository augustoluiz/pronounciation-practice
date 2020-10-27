package com.icw.pronounciationpractice.service.impl;

import com.icw.pronounciationpractice.entity.Usuario;
import com.icw.pronounciationpractice.repository.UsuarioRepository;
import com.icw.pronounciationpractice.service.interfaces.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService, UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Optional<Usuario> findById(Long id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public Optional<Long> findIdByLoginSenha(String usuarioLogin, String usuarioSenha) {
        return usuarioRepository.findIdByLoginSenha(usuarioLogin, usuarioSenha);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return this.usuarioRepository.findByEmail(email).get();
    }
}
