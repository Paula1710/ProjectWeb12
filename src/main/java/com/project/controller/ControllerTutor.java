/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.controller;

import com.project.model.Empresa;
import com.project.model.Practica;
import com.project.service.TutorService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Paula
 */
@Controller
public class ControllerTutor {

    @Autowired
    private TutorService tutorService;

    @RequestMapping("/tutor")
    public String findEmpresas(Model modelo){
        final List<Empresa> listaEmpresas = tutorService.listarEmpresa();
        modelo.addAttribute("listaEmpresas", listaEmpresas);
        return "index";
    }
    
    @RequestMapping("/tutor/nuevaEmpresa")
    public String addEmpresa(Model modelo){
        Empresa empresa = new Empresa();
        modelo.addAttribute("empresa",empresa);
        return "index";
    }
    
    @RequestMapping(value = "/tutor/guardarEmpresa", method = RequestMethod.POST)
    public String saveEmpresa (@ModelAttribute("empresa") Empresa empresa){
        tutorService.crearEmpresa(empresa);
        return "redirect:/index";
    }
    
    @RequestMapping("/tutor/editar/{id}")
    public ModelAndView editarEmpresa(@PathVariable(name ="id")Integer id){
        ModelAndView modelo = new ModelAndView("modificar_empresa");
        Optional<Empresa> empresa = tutorService.getEmpresa(id);
        modelo.addObject("empresa",empresa);
        return modelo;
    }
    
    @RequestMapping("/tutor/eliminarEmpresa/{id}")
    public String eliminarEmpresa(@PathVariable(name="id")Integer id){
        tutorService.borrarEmpresa(id);
        return "redirect:/index";
    }
    
    @RequestMapping ("/tutor/informePracticas")
    public String informePracticas(Model modelo, @PathVariable(name="id") Integer id){ // id del tutor
        List<Practica> practicasAlumno =  tutorService.listarPracticasTutor(id);
        modelo.addAttribute("practicasAlumno", practicasAlumno);
        return "index"; 
    }
    
    /*
    @RequestMapping ("tutor/editarInformePrácticas/{id}") //id del alumno
    public ModelAndView editarInformePracticas (@PathVariable(name="id")Integer id){
        ModelAndView modelo = new ModelAndView ("editar_informe");
        Practica practica = 
    }
    */
}
