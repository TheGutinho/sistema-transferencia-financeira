package com.financeiro.transferencia_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.financeiro.transferencia_api.model.Transferencia;

public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {
}