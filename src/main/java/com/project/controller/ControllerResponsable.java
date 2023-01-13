/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.controller;

import com.config.ControlLog;
import com.project.model.Alumno;
import com.project.model.Empresa;
import com.project.model.Practica;
import com.project.model.PracticasSolicitadas;
import com.project.repository.AlumnoRepo;
import com.project.repository.EmpresaRepo;
import com.project.repository.PracticaRepo;
import com.project.repository.PracticasSolicitadasRepo;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Clase ControllerResponsable
 * 
 * @author Grupo12
 */
@Controller
public class ControllerResponsable {

    private static final Logger LOG = ControlLog.getLogger(ControllerResponsable.class);
    @Autowired
    private EmpresaRepo empRepo;

    @Autowired
    private AlumnoRepo alumRepo;

    @Autowired
    private PracticaRepo practRepo;

    @Autowired
    private PracticasSolicitadasRepo solicitadasRepo;

    /**
     * Método responsable()
     *
     * @return Retorna la página de inicio de responsable
     */
    @RequestMapping("/responsable")
    public String responsable() {
        LOG.info("Página de inicio del responsable");
        return "responsable";
    }

    /**
     * Método generarInforme(Model modelo)
     *
     * @param modelo Parámetro para pasar valores al html
     * @return Retorna la página informeActas donde se muestra una tabla con
     * todos los informes rellenados por el tutor
     */
    @RequestMapping("/responsable/informeActas")
    public String generarInforme(Model modelo) {
        List<Practica> practicas = practRepo.getPracticasTutor();
        List<Alumno> alumnos = new ArrayList<>();
        modelo.addAttribute("practicas", practicas);
        for (int i = 0; i < practicas.size(); i++) {
            Alumno alumno = alumRepo.getAlumnoPracticasRepo(practicas.get(i).getId());
            alumnos.add(alumno);
            modelo.addAttribute("alumnos", alumnos);
        }
        LOG.info("El responsable con id: " + ControllerID.IDRESPONSABLE + " consulta los informe que han generado los tutores acerca de los alumnos.");
        return "informeActas";
    }

    /**
     * Método consultarInformacion(Model modelo)
     *
     * @param modelo Parámetro para pasar valores al html
     * @return Retorna la página consultarInformación donde aparece el número de
     * alumnos totales y un tabla con las empresas que ofertan prácticas y su
     * capacidad
     */
    @GetMapping("/responsable/consultarInformacion")
    public String consultarInformacion(Model modelo) {
        int alumnosTotal = alumRepo.numeroAlumnos();
        List<Empresa> empresas = empRepo.findAll();
        modelo.addAttribute("alumnosTotal", alumnosTotal);
        modelo.addAttribute("empresas", empresas);
        LOG.info("El responsable con id: " + ControllerID.IDRESPONSABLE + " consulta la información de alumnos y empresas.");
        return "consultarInformacion";
    }

    /**
     * Método asignarPractica(Model modelo)
     * 
     * @param modelo Parámetro para pasar valores al html
     * @return Retorna la página asignarPractica donde aparacen todas las solicitudes de prácticas junto con su alumno y la empresa a la que esté asociada, el responsable puede asignar o rechazar
     */
    @RequestMapping(value = "/responsable/asignarPractica")
    public String asignarPractica(Model modelo) {
        List<PracticasSolicitadas> listaSolicitudes = solicitadasRepo.findAll();

        List<Alumno> alumnosPracticas = new ArrayList<>();
        List<Empresa> empresasPracticas = new ArrayList<>();

        for (int i = 0; i < listaSolicitudes.size(); i++) {

            alumnosPracticas.add(alumRepo.findAlumno(listaSolicitudes.get(i).getAlumno_id()));
            empresasPracticas.add(empRepo.findEmpresa(listaSolicitudes.get(i).getEmpresa_id()));

        }

        modelo.addAttribute("listaSolicitudes", listaSolicitudes);
        modelo.addAttribute("empresasPracticas", empresasPracticas);
        modelo.addAttribute("alumnosPracticas", alumnosPracticas);

        LOG.info("El responsable con id: " + ControllerID.IDRESPONSABLE + " ha entrado en la pantalla para asignar prácticas a los alumnos: " + alumnosPracticas);

        return "asignarPractica";
    }

    /**
     * Método rechazarPractica(@PathVariable(name="id") Integer id)
     * 
     * @param id id de la práctica solicitada
     * @return Vuelve a la página asignarPractica una vez que se haya eliminado de la tabla la practica solicitada debido a que el responsable rechazó su solicitud
     */
    @RequestMapping(value = "/responsable/asignarPractica/rechazar/{id}")
    public String rechazarPractica(@PathVariable(name = "id") Integer id) {
        solicitadasRepo.deleteById(id);
        LOG.info("El responsable con id: " + ControllerID.IDRESPONSABLE + " ha rechazado la solicitud con id: " + id);
        return "redirect:/responsable/asignarPractica";
    }

    /**
     * Método asignar(@PathVariable(name="id" Integer id)
     * 
     * @param id id de la práctica solicitada
     * @return Vuelve a la página asignarPractica una vez que se haya eliminado de la tabla la practica solicitada debido a que el responsable aprobó su solicitud y borra las demás solicitudes
     */
    @RequestMapping(value = "/responsable/asignarPractica/asignar/{id}")
    public String asignar(@PathVariable(name = "id") Integer id) {

        Practica p = new Practica();
        if (practRepo.findAll().isEmpty()) {
            p.setId(1);
        } else {
            p.setId(practRepo.findAll().get(practRepo.findAll().size() - 1).getId() + 1);
        }

        p.setHorario(solicitadasRepo.findPracticaSolicitada(id).getHorario());
        p.setTiempo_practicas(solicitadasRepo.findPracticaSolicitada(id).getTiempo_practicas());
        p.setNota_practica(0);
        p.setInforme(" ");
        p.setAlumno_id(solicitadasRepo.findPracticaSolicitada(id).getAlumno_id());
        p.setEmpresa_id(solicitadasRepo.findPracticaSolicitada(id).getEmpresa_id());
        p.setResponsable_id(solicitadasRepo.findPracticaSolicitada(id).getResponsable_id());
        p.setPreferencia(solicitadasRepo.findPracticaSolicitada(id).getPreferencia());

        practRepo.save(p);
        solicitadasRepo.borrarPracticasSolicitadas(p.getAlumno_id());
        
        
        LOG.info("El responsable con id: " + ControllerID.IDRESPONSABLE + " ha aprobado la solicitudcon id: " + id + ". Se ha creado la práctica " + p.toString());
        return "redirect:/responsable/asignarPractica";
    }

}
