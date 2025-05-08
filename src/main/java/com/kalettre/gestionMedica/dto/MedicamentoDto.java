package com.kalettre.gestionMedica.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;


    @Data

    @Schema(description = "DTO que representa un medicamento")
    public class MedicamentoDto {

        @Schema(description = "ID único del medicamento", example = "1")
        private Long idMedicamento;

        @NotBlank(message = "INGRESA EL NOMBRE DEL MEDICAMENTO")
        @Schema(description = "Nombre del medicamento", example = "Ibuprofeno", required = true)
        private String nombreMedicamento;

        @NotBlank(message = "INGRESA LA DESCRIPCIÓN DEL MEDICAMENTO")
        @Schema(description = "Descripción detallada del medicamento", example = "Antiinflamatorio no esteroideo", required = true)
        private String descripcionMedicamento;

        @NotNull(message = "La fecha de vencimiento es obligatoria")
        @Future(message = "LA FECHA DE VENCIMIENTO NO PUEDE SER PASADA")
        @Schema(description = "Fecha de vencimiento del medicamento", example = "2026-12-31", required = true)
        private LocalDate fechaVencimiento;

        @Min(value = 0, message = "LA CANTIDAD DEL MEDICAMENTO NO PUEDE SER MENOR A 0")
        @Schema(description = "Cantidad disponible del medicamento", example = "100", required = true)
        private int cantidadMedicamento;

        @Min(value = 0, message = "EL PRECIO DEL MEDICAMENTO NO PUEDE SER MENOR A 0")
        @Schema(description = "Precio unitario del medicamento", example = "2500", required = true)
        private int precioMedicamento;
    }
