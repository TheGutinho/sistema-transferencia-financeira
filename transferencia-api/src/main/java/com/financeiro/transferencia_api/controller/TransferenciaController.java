package com.financeiro.transferencia_api.controller;

import com.financeiro.transferencia_api.model.Transferencia;
import com.financeiro.transferencia_api.service.TransferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/transferencias")
@CrossOrigin(origins = "*")
public class TransferenciaController {

    @Autowired
    private TransferenciaService service;

    @PostMapping
    public ResponseEntity<?> agendar(@Valid @RequestBody Transferencia transferencia) {
        try {
            Transferencia novaTransferencia = service.agendar(transferencia);
            return ResponseEntity.status(HttpStatus.CREATED).body(novaTransferencia);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Transferencia>> listar() {
        List<Transferencia> lista = service.listarTodas();
        return ResponseEntity.ok(lista);
    }
}