/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.project.repository;

import com.project.model.Telefono;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Alberto Galindo
 */
public interface TelefonoRepo extends JpaRepository<Telefono,Integer> {
    
}
