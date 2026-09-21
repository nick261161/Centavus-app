package com.centavus.api.controller;

import com.centavus.api.model.Transacao;
import com.centavus.api.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    // --- ROTA PARA DELETAR TRANSAÇÃO ---
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTransacao(@PathVariable Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    // --- ROTA PARA EDITAR (ATUALIZAR) TRANSAÇÃO ---
    @PutMapping("/{id}")
    public ResponseEntity<Transacao> atualizarTransacao(@PathVariable Long id, @RequestBody Transacao transacaoAtualizada) {
        return repository.findById(id)
                .map(transacaoExistente -> {
                    transacaoExistente.setDescricao(transacaoAtualizada.getDescricao());
                    transacaoExistente.setValor(transacaoAtualizada.getValor());
                    transacaoExistente.setTipo(transacaoAtualizada.getTipo());
                    transacaoExistente.setMetodoPagamento(transacaoAtualizada.getMetodoPagamento());
                    transacaoExistente.setCategoria(transacaoAtualizada.getCategoria());
                    transacaoExistente.setDataTransacao(transacaoAtualizada.getDataTransacao());
                    
                    // Atualizando os campos de parcelamento
                    transacaoExistente.setParcelas(transacaoAtualizada.getParcelas());
                    transacaoExistente.setValorParcela(transacaoAtualizada.getValorParcela());
                    
                    Transacao salva = repository.save(transacaoExistente);
                    return ResponseEntity.ok(salva);
                })
                .orElse(ResponseEntity.notFound().build());
    }
}