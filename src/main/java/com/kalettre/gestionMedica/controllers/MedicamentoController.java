package com.kalettre.gestionMedica.controllers;

import com.kalettre.gestionMedica.dto.MedicamentoDto;
import com.kalettre.gestionMedica.services.MedicamentoService;
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
@RequestMapping("/api/medicamentos")
@Tag(name = "Medicamentos", description = "Operaciones relacionadas con medicamentos")
public class MedicamentoController {

    private final MedicamentoService medicamentoService;

    public MedicamentoController(MedicamentoService medicamentoService) {
        this.medicamentoService = medicamentoService;
    }

    @Operation(summary = "Obtener todos los medicamentos", description = "Devuelve una lista de todos los medicamentos registrados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de medicamentos obtenida exitosamente")
    })
    @GetMapping
    public ResponseEntity<List<MedicamentoDto>> obtenerTodos() {
        List<MedicamentoDto> medicamentos = medicamentoService.obtenerTodos();
        return ResponseEntity.ok(medicamentos);
    }

    @Operation(summary = "Obtener medicamento por ID", description = "Obtiene un medicamento específico mediante su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Medicamento encontrado"),
            @ApiResponse(responseCode = "404", description = "Medicamento no encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<MedicamentoDto> obtenerPorId(
            @Parameter(description = "ID del medicamento") @PathVariable Long id) {
        MedicamentoDto dto = medicamentoService.obtenerPorId(id);
        if (dto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(dto);
    }

    @Operation(summary = "Crear nuevo medicamento", description = "Registra un nuevo medicamento en el sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Medicamento creado exitosamente"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos en la solicitud")
    })
    @PostMapping
    public ResponseEntity<MedicamentoDto> crear(@Validated @RequestBody MedicamentoDto dto) {
        MedicamentoDto creado = medicamentoService.guardar(dto);
        return ResponseEntity.ok(creado);
    }

    @Operation(summary = "Actualizar un medicamento", description = "Actualiza la información de un medicamento existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Medicamento actualizado exitosamente"),
            @ApiResponse(responseCode = "404", description = "Medicamento no encontrado"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos en la solicitud")
    })
    @PutMapping("/{id}")
    public ResponseEntity<MedicamentoDto> actualizar(
            @Parameter(description = "ID del medicamento") @PathVariable Long id,
            @Validated @RequestBody MedicamentoDto dto) {
        MedicamentoDto actualizado = medicamentoService.actualizar(id, dto);
        if (actualizado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(actualizado);
    }

    @Operation(summary = "Eliminar un medicamento", description = "Elimina un medicamento del sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Medicamento eliminado exitosamente"),
            @ApiResponse(responseCode = "404", description = "Medicamento no encontrado")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(
            @Parameter(description = "ID del medicamento") @PathVariable Long id) {
        medicamentoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
