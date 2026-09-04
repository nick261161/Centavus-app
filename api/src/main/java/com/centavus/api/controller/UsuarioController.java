package com.centavus.api.controller;

import com.centavus.api.model.LoginDTO;
import com.centavus.api.model.Usuario;
import com.centavus.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @PostMapping
    public Usuario cadastrar(@RequestBody Usuario usuario) {
        return repository.save(usuario);
    }

    // Rota de Login: POST em /usuarios/login
    @PostMapping("/login")
    public ResponseEntity<?> fazerLogin(@RequestBody LoginDTO dadosLogin) {
        Optional<Usuario> usuarioEncontrado = repository.findByEmail(dadosLogin.getEmail());

        if (usuarioEncontrado.isPresent()) {
            Usuario usuario = usuarioEncontrado.get();
            // Compara a senha enviada com a senha salva no banco
            if (usuario.getSenha().equals(dadosLogin.getSenha())) {
                return ResponseEntity.ok(usuario); // Login bem-sucedido, retorna os dados do usuário
            }
        }
        
        // Se o e-mail não existe ou a senha está errada
        return ResponseEntity.status(401).body("E-mail ou senha inválidos!");
    }
}