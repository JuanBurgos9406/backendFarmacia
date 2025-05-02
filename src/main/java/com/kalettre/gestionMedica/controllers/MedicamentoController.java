package com.kalettre.gestionMedica.controllers;

import com.kalettre.gestionMedica.dto.MedicamentoDto;
import com.kalettre.gestionMedica.services.MedicamentoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medicamentos")
public class MedicamentoController {

    @Autowired
    private MedicamentoService medicamentoService;

    // Obtener todos los medicamentos
    @GetMapping
    public ResponseEntity<List<MedicamentoDto>> obtenerTodos() {
        List<MedicamentoDto> medicamentos = medicamentoService.obtenerTodos();
        return ResponseEntity.ok(medicamentos);
    }

    // Obtener medicamento por ID
    @GetMapping("/{id}")
    public ResponseEntity<MedicamentoDto> obtenerPorId(@PathVariable Long id) {
        MedicamentoDto dto = medicamentoService.obtenerPorId(id);
        if (dto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(dto);
    }

    // Crear nuevo medicamento
    @PostMapping
    public ResponseEntity<MedicamentoDto> crear(@Validated @RequestBody MedicamentoDto dto) {
        MedicamentoDto creado = medicamentoService.guardar(dto);
        return ResponseEntity.ok(creado);
    }

    // Actualizar medicamento existente
    @PutMapping("/{id}")
    public ResponseEntity<MedicamentoDto> actualizar(@PathVariable Long id, @Validated @RequestBody MedicamentoDto dto) {
        MedicamentoDto actualizado = medicamentoService.actualizar(id, dto);
        if (actualizado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(actualizado);
    }

    // Eliminar medicamento
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        medicamentoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
