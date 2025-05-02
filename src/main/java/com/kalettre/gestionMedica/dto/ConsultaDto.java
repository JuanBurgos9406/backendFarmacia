package com.kalettre.gestionMedica.dto;

import com.kalettre.gestionMedica.models.Medicamento;
import com.kalettre.gestionMedica.models.Medico;
import com.kalettre.gestionMedica.models.Paciente;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
@Data
public class ConsultaDto {

    private Long idconsulta;
    @NotBlank(message = "INGRESA LA FECHA DE LA CONSULTA")
    private LocalDate fechaConsulta;
    @NotBlank(message = "INGRESA EL MOTIVO DE LA CONSULTA")
    private String motivoConsulta;
    @NotBlank(message = "INGRESA EL DIAGNOSTICO DE LA CONSULTA")
    private String diagnostico;
    @NotBlank(message = "INGRESA EL TRATAMIENTO DE LA CONSULTA")
    private String tratamiento;
    @NotBlank(message = "INGRESA EL PACIENTE DE LA CONSULTA")
    private Paciente paciente;
    @NotBlank(message = "INGRESA EL MEDICO DE LA CONSULTA")
    private Medico medico;
    @NotBlank(message = "INGRESA LOS MEDICAMENTOS DE LA CONSULTA")
    private List<Medicamento> medicamentos;

}
