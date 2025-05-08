package com.kalettre.gestionMedica.controllers;

import com.kalettre.gestionMedica.dto.MedicoDto;
import com.kalettre.gestionMedica.services.MedicoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medicos")
@Tag(name = "Médicos", description = "Operaciones relacionadas con médicos")
public class MedicoController {

    private final MedicoService medicoService;

    public MedicoController(MedicoService medicoService) {
        this.medicoService = medicoService;
    }

    @Operation(summary = "Obtener todos los médicos", description = "Devuelve una lista de todos los médicos registrados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de médicos obtenida exitosamente")
    })
    @GetMapping
    public ResponseEntity<List<MedicoDto>> obtenerTodos() {
        return ResponseEntity.ok(medicoService.obtenerTodos());
    }

    @Operation(summary = "Obtener médico por ID", description = "Obtiene un médico específico mediante su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Médico encontrado"),
            @ApiResponse(responseCode = "404", description = "Médico no encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<MedicoDto> obtenerPorId(
            @Parameter(description = "ID del médico") @PathVariable Long id) {
        MedicoDto dto = medicoService.obtenerPorId(id);
        if (dto == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(dto);
    }

    @Operation(summary = "Crear nuevo médico", description = "Registra un nuevo médico en el sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Médico creado exitosamente"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos en la solicitud")
    })
    @PostMapping
    public ResponseEntity<MedicoDto> crear(@Validated @RequestBody MedicoDto dto) {
        return ResponseEntity.ok(medicoService.crear(dto));
    }

    @Operation(summary = "Actualizar un médico", description = "Actualiza la información de un médico existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Médico actualizado exitosamente"),
            @ApiResponse(responseCode = "404", description = "Médico no encontrado"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos en la solicitud")
    })
    @PutMapping("/{id}")
    public ResponseEntity<MedicoDto> actualizar(
            @Parameter(description = "ID del médico") @PathVariable Long id,
            @Validated @RequestBody MedicoDto dto) {
        MedicoDto actualizado = medicoService.actualizar(id, dto);
        if (actualizado == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(actualizado);
    }

    @Operation(summary = "Eliminar un médico", description = "Elimina un médico del sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Médico eliminado exitosamente"),
            @ApiResponse(responseCode = "404", description = "Médico no encontrado")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(
            @Parameter(description = "ID del médico") @PathVariable Long id) {
        medicoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}