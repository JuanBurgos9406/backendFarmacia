package com.kalettre.gestionMedica.mappers;

import com.kalettre.gestionMedica.dto.ConsultaDto;
import com.kalettre.gestionMedica.models.Consulta;

public class ConsultaMapper {

    // Convertir de Consulta a ConsultaDto
    public static ConsultaDto consultaToConsultaDto(Consulta consulta) {
        if (consulta == null) {
            return null;
        }

        ConsultaDto consultaDto = new ConsultaDto();

        consultaDto.setIdconsulta(consulta.getIdconsulta());
        consultaDto.setFechaConsulta(consulta.getFechaConsulta());
        consultaDto.setMotivoConsulta(consulta.getMotivoConsulta());
        consultaDto.setDiagnostico(consulta.getDiagnostico());
        consultaDto.setTratamiento(consulta.getTratamiento());
        consultaDto.setPaciente(consulta.getPaciente());
        consultaDto.setMedico(consulta.getMedico());
        consultaDto.setMedicamentos(consulta.getMedicamentos());

        return consultaDto;
    }

    // Convertir de ConsultaDto a Consulta
    public static Consulta consultaDtoToConsulta(ConsultaDto consultaDto) {
        if (consultaDto == null) {
            return null;
        }

        Consulta consulta = new Consulta();

        consulta.setIdconsulta(consultaDto.getIdconsulta());
        consulta.setFechaConsulta(consultaDto.getFechaConsulta());
        consulta.setMotivoConsulta(consultaDto.getMotivoConsulta());
        consulta.setDiagnostico(consultaDto.getDiagnostico());
        consulta.setTratamiento(consultaDto.getTratamiento());
        consulta.setPaciente(consultaDto.getPaciente());
        consulta.setMedico(consultaDto.getMedico());
        consulta.setMedicamentos(consultaDto.getMedicamentos());

        return consulta;
    }
}
