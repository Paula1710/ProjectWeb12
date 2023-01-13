
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.controller;

import com.config.ControlLog;
import com.project.controller.ControllerID;
import com.project.model.Alumno;
import com.project.model.Empresa;
import com.project.model.Practica;
import com.project.model.Tutor;
import com.project.repository.AlumnoRepo;
import com.project.repository.EmpresaRepo;
import com.project.repository.PracticaRepo;
import com.project.repository.TutorRepo;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Clase ControllerTutor
 * 
 * @author Grupo12
 */
@Controller
public class ControllerTutor {

    private int id_empresas = 0;
    private static final Logger LOG = ControlLog.getLogger(ControllerTutor.class);
        
    @Autowired 
    private TutorRepo tutorRepo;
    
    @Autowired 
    private EmpresaRepo empresaRepo;
    
    @Autowired
    private PracticaRepo practRepo;
    
    @Autowired
    private AlumnoRepo alumRepo;

    /**
     * Método tutor()
     * 
     * @return Retorna la página de inicio de tutor
     */
    @RequestMapping("/tutor")
    public String tutor() {
        LOG.info("Página de inicio del tutor");
        return "tutor";
    }

    /**
     * Método findEmpresas(Model modelo)
     * 
     * @param modelo Parámetro para pasar valores al html
     * @return Retorna la página verEmpresa donde se encunetra una lista con todas las empresas asociadas al tutor
     */
    @RequestMapping("/tutor/verEmpresa")
    public String findEmpresas( Model modelo) {
        final List<Empresa> listaEmpresasTutor = empresaRepo.getEmpresaTutor(ControllerID.IDTUTOR);
        final List<Empresa> listaEmpresaTotal = empresaRepo.findAll();
        modelo.addAttribute("listaEmpresas", listaEmpresasTutor);
        Empresa empresa = listaEmpresaTotal.get(listaEmpresaTotal.size()-1);
        id_empresas= empresa.getId();
        LOG.info("El tutor: "+ ControllerID.IDTUTOR + " está viendo sus empresas asociadas. Las empresas son: " + listaEmpresasTutor);
        return "verEmpresa";
    }

    /**
     * Método addEmpresa(Model modelo)
     * 
     * @param modelo Parámetro para pasar valores al html
     * @return Retorna una página donde aparece un formulario para dar de alta una nueva empresa, el id del tutor ya aparece por defecto
     */
    @RequestMapping("/tutor/verEmpresa/altaEmpresa")
    public String addEmpresa(Model modelo) {
        int id = ControllerID.IDTUTOR;
        Tutor tutor = tutorRepo.findTutor(id);
        modelo.addAttribute("tutor",tutor);        
        return "altaEmpresa";
    }
    
    /**
     * Método guardarEmpresa(@ModelAttribute("empresa") Empresa empresa)
     * 
     * @param empresa Parámetro para coger valores del html
     * @return Vuelve a la página verEmpresa una vez que se han rellenado los datos del formulario altaEmpresa y se ha registrado la misma
     */
    @RequestMapping(value = "/tutor/verEmpresa/altaEmpresa/guardar", method = RequestMethod.POST)
    public String guardarEmpresa(@ModelAttribute("empresa") Empresa empresa) {
        Empresa emp = new Empresa();
        emp.setTutor_id(ControllerID.IDTUTOR); //poner id del tutor
        emp.setNombre(empresa.getNombre());
        emp.setId(id_empresas + 1);
        emp.setCapacidad(empresa.getCapacidad());
        emp.setDireccion(empresa.getDireccion());
        emp.setTelefono(empresa.getTelefono());
        emp.setTurnos(empresa.getTurnos());
        emp.setSemanas(empresa.getSemanas());
        empresaRepo.save(emp);
        LOG.info("El tutor: " + ControllerID.IDTUTOR + " ha dado de alta a la empresa: " + emp.toString());
        return "redirect:/tutor/verEmpresa";
    }
    
    /**
     * Método eliminarEmpresa
     * 
     * @param id id de la empresa
     * @return Vueleve a la página verEmpresa una vez que el tutor haya pulsado el botón borrar que elimina una empresa según su id
     */
    @RequestMapping("/tutor/verEmpresa/eliminarEmpresa/{id}")
    public String eliminarEmpresa(@PathVariable(name="id")Integer id){
        empresaRepo.deleteById(id);
        LOG.info("El tutor: " + ControllerID.IDTUTOR + " ha eliminado la empresa cuya id es: "+id );
        return "redirect:/tutor/verEmpresa"; 
    }
    
    /**
     * Método informePracticas(Model modelo)
     * 
     * @param modelo Parámetro para pasar valores al html
     * @return Retorna la página redactarInforme en la que se encuentra una lista con los alumnos asociados y, de cada alumno muestra el nombre de la empresa a la que pertenece y el informe de la práctica
     */
    @RequestMapping("tutor/redactarInforme")
    public String informePracticas(Model modelo){
        List<Alumno> alumnosPracticas = alumRepo.getAlumnoPracticas(ControllerID.IDTUTOR);
        modelo.addAttribute("alumnosPracticas", alumnosPracticas);
        List<Empresa> empresaPracticas = new ArrayList<>();
        List<Practica> practicaPracticas= new ArrayList<>();
        for (int i = 0; i < alumnosPracticas.size(); i++) {
            Empresa empresa = empresaRepo.getEmpresaIdAlumno(alumnosPracticas.get(i).getId()); 
            empresaPracticas.add(empresa);
            modelo.addAttribute("empresaPracticas", empresaPracticas);
            Practica practica= practRepo.getPracticaAlumno(alumnosPracticas.get(i).getId());
            practicaPracticas.add(practica);
            modelo.addAttribute("practicaPracticas", practicaPracticas);
        }
        LOG.info("El tutor: " + ControllerID.IDTUTOR + "está viendo los informe de los alumnos que tiene asociados. Los alumnos son: "+ alumnosPracticas);
        
        
        return "redactarInforme";
    }
    
    /**
     * Método mostrarInforme(@PathVariable("id" Integer id, Model modelo)
     * 
     * @param id id de la práctica
     * @param modelo Parámetro para pasar valores al html
     * @return Retorna la página editarNota en la que se pueden modificar tanto la nota de la práctica como el comentario 
     */
    @RequestMapping(value="/tutor/redactarInforme/editarNota/{id}", method=RequestMethod.GET)
    public String mostrarInforme(@PathVariable("id") Integer id, Model modelo){
        Practica practica = practRepo.getPractica(id);
        modelo.addAttribute("practica",practica);
        return "editarNota";
    }
    
    /**
     * Método actualizarInform(@PathVariable("id") Integer id, @ModelAttribute("practicas_Tutor) Practica practica)
     * 
     * @param id id de la practica 
     * @param practica Parámetro para coger valores del html
     * @return Vuelve a la página redactarInforme una vez que haya actualizado el comentario y la nota de un alumno en concreto
     */
    @RequestMapping(value="/tutor/redactarInforme/editarNota/{id}/guardar", method=RequestMethod.POST)
    public String actualizarInforme(@PathVariable("id") Integer id,@ModelAttribute("practicas_Tutor") Practica practica){
        Practica practicaId = practRepo.getPractica(id);
        practicaId.setNota_practica(practica.getNota_practica());
        practicaId.setInforme(practica.getInforme());
        practRepo.save(practicaId);
        LOG.info("El tutor: "+ ControllerID.IDTUTOR + " ha editado el informe de la práctica cuya id es: " + id);
        return "redirect:/tutor/redactarInforme";
    }

}
