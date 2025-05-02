package com.kalettre.gestionMedica.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idconsulta;

    private LocalDate fechaConsulta;

    private String motivoConsulta;

    private String diagnostico;

    private String tratamiento;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "medico_id")
    private Medico medico;

    @OneToMany
    private List<Medicamento> medicamentos;




}
