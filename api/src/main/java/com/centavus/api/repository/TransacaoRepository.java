package com.centavus.api.repository;

import com.centavus.api.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
    // Permite buscar os gastos de um usuário específico pelas abas
    List<Transacao> findByUsuarioId(Long usuarioId);
}