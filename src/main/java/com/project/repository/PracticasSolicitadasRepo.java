/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.project.repository;

import com.project.model.PracticasSolicitadas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Interfaz PracticasSolicitadasRepo
 * 
 * @author Grupo12
 */
public interface PracticasSolicitadasRepo extends JpaRepository<PracticasSolicitadas,Integer>{
   
    /**
     * Método findPracticaSolicitada(int id)
     *
     * @param id Id de las prácticas solicitadas
     * @return Retorna una práctica solicitada dado su Id
     */
    @Query(nativeQuery=true,value = "SELECT practicas_solicitadas.* FROM practicas_solicitadas WHERE id=(:id);")
    PracticasSolicitadas findPracticaSolicitada(int id); 
    
    /**
     * Método borrarPracticasSolicitadas(int id)
     *
     * @param id Id del alumno
     * Borra las practicas solicitadas cuando se asigna una
     */
    @Query(nativeQuery=true,value = "DELETE practicas_solicitadas.* FROM practicas_solicitadas INNER JOIN alumno ON practicas_solicitadas.alumno_id =alumno.id WHERE alumno.id=(:id);")
    void borrarPracticasSolicitadas(int id); 
}
