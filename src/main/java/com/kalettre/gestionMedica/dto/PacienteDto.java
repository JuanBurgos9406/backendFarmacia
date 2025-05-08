package com.kalettre.gestionMedica.dto;

import com.kalettre.gestionMedica.models.Consulta;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Data
@Schema(description = "DTO que representa a un paciente")
public class PacienteDto {

    @Schema(description = "ID único del paciente", example = "1")
    private Long idPaciente;

    @NotBlank(message = "EL NOMBRE DEL PACIENTE NO DEBE ESTAR VACÍO")
    @Schema(description = "Nombre del paciente", example = "Laura")
    private String nombrePaciente;

    @NotBlank(message = "EL APELLIDO DEL PACIENTE NO DEBE ESTAR VACÍO")
    @Schema(description = "Apellido del paciente", example = "González")
    private String apellidoPaciente;

    @NotBlank(message = "LA FECHA DE NACIMIENTO NO DEBE ESTAR VACÍA")
    @Schema(description = "Fecha de nacimiento del paciente en formato AAAA-MM-DD", example = "1990-07-15")
    private String fechaNacimiento;

    @Schema(description = "Dirección de residencia del paciente", example = "Calle 123 #45-67")
    private String direccionPaciente;

    @Schema(description = "Número de teléfono del paciente", example = "3114567890")
    private String telefonoPaciente;

    @NotBlank(message = "EL EMAIL DEL PACIENTE NO DEBE ESTAR VACÍO")
    @Email(message = "EL EMAIL DEL PACIENTE ES INVÁLIDO")
    @Schema(description = "Correo electrónico del paciente", example = "laura.gonzalez@example.com")
    private String emailPaciente;

    @NotBlank(message = "ASIGNA UN CAMPO DE GÉNERO AL PACIENTE")
    @Schema(description = "Género del paciente (Masculino, Femenino, Otro)", example = "Femenino")
    private String sexoPaciente;

    @Schema(description = "Estado civil del paciente", example = "Soltera")
    private String estadoCivilPaciente;

    @Schema(description = "Ocupación actual del paciente", example = "Ingeniera de sistemas")
    private String ocupacionPaciente;

    @Schema(description = "Número de contacto adicional", example = "3209876543")
    private String telefono;

    @Schema(description = "Lista de consultas asociadas al paciente")
    private List<Consulta> consultas;
}