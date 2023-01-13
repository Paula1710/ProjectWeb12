/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.project.repository;

import com.project.model.InformeAlumno;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Clase InformeAlumnoRepo
 * 
 * @author Grupo12
 */
public interface InformeAlumnoRepo extends JpaRepository<InformeAlumno,Integer>{
    
}
