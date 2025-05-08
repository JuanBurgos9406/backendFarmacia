package com.kalettre.gestionMedica.controllers;

import com.kalettre.gestionMedica.dto.ConsultaDto;
import com.kalettre.gestionMedica.services.ConsultaService;
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
@RequestMapping("/api/consultas")
@Tag(name = "Consultas", description = "Operaciones relacionadas con consultas médicas")
public class ConsultaController {

    private final ConsultaService consultaService;

    public ConsultaController(ConsultaService consultaService) {
        this.consultaService = consultaService;
    }

    @Operation(summary = "Obtener todas las consultas", description = "Retorna una lista de todas las consultas registradas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de consultas obtenida exitosamente")
    })
    @GetMapping
    public ResponseEntity<List<ConsultaDto>> obtenerTodas() {
        List<ConsultaDto> consultas = consultaService.obtenerTodas();
        return ResponseEntity.ok(consultas);
    }

    @Operation(summary = "Obtener consulta por ID", description = "Retorna los detalles de una consulta específica dado su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Consulta encontrada"),
            @ApiResponse(responseCode = "404", description = "Consulta no encontrada")
    })
    @GetMapping("/{id}")
    public ResponseEntity<ConsultaDto> obtenerPorId(
            @Parameter(description = "ID de la consulta") @PathVariable Long id) {
        ConsultaDto consulta = consultaService.obtenerPorId(id);
        if (consulta == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(consulta);
    }

    @Operation(summary = "Crear nueva consulta", description = "Registra una nueva consulta médica en el sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Consulta creada exitosamente"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos en la solicitud")
    })
    @PostMapping
    public ResponseEntity<ConsultaDto> crear(@Validated @RequestBody ConsultaDto dto) {
        ConsultaDto creada = consultaService.crear(dto);
        return ResponseEntity.ok(creada);
    }

    @Operation(summary = "Actualizar una consulta", description = "Actualiza los datos de una consulta existente dado su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Consulta actualizada exitosamente"),
            @ApiResponse(responseCode = "404", description = "Consulta no encontrada"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos en la solicitud")
    })
    @PutMapping("/{id}")
    public ResponseEntity<ConsultaDto> actualizar(
            @Parameter(description = "ID de la consulta") @PathVariable Long id,
            @Validated @RequestBody ConsultaDto dto) {
        ConsultaDto actualizada = consultaService.actualizar(id, dto);
        if (actualizada == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(actualizada);
    }

    @Operation(summary = "Eliminar una consulta", description = "Elimina una consulta médica del sistema dado su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Consulta eliminada exitosamente"),
            @ApiResponse(responseCode = "404", description = "Consulta no encontrada")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@Parameter(description = "ID de la consulta") @PathVariable Long id) {
        consultaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}