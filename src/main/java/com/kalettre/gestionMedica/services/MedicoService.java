package com.kalettre.gestionMedica.services;

import com.kalettre.gestionMedica.dto.MedicoDto;
import com.kalettre.gestionMedica.mappers.MedicoMapper;
import com.kalettre.gestionMedica.models.Medico;
import com.kalettre.gestionMedica.repositories.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    public List<MedicoDto> obtenerTodos() {
        return medicoRepository.findAll()
                .stream()
                .map(MedicoMapper::medicoToDto)
                .collect(Collectors.toList());
    }

    public MedicoDto obtenerPorId(Long id) {
        Optional<Medico> medico = medicoRepository.findById(id);
        return medico.map(MedicoMapper::medicoToDto).orElse(null);
    }

    public MedicoDto crear(MedicoDto dto) {
        Medico medico = MedicoMapper.dtoToMedico(dto);
        Medico guardado = medicoRepository.save(medico);
        return MedicoMapper.medicoToDto(guardado);
    }

    public MedicoDto actualizar(Long id, MedicoDto dto) {
        Optional<Medico> optional = medicoRepository.findById(id);

        if (optional.isPresent()) {
            Medico existente = optional.get();

            existente.setNombreMedico(dto.getNombreMedico());
            existente.setApellidoMedico(dto.getApellidoMedico());
            existente.setEspecialidad(dto.getEspecialidad());
            existente.setConsultas(dto.getConsultas());

            Medico actualizado = medicoRepository.save(existente);
            return MedicoMapper.medicoToDto(actualizado);
        }

        return null;
    }

    public void eliminar(Long id) {
        medicoRepository.deleteById(id);
    }
}