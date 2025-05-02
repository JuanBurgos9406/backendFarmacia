package com.kalettre.gestionMedica.services;

import com.kalettre.gestionMedica.dto.ConsultaDto;
import com.kalettre.gestionMedica.models.Consulta;
import com.kalettre.gestionMedica.repositories.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kalettre.gestionMedica.mappers.ConsultaMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    public List<ConsultaDto> obtenerTodas() {
        return consultaRepository.findAll()
                .stream()
                .map(ConsultaMapper::consultaToConsultaDto)
                .collect(Collectors.toList());
    }

    public ConsultaDto obtenerPorId(Long id) {
        Optional<Consulta> consulta = consultaRepository.findById(id);
        return consulta.map(ConsultaMapper::consultaToConsultaDto).orElse(null);
    }

    public ConsultaDto crear(ConsultaDto dto) {
        Consulta consulta = ConsultaMapper.consultaDtoToConsulta(dto);
        Consulta guardada = consultaRepository.save(consulta);
        return ConsultaMapper.consultaToConsultaDto(guardada);
    }

    public ConsultaDto actualizar(Long id, ConsultaDto dto) {
        Optional<Consulta> optional = consultaRepository.findById(id);

        if (optional.isPresent()) {
            Consulta existente = optional.get();

            existente.setFechaConsulta(dto.getFechaConsulta());
            existente.setMotivoConsulta(dto.getMotivoConsulta());
            existente.setDiagnostico(dto.getDiagnostico());
            existente.setTratamiento(dto.getTratamiento());
            existente.setPaciente(dto.getPaciente());
            existente.setMedico(dto.getMedico());
            existente.setMedicamentos(dto.getMedicamentos());

            Consulta actualizada = consultaRepository.save(existente);
            return ConsultaMapper.consultaToConsultaDto(actualizada);
        }

        return null;
    }

    public void eliminar(Long id) {
        consultaRepository.deleteById(id);
    }
}

