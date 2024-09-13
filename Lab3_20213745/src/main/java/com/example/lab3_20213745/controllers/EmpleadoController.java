package com.example.lab3_20213745.controllers;

import com.example.lab3_20213745.model.bean.Empleado;
import com.example.lab3_20213745.model.repository.EmpleadoDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadoDAO empleadoDAO;

    @GetMapping
    public String listarEmpleados(@RequestParam(required = false) String filtroNombre,
                                  @RequestParam(required = false) String filtroApellido,
                                  @RequestParam(required = false) String filtroCargo,
                                  Model model) {
        List<Empleado> empleados;

        if (filtroNombre != null && !filtroNombre.isEmpty()) {
            empleados = empleadoDAO.findByNombreContainingIgnoreCase(filtroNombre);
        } else if (filtroApellido != null && !filtroApellido.isEmpty()) {
            empleados = empleadoDAO.findByApellidoContainingIgnoreCase(filtroApellido);
        } else if (filtroCargo != null && !filtroCargo.isEmpty()) {
            empleados = empleadoDAO.findByCargoContainingIgnoreCase(filtroCargo);
        } else {
            empleados = empleadoDAO.findAllByOrderBySalarioDesc();
        }

        model.addAttribute("empleados", empleados);
        return "empleados";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicion(@PathVariable Long id, Model model) {
        Empleado empleado = empleadoDAO.findById(id).orElse(null);
        if (empleado == null) {
            return "redirect:/empleados";
        }
        model.addAttribute("empleado", empleado);
        return "/formulario";
    }

    @PostMapping("/actualizar")
    public String actualizarEmpleado(@ModelAttribute Empleado empleado) {

        Empleado empleadoExistente = empleadoDAO.findById(empleado.getId()).orElse(null);
        if (empleadoExistente != null) {

            empleadoDAO.actualizarTelefonoYSalario(empleado.getTelefono(), empleado.getSalario(), empleado.getId());
        }
        return "redirect:/empleados";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarEmpleado(@PathVariable Long id) {

        empleadoDAO.deshabilitarEmpleado(id);
        return "redirect:/empleados";
    }
}
