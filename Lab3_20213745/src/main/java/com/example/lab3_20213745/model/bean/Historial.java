package com.example.lab3_20213745.model.bean;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Historial{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "empleado_id")
    private Empleado empleado;

    @ManyToOne
    @JoinColumn(name = "departamento_id")
    private Departamento departamento;

    private String puesto;

    private LocalDate fechaInicio;

    private LocalDate fechaFin;
}
