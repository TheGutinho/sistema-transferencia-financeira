package com.financeiro.transferencia_api.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.financeiro.transferencia_api.model.Transferencia;
import com.financeiro.transferencia_api.repository.TransferenciaRepository;

@Service
public class TransferenciaService {

	private final TransferenciaRepository repository;

	public TransferenciaService(TransferenciaRepository repository) {
		this.repository = repository;
	}

	public List<Transferencia> listarTodas() {
		return repository.findAll(Sort.by(Sort.Direction.DESC, "dataHora"));
	}

	public Transferencia criar(Transferencia transferencia) {
		transferencia.setId(null);
		transferencia.setDataHora(null);
		return repository.save(transferencia);
	}
}