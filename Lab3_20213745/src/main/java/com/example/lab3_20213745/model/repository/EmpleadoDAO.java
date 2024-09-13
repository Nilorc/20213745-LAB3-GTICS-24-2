package com.example.lab3_20213745.model.repository;

import com.example.lab3_20213745.model.bean.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmpleadoDAO extends JpaRepository<Empleado, Long> {

    // Metodo para actualizar
    @Modifying
    @Query("UPDATE Empleado e SET e.telefono = :telefono, e.salario = :salario WHERE e.id = :id")
    void actualizarTelefonoYSalario(@Param("telefono") String telefono,
                                    @Param("salario") Double salario,
                                    @Param("id") Long id);

    List<Empleado> findByNombreContainingIgnoreCase(String nombre);

    List<Empleado> findByApellidoContainingIgnoreCase(String apellido);

    List<Empleado> findByCargoContainingIgnoreCase(String cargo);

    List<Empleado> findAllByOrderBySalarioDesc();
}

