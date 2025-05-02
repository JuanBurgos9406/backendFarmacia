package com.kalettre.gestionMedica.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class MedicamentoDto {

        private Long idMedicamento;
    @NotBlank(message = "INGRESA EL NOMBRE DEL MEDICAMENTO")

    private String nombreMedicamento;
    @NotBlank(message = "INGRESA EL NOMBRE DEL MEDICAMENTO")
        private String descripcionMedicamento;
    @NotNull(message = "La fecha de vencimiento es obligatoria")
        private LocalDate fechaVencimiento;
    @Min(value = 0, message = "LA CANTIDAD DEL MEDICAMENTO NO PUEDE SER MENOR A 0")
        private int cantidadMedicamento;
    @Min(value = 0, message = "LA CANTIDAD DEL MEDICAMENTO NO PUEDE SER MENOR A 0")    @Min(value = 0, message = "EL PRECIO DEL MEDICAMENTO NO PUEDE SER MENOR A 0")
        private int precioMedicamento;


    }
