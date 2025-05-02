package com.kalettre.gestionMedica.models;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Paciente {

        @Id
        @Getter
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long idPaciente;

        private String nombrePaciente;

        private String apellidoPaciente;

        private String fechaNacimiento;

        private String direccionPaciente;

        private String telefonoPaciente;

        private String emailPaciente;

        private String sexoPaciente;

        private String estadoCivilPaciente;

        private String ocupacionPaciente;

        private String telefono;

        @OneToMany(mappedBy = "paciente")
        private List<Consulta> consultas;

    }


