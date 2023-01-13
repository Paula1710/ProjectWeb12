/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.project.repository;

import com.project.model.Empresa;
import com.project.model.Practica;
import com.project.model.Tutor;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Interfaz TutorRepo
 * 
 * @author Grupo12
 */
public interface TutorRepo extends JpaRepository<Tutor, Integer> {

    
    /**
     * Método listaCorreoTutor()
     *
     * @return Retorna una lista de todos los correos de los tutores
     */
    @Query(nativeQuery = true, value = "SELECT tutor.correo FROM tutor")
    List<String> listaCorreoTutor();
    
    /**
     * Método getPasswordTutor(String correo)
     *
     * @param correo Correo del tutor
     * @return Retorna la contraseña de un tutor dado su correo
     */
    @Query(nativeQuery=true, value="SELECT tutor.contrasenna FROM tutor WHERE tutor.correo=(:correo);" )
    String getPasswordTutor(String correo);
   
    /**
     * Método getIdTutor(String correo)
     *
     * @param correo Correo del tutor
     * @return Retorna la Id del tutor dado su correo
     */
    @Query(nativeQuery=true, value="SELECT tutor.id FROM tutor WHERE tutor.correo = (:correo);")
    Integer getIdTutor(String correo);
    
    /**
     * Método findTutor(int id)
     *
     * @param id Id del tutor
     * @return Retorna el tutor dado su Id
     */
    @Query(nativeQuery=true, value = "SELECT tutor.* FROM tutor WHERE tutor.id= (:id);")
    Tutor findTutor(int id);
    
   
}
