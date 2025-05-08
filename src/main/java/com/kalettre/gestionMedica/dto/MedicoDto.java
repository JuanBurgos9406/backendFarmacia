package com.kalettre.gestionMedica.dto;


import com.kalettre.gestionMedica.models.Consulta;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Data
@Schema(description = "DTO que representa a un médico")
public class MedicoDto {

        @Schema(description = "ID único del médico", example = "1")
        private Long idMedico;

        @NotBlank(message = "EL NOMBRE DEL MÉDICO NO DEBE ESTAR VACÍO")
        @Schema(description = "Nombre del médico", example = "Carlos")
        private String nombreMedico;

        @NotBlank(message = "EL APELLIDO DEL MÉDICO NO DEBE ESTAR VACÍO")
        @Schema(description = "Apellido del médico", example = "Ramírez")
        private String apellidoMedico;

        @NotBlank(message = "LA ESPECIALIDAD DEL MÉDICO NO DEBE ESTAR VACÍA")
        @Schema(description = "Especialidad del médico", example = "Medicina interna")
        private String especialidad;

        @Schema(description = "Consultas asociadas al médico (opcional)")
        private List<Consulta> consultas;
}