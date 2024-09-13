package com.example.lab3_20213745.model.bean;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import jakarta.persistence.ManyToOne;

@Entity
@Getter
@Setter
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;
    private String cargo;
    private String telefono;
    private Double salario;
    private Boolean enabled = true;

    @ManyToOne
    @JoinColumn(name = "departamento_id")
    private Departamento departamento;
}
