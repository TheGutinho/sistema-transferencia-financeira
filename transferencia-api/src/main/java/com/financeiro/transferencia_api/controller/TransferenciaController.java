package com.financeiro.transferencia_api.controller;

import java.util.List;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.financeiro.transferencia_api.model.Transferencia;
import com.financeiro.transferencia_api.service.TransferenciaService;

@RestController
@RequestMapping("/api/transferencias")
@CrossOrigin(origins = "http://localhost:4200")
public class TransferenciaController {

	private final TransferenciaService service;

	public TransferenciaController(TransferenciaService service) {
		this.service = service;
	}

	@GetMapping
	public List<Transferencia> listarTodas() {
		return service.listarTodas();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Transferencia criar(@Valid @RequestBody Transferencia transferencia) {
		return service.criar(transferencia);
	}
}