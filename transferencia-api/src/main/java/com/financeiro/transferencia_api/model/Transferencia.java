package com.financeiro.transferencia_api.model;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "tb_transferencia")
public class Transferencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "A conta de origem é obrigatória")
    @Pattern(regexp = "\\d{10}", message = "A conta de origem deve ter exatamente 10 dígitos numéricos (XXXXXXXXXX)")
    @Column(nullable = false, length = 10)
    private String contaOrigem;

    @NotBlank(message = "A conta de destino é obrigatória")
    @Pattern(regexp = "\\d{10}", message = "A conta de destino deve ter exatamente 10 dígitos numéricos (XXXXXXXXXX)")
    @Column(nullable = false, length = 10)
    private String contaDestino;

    @NotNull(message = "O valor da transferência é obrigatório")
    @DecimalMin(value = "0.01", message = "O valor da transferência deve ser maior que zero")
    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal valor;

    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal taxa;

    @NotNull(message = "A data de agendamento é obrigatória")
    @Column(nullable = false)
    private LocalDate dataAgendamento;

    @NotNull(message = "A data da transferência é obrigatória")
    @Column(nullable = false)
    private LocalDate dataTransferencia;

    public Transferencia() {
        this.dataAgendamento = LocalDate.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContaOrigem() {
        return contaOrigem;
    }

    public void setContaOrigem(String contaOrigem) {
        this.contaOrigem = contaOrigem;
    }

    public String getContaDestino() {
        return contaDestino;
    }

    public void setContaDestino(String contaDestino) {
        this.contaDestino = contaDestino;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getTaxa() {
        return taxa;
    }

    public void setTaxa(BigDecimal taxa) {
        this.taxa = taxa;
    }

    public LocalDate getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(LocalDate dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }

    public LocalDate getDataTransferencia() {
        return dataTransferencia;
    }

    public void setDataTransferencia(LocalDate dataTransferencia) {
        this.dataTransferencia = dataTransferencia;
    }
}