package com.kalettre.gestionMedica.controllers;

import com.kalettre.gestionMedica.dto.ConsultaDto;
import com.kalettre.gestionMedica.services.ConsultaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/consultas")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;

    // Obtener todas las consultas
    @GetMapping
    public ResponseEntity<List<ConsultaDto>> obtenerTodas() {
        List<ConsultaDto> consultas = consultaService.obtenerTodas();
        return ResponseEntity.ok(consultas);
    }

    // Obtener consulta por ID
    @GetMapping("/{id}")
    public ResponseEntity<ConsultaDto> obtenerPorId(@PathVariable Long id) {
        ConsultaDto consulta = consultaService.obtenerPorId(id);
        if (consulta == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(consulta);
    }

    // Crear una nueva consulta
    @PostMapping
    public ResponseEntity<ConsultaDto> crear(@Validated @RequestBody ConsultaDto dto) {
        ConsultaDto creada = consultaService.crear(dto);
        return ResponseEntity.ok(creada);
    }

    // Actualizar una consulta existente
    @PutMapping("/{id}")
    public ResponseEntity<ConsultaDto> actualizar(@PathVariable Long id, @Validated @RequestBody ConsultaDto dto) {
        ConsultaDto actualizada = consultaService.actualizar(id, dto);
        if (actualizada == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(actualizada);
    }

    // Eliminar una consulta
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        consultaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}