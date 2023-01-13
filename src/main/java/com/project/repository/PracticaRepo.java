/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.project.repository;

import com.project.model.Alumno;
import com.project.model.Empresa;
import com.project.model.Practica;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Interfaz PracticaRepo
 * 
 * @author Grupo12
 */
public interface PracticaRepo extends JpaRepository<Practica,Integer>{
    
    /**
     * Método getPracticaAlumno(int id)
     *
     * @param id Id del alumno
     * @return Retorna una práctica dado el Id del alumno
     */
    @Query(nativeQuery=true, value = "SELECT practicas.* FROM practicas INNER JOIN alumno ON practicas.alumno_id = alumno.id WHERE alumno.id = (:id)")
    Practica getPracticaAlumno(int id );
    
    /**
     * Método getPracticasTutor()
     *
     * @return Retorna una lista de prácticas
     */
    @Query(nativeQuery=true, value ="SELECT practicas.* FROM practicas WHERE practicas.nota_practica != 0 ;")
    List<Practica> getPracticasTutor();
    
    /**
     * Método getPractica(int id)
     *
     * @param id Id de las prácticas
     * @return Retorna una práctica dado su Id
     */
    @Query(nativeQuery=true, value ="SELECT practicas.* FROM practicas WHERE practicas.id =(:id)")
    Practica getPractica(int id);
}
