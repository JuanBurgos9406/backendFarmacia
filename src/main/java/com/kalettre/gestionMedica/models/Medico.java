package com.kalettre.gestionMedica.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idMedico;


    private String nombreMedico;


    private String apellidoMedico;

    @Column(nullable = false)
    private String Especialidad;

    @OneToMany(mappedBy = "medico")
    private List<Consulta> consultas;
}
