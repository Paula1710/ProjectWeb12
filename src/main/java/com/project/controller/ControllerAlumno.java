/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.controller;

import com.project.model.Alumno;
import com.project.repository.AlumnoRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Alberto Galindo
 */

@RestController
public class ControllerAlumno {
    
    @Autowired
    private AlumnoRepo alumRepo;
    
    @GetMapping("/listar")
	public List<Alumno> listar(){
		
		return alumRepo.findAll();
	}
}
