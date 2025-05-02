package com.kalettre.gestionMedica.controllers;

import com.kalettre.gestionMedica.dto.MedicoDto;
import com.kalettre.gestionMedica.services.MedicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medicos")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @GetMapping
    public ResponseEntity<List<MedicoDto>> obtenerTodos() {
        return ResponseEntity.ok(medicoService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicoDto> obtenerPorId(@PathVariable Long id) {
        MedicoDto dto = medicoService.obtenerPorId(id);
        if (dto == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<MedicoDto> crear(@Validated @RequestBody MedicoDto dto) {
        return ResponseEntity.ok(medicoService.crear(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MedicoDto> actualizar(@PathVariable Long id, @Validated @RequestBody MedicoDto dto) {
        MedicoDto actualizado = medicoService.actualizar(id, dto);
        if (actualizado == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        medicoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}