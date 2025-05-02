package com.kalettre.gestionMedica.controllers;

import com.kalettre.gestionMedica.dto.PacienteDto;
import com.kalettre.gestionMedica.services.PacienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public ResponseEntity<List<PacienteDto>> obtenerTodos() {
        return ResponseEntity.ok(pacienteService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteDto> obtenerPorId(@PathVariable Long id) {
        PacienteDto dto = pacienteService.obtenerPorId(id);
        if (dto == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<PacienteDto> crear(@Validated @RequestBody PacienteDto dto) {
        return ResponseEntity.ok(pacienteService.crear(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PacienteDto> actualizar(@PathVariable Long id, @Validated @RequestBody PacienteDto dto) {
        PacienteDto actualizado = pacienteService.actualizar(id, dto);
        if (actualizado == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        pacienteService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}