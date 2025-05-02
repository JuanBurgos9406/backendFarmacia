package com.kalettre.gestionMedica.dto;

import com.kalettre.gestionMedica.models.Consulta;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Data
public class PacienteDto {


    private Long idPaciente;
    @NotBlank(message = "el NOMBRE DEK PACIENTE NO estar vacio")
    private String nombrePaciente;
    @NotBlank(message = "el APELLIDO DEL PACIENTE NO debe estar vacio")
    private String apellidoPaciente;
    @NotBlank(message = "LA FECHA DE NACIMIENTO NO debe estar vacio")
    private String fechaNacimiento;

    private String direccionPaciente;

    private String telefonoPaciente;
    @NotBlank(message = "EL EMAIL DEL PACIENTE NO  debe estar vacio")
    @Email(message = "el EMAIL DEL PACIENTE es invalido")
    private String emailPaciente;
    @NotBlank(message = "ASIGNA UN CAMPO DE GENERO AL PACIENTE")
    private String sexoPaciente;

    private String estadoCivilPaciente;

    private String ocupacionPaciente;

    private String telefono;

    private List<Consulta> consultas;
}
