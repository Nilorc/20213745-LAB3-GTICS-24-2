package com.example.lab3_20213745.model.repository;

import com.example.lab3_20213745.model.bean.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartamentoDAO extends JpaRepository<Departamento, Long> {

}
