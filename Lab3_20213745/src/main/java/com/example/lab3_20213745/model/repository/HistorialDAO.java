package com.example.lab3_20213745.model.repository;

import com.example.lab3_20213745.model.bean.Historial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistorialDAO extends JpaRepository<Historial, Long> {
    List<Historial> findByEmpleado_Id(Long empleadoId);
}
