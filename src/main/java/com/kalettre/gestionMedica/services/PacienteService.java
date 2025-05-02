package com.kalettre.gestionMedica.services;

import com.kalettre.gestionMedica.dto.PacienteDto;
import com.kalettre.gestionMedica.mappers.PacienteMapper;
import com.kalettre.gestionMedica.models.Paciente;
import com.kalettre.gestionMedica.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    public List<PacienteDto> obtenerTodos() {
        return pacienteRepository.findAll()
                .stream()
                .map(PacienteMapper::pacienteToDto)
                .collect(Collectors.toList());
    }

    public PacienteDto obtenerPorId(Long id) {
        Optional<Paciente> paciente = pacienteRepository.findById(id);
        return paciente.map(PacienteMapper::pacienteToDto).orElse(null);
    }

    public PacienteDto crear(PacienteDto dto) {
        Paciente paciente = PacienteMapper.dtoToPaciente(dto);
        Paciente guardado = pacienteRepository.save(paciente);
        return PacienteMapper.pacienteToDto(guardado);
    }

    public PacienteDto actualizar(Long id, PacienteDto dto) {
        Optional<Paciente> optional = pacienteRepository.findById(id);

        if (optional.isPresent()) {
            Paciente existente = optional.get();

            existente.setNombrePaciente(dto.getNombrePaciente());
            existente.setApellidoPaciente(dto.getApellidoPaciente());
            existente.setFechaNacimiento(dto.getFechaNacimiento());
            existente.setDireccionPaciente(dto.getDireccionPaciente());
            existente.setTelefonoPaciente(dto.getTelefonoPaciente());
            existente.setEmailPaciente(dto.getEmailPaciente());
            existente.setSexoPaciente(dto.getSexoPaciente());
            existente.setEstadoCivilPaciente(dto.getEstadoCivilPaciente());
            existente.setOcupacionPaciente(dto.getOcupacionPaciente());
            existente.setTelefono(dto.getTelefono());
            existente.setConsultas(dto.getConsultas());

            Paciente actualizado = pacienteRepository.save(existente);
            return PacienteMapper.pacienteToDto(actualizado);
        }

        return null;
    }

    public void eliminar(Long id) {
        pacienteRepository.deleteById(id);
    }
}
