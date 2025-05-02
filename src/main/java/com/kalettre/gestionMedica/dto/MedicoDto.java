package com.kalettre.gestionMedica.dto;

import com.kalettre.gestionMedica.models.Consulta;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Data
public class MedicoDto {


        private Long idMedico;

        @NotBlank(message = "el NOMBRE DEL MEDICO NO debe estar vacio")
        private String nombreMedico;

        @NotBlank(message = "el APELLIDO DEL MEDICO NO debe estar vacio")
        private String apellidoMedico;

        @NotBlank(message = "LA ESPECIALIDAD DEL MEDICO NO debe estar vacio")
        private String Especialidad;

        private List<Consulta> consultas;
    }

