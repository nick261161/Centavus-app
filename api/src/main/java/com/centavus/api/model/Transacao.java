package com.centavus.api.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "transacoes")
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long usuarioId; // Guarda de qual usuário é esse gasto

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private Double valor;

    @Column(nullable = false)
    private String tipo; // "RECEITA" ou "DESPESA"

    @Column(nullable = false)
    private String metodoPagamento; // "PIX", "DEBITO", "CREDITO"

    @Column(nullable = false)
    private String categoria; // "Alimentação", "Transporte", etc.

    @Column(nullable = false)
    private LocalDate dataTransacao;

    // --- NOVOS CAMPOS PARA O PARCELAMENTO ---
    @Column(nullable = true)
    private Integer parcelas;

    @Column(nullable = true)
    private Double valorParcela;
    // ----------------------------------------

    // Construtores, Getters e Setters
    public Transacao() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public Double getValor() { return valor; }
    public void setValor(Double valor) { this.valor = valor; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getMetodoPagamento() { return metodoPagamento; }
    public void setMetodoPagamento(String metodoPagamento) { this.metodoPagamento = metodoPagamento; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public LocalDate getDataTransacao() { return dataTransacao; }
    public void setDataTransacao(LocalDate dataTransacao) { this.dataTransacao = dataTransacao; }

    // --- GETTERS E SETTERS DAS PARCELAS ---
    public Integer getParcelas() { return parcelas; }
    public void setParcelas(Integer parcelas) { this.parcelas = parcelas; }

    public Double getValorParcela() { return valorParcela; }
    public void setValorParcela(Double valorParcela) { this.valorParcela = valorParcela; }
    // --------------------------------------
}
