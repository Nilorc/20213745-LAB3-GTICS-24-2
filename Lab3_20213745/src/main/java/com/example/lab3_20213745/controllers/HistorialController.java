package com.example.lab3_20213745.controllers;

import com.example.lab3_20213745.model.bean.Empleado;
import com.example.lab3_20213745.model.bean.Historial;
import com.example.lab3_20213745.model.repository.EmpleadoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/empleados")
public class HistorialController {

    @Autowired
    private EmpleadoDAO historialEmpleado;

    @GetMapping("/historial")
    public String historialEmpleados(Model model) {
        List<Empleado> historial = historialEmpleado.findAll();
        model.addAttribute("historial", historial);
        return "/historial";
    }
}
