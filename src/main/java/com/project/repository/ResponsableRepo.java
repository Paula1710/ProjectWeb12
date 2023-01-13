/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.project.repository;

import com.project.model.Responsable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Interfaz ResponsableRepo
 * 
 * @author Grupo12
 */
public interface ResponsableRepo extends JpaRepository<Responsable, Integer> {

    /**
     * Método listaCorreoResponsable()
     *
     * @return Retorna una lista de correos del responsable
     */
    @Query(nativeQuery = true, value = "SELECT responsable.correo FROM responsable")
    List<String> listaCorreoResponsable();
    
    /**
     * Método getPasswordResponsable(String correo)
     *
     * @param correo Correo del responsable
     * @return Retorna una contraseña del responsable dado su correo
     */
    @Query(nativeQuery=true, value="SELECT responsable.contrasenna FROM responsable WHERE responsable.correo=(:correo);" )
    String getPasswordResponsable(String correo);
    
    /**
     * Método getPasswordResponsable(String correo)
     *
     * @param correo Correo del responsable
     * @return Retorna una contraseña del responsable dado su correo
     */
    @Query(nativeQuery=true, value="SELECT responsable.id FROM responsable WHERE responsable.correo = (:correo);")
    Integer getIdResponsable(String correo);
}
