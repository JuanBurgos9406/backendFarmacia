package com.kalettre.gestionMedica.mappers;

import com.kalettre.gestionMedica.dto.MedicamentoDto;
import com.kalettre.gestionMedica.models.Medicamento;

public class MedicamentoMapper {

    // Convertir de Medicamento a MedicamentoDto
    public static MedicamentoDto medicamentoToMedicamentoDto(Medicamento medicamento) {
        if (medicamento == null) {
            return null;
        }

        MedicamentoDto medicamentoDto = new MedicamentoDto();

        medicamentoDto.setIdMedicamento(medicamento.getIdMedicamento());
        medicamentoDto.setNombreMedicamento(medicamento.getNombreMedicamento());
        medicamentoDto.setDescripcionMedicamento(medicamento.getDescripcionMedicamento());
        medicamentoDto.setFechaVencimiento(medicamento.getFechaVencimiento());
        medicamentoDto.setCantidadMedicamento(medicamento.getCantidadMedicamento());
        medicamentoDto.setPrecioMedicamento(medicamento.getPrecioMedicamento());

        return medicamentoDto;
    }

    // Convertir de MedicamentoDto a Medicamento
    public static Medicamento medicamentoDtoToMedicamento(MedicamentoDto medicamentoDto) {
        if (medicamentoDto == null) {
            return null;
        }

        Medicamento medicamento = new Medicamento();

        medicamento.setIdMedicamento(medicamentoDto.getIdMedicamento());
        medicamento.setNombreMedicamento(medicamentoDto.getNombreMedicamento());
        medicamento.setDescripcionMedicamento(medicamentoDto.getDescripcionMedicamento());
        medicamento.setFechaVencimiento(medicamentoDto.getFechaVencimiento());
        medicamento.setCantidadMedicamento(medicamentoDto.getCantidadMedicamento());
        medicamento.setPrecioMedicamento(medicamentoDto.getPrecioMedicamento());

        return medicamento;
    }
}
