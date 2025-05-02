package com.kalettre.gestionMedica.mappers;

import com.kalettre.gestionMedica.dto.MedicoDto;
import com.kalettre.gestionMedica.models.Medico;

public class MedicoMapper {

    public static MedicoDto medicoToDto(Medico medico) {
        if (medico == null) {
            return null;
        }

        MedicoDto dto = new MedicoDto();
        dto.setIdMedico(medico.getIdMedico());
        dto.setNombreMedico(medico.getNombreMedico());
        dto.setApellidoMedico(medico.getApellidoMedico());
        dto.setEspecialidad(medico.getEspecialidad());
        dto.setConsultas(medico.getConsultas()); // Conversión directa

        return dto;
    }

    public static Medico dtoToMedico(MedicoDto dto) {
        if (dto == null) {
            return null;
        }

        Medico medico = new Medico();
        medico.setIdMedico(dto.getIdMedico());
        medico.setNombreMedico(dto.getNombreMedico());
        medico.setApellidoMedico(dto.getApellidoMedico());
        medico.setEspecialidad(dto.getEspecialidad());
        medico.setConsultas(dto.getConsultas()); // Conversión directa

        return medico;
    }
}
