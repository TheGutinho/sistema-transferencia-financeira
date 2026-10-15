package com.financeiro.transferencia_api.service;

import com.financeiro.transferencia_api.model.Transferencia;
import com.financeiro.transferencia_api.repository.TransferenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class TransferenciaService {

    @Autowired
    private TransferenciaRepository repository;

    public Transferencia agendar(Transferencia transferencia) {
        long dias = ChronoUnit.DAYS.between(transferencia.getDataAgendamento(), transferencia.getDataTransferencia());
        
        BigDecimal taxaCalculada = calcularTaxa(transferencia.getValor(), dias);
        transferencia.setTaxa(taxaCalculada);

        return repository.save(transferencia);
    }

    public List<Transferencia> listarTodas() {
        return repository.findAll();
    }

    private BigDecimal calcularTaxa(BigDecimal valor, long dias) {
        if (dias == 0) {
            // R$ 3,00 + 2,5%
            return new BigDecimal("3.00").add(valor.multiply(new BigDecimal("0.025")));
        } else if (dias >= 1 && dias <= 10) {
            // R$ 12,00 + 0,0%
            return new BigDecimal("12.00");
        } else if (dias >= 11 && dias <= 20) {
            // R$ 0,00 + 8,2%
            return new BigDecimal("0.00").add(valor.multiply(new BigDecimal("0.082")));
        } else if (dias >= 21 && dias <= 30) {
            // R$ 0,00 + 6,9%
            return new BigDecimal("0.00").add(valor.multiply(new BigDecimal("0.069")));
        } else if (dias >= 31 && dias <= 40) {
            // R$ 0,00 + 4,7%
            return new BigDecimal("0.00").add(valor.multiply(new BigDecimal("0.047")));
        } else if (dias >= 41 && dias <= 50) {
            // R$ 0,00 + 1,7%
            return new BigDecimal("0.00").add(valor.multiply(new BigDecimal("0.017")));
        } else {
            throw new IllegalArgumentException("Erro: Não há taxa aplicável para o período selecionado ou data inválida (acima de 50 dias ou retroativa).");
        }
    }
}