package com.kalettre.gestionMedica.dto;

import com.kalettre.gestionMedica.models.Medicamento;
import com.kalettre.gestionMedica.models.Medico;
import com.kalettre.gestionMedica.models.Paciente;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class ConsultaDto {
    @Schema(description = "ID único de la consulta", example = "123")
    private Long idconsulta;

    @NotNull(message = "INGRESA LA FECHA DE LA CONSULTA")
    @FutureOrPresent(message = "LA FECHA DE LA CONSULTA NO PUEDE SER PASADA")
    @Schema(description = "Fecha en la que se realiza la consulta", example = "2025-05-08", required = true)
    private LocalDate fechaConsulta;

    @NotBlank(message = "INGRESA EL MOTIVO DE LA CONSULTA")
    @Schema(description = "Motivo por el cual el paciente asiste a la consulta", example = "Dolor de cabeza persistente", required = true)
    private String motivoConsulta;

    @NotBlank(message = "INGRESA EL DIAGNOSTICO DE LA CONSULTA")
    @Schema(description = "Diagnóstico proporcionado por el médico", example = "Migraña", required = true)
    private String diagnostico;

    @NotBlank(message = "INGRESA EL TRATAMIENTO DE LA CONSULTA")
    @Schema(description = "Tratamiento recomendado para el diagnóstico", example = "Analgésicos cada 8 horas", required = true)
    private String tratamiento;

    @NotNull(message = "INGRESA EL PACIENTE DE LA CONSULTA")
    @Valid
    @Schema(description = "Información del paciente asociado a la consulta", required = true)
    private Paciente paciente;

    @NotNull(message = "INGRESA EL MEDICO DE LA CONSULTA")
    @Valid
    @Schema(description = "Información del médico que realiza la consulta", required = true)
    private Medico medico;

    @NotEmpty(message = "INGRESA LOS MEDICAMENTOS DE LA CONSULTA")
    @Valid
    @Schema(description = "Lista de medicamentos recetados durante la consulta", required = true)
    private List<Medicamento> medicamentos;
}
