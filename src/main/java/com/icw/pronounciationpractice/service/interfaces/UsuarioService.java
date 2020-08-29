package com.icw.pronounciationpractice.service.interfaces;

import com.icw.pronounciationpractice.entity.Usuario;

import java.util.Optional;

public interface UsuarioService {

    Optional<Usuario> findById(Long id);

}
