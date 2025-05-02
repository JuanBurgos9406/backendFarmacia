package com.kalettre.gestionMedica.services;


import com.kalettre.gestionMedica.dto.MedicamentoDto;
import com.kalettre.gestionMedica.models.Medicamento;
import com.kalettre.gestionMedica.mappers.MedicamentoMapper;
import com.kalettre.gestionMedica.repositories.MedicamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MedicamentoService {

    // Inyecta el repositorio de medicamentos aquí
     private final MedicamentoRepository medicamentoRepository;

     public MedicamentoService(MedicamentoRepository medicamentoRepository) {
         this.medicamentoRepository = medicamentoRepository;
    }


    public MedicamentoDto obtenerPorId(Long id) {
        Optional<Medicamento> optional = medicamentoRepository.findById(id);
        return optional.map(MedicamentoMapper::medicamentoToMedicamentoDto).orElse(null);
    }

    public MedicamentoDto guardar(MedicamentoDto dto) {
        Medicamento medicamento = MedicamentoMapper.medicamentoDtoToMedicamento(dto);
        Medicamento guardado = medicamentoRepository.save(medicamento);
        return MedicamentoMapper.medicamentoToMedicamentoDto(guardado);
    }

    public MedicamentoDto actualizar(Long id, MedicamentoDto dto) {
        Optional<Medicamento> optional = medicamentoRepository.findById(id);

        if (optional.isPresent()) {
            Medicamento existente = optional.get();

            // Actualizar campos
            existente.setNombreMedicamento(dto.getNombreMedicamento());
            existente.setDescripcionMedicamento(dto.getDescripcionMedicamento());
            existente.setFechaVencimiento(dto.getFechaVencimiento());
            existente.setCantidadMedicamento(dto.getCantidadMedicamento());
            existente.setPrecioMedicamento(dto.getPrecioMedicamento());

            Medicamento actualizado = medicamentoRepository.save(existente);
            return MedicamentoMapper.medicamentoToMedicamentoDto(actualizado);
        }

        return null;
    }

    public void eliminar(Long id) {
        medicamentoRepository.deleteById(id);
    }

    public List<MedicamentoDto> obtenerTodos() {
        return medicamentoRepository.findAll()
                .stream()
                .map(MedicamentoMapper::medicamentoToMedicamentoDto)
                .collect(Collectors.toList());
    }
}

