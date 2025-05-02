package com.kalettre.gestionMedica.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Medicamento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idMedicamento;

    private String nombreMedicamento;

    private String descripcionMedicamento;

    private LocalDate fechaVencimiento;

    private int cantidadMedicamento;

    private int precioMedicamento;


}
