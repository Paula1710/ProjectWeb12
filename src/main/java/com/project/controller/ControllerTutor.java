/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.controller;

import com.project.model.Empresa;
import com.project.service.TutorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Paula
 */
@RestController
public class ControllerTutor {

    @Autowired
    private TutorService tutorService;

    @GetMapping("/tutor")
    public String findEmpresas(Model model){
        final List<Empresa> listaEmpresas = tutorService.listarEmpresa();
        model.addAttribute("listaEmpresas", listaEmpresas);
        return "index";
    }
}
