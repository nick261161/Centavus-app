package com.centavus.api.controller;

import com.centavus.api.model.Transacao;
import com.centavus.api.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transacoes")
@CrossOrigin(origins = "*")
public class TransacaoController {

    @Autowired
    private TransacaoRepository repository;

    @PostMapping
    public Transacao adicionarTransacao(@RequestBody Transacao transacao) {
        return repository.save(transacao);
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<Transacao> listarPorUsuario(@PathVariable Long usuarioId) {
        return repository.findByUsuarioId(usuarioId);
    }
}