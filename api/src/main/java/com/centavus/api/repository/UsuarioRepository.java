package com.centavus.api.repository;

import com.centavus.api.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // Busca o usuário pelo e-mail para validar o login
    Optional<Usuario> findByEmail(String email);
}