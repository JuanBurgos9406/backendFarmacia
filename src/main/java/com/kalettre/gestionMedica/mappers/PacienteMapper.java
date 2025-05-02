package com.kalettre.gestionMedica.mappers;

import com.kalettre.gestionMedica.dto.PacienteDto;
import com.kalettre.gestionMedica.models.Paciente;

public class PacienteMapper {

    public static PacienteDto pacienteToDto(Paciente paciente) {
        if (paciente == null) {
            return null;
        }

        PacienteDto dto = new PacienteDto();

        dto.setIdPaciente(paciente.getIdPaciente());
        dto.setNombrePaciente(paciente.getNombrePaciente());
        dto.setApellidoPaciente(paciente.getApellidoPaciente());
        dto.setFechaNacimiento(paciente.getFechaNacimiento());
        dto.setDireccionPaciente(paciente.getDireccionPaciente());
        dto.setTelefonoPaciente(paciente.getTelefonoPaciente());
        dto.setEmailPaciente(paciente.getEmailPaciente());
        dto.setSexoPaciente(paciente.getSexoPaciente());
        dto.setEstadoCivilPaciente(paciente.getEstadoCivilPaciente());
        dto.setOcupacionPaciente(paciente.getOcupacionPaciente());
        dto.setTelefono(paciente.getTelefono());
        dto.setConsultas(paciente.getConsultas());

        return dto;
    }

    public static Paciente dtoToPaciente(PacienteDto dto) {
        if (dto == null) {
            return null;
        }

        Paciente paciente = new Paciente();

        paciente.setIdPaciente(dto.getIdPaciente());
        paciente.setNombrePaciente(dto.getNombrePaciente());
        paciente.setApellidoPaciente(dto.getApellidoPaciente());
        paciente.setFechaNacimiento(dto.getFechaNacimiento());
        paciente.setDireccionPaciente(dto.getDireccionPaciente());
        paciente.setTelefonoPaciente(dto.getTelefonoPaciente());
        paciente.setEmailPaciente(dto.getEmailPaciente());
        paciente.setSexoPaciente(dto.getSexoPaciente());
        paciente.setEstadoCivilPaciente(dto.getEstadoCivilPaciente());
        paciente.setOcupacionPaciente(dto.getOcupacionPaciente());
        paciente.setTelefono(dto.getTelefono());
        paciente.setConsultas(dto.getConsultas());

        return paciente;
    }
}

