/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.project.repository;

import com.project.model.Practica;
import com.project.model.Tutor;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


/**
 *
 * @author Alberto Galindo
 */
public interface TutorRepo extends JpaRepository<Tutor,Integer> {
   
    @Query(nativeQuery= true, value = "SELECT practicas.* FROM tutor INNER JOIN empresa ON tutor.id = empresa.tutor_id \n" +
"INNER JOIN practicas ON empresa.id = practicas.empresa_id \n" +
"INNER JOIN alumno ON alumno.id = practicas.alumno_id \n" +
"WHERE tutor.id = (.id)")
    public List<Practica> findAllPracticas(int id);
    }
