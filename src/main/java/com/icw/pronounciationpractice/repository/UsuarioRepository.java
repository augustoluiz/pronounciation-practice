package com.icw.pronounciationpractice.repository;

import com.icw.pronounciationpractice.entity.Usuario;
import com.icw.pronounciationpractice.entity.UsuarioQuestao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query(value = "SELECT * FROM USUARIO WHERE EMAIL = :email", nativeQuery = true)
    Optional<Usuario> findByEmail(@Param("email" )String email);

    @Query(value = "SELECT ID FROM USUARIO WHERE EMAIL = :usuarioLogin AND SENHA = :usuarioSenha", nativeQuery = true)
    Optional<Long> findIdByLoginSenha(@Param("usuarioLogin") String usuarioLogin,
                                      @Param("usuarioSenha") String usuarioSenha);

}
