/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.controller;

import com.config.ControlLog;
import com.project.model.Alumno;
import com.project.model.Empresa;
import com.project.model.InformeAlumno;
import com.project.model.PracticasSolicitadas;
import com.project.repository.AlumnoRepo;
import com.project.repository.EmpresaRepo;
import com.project.repository.InformeAlumnoRepo;
import com.project.repository.PracticasSolicitadasRepo;
import com.project.controller.ControllerID;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Clase ControllerAlumno
 * 
 * @author Grupo12
 */
@Controller
public class ControllerAlumno {

    private static final org.apache.log4j.Logger LOG = ControlLog.getLogger(ControllerAlumno.class);

    @Autowired
    private AlumnoRepo alumRepo;

    @Autowired
    private EmpresaRepo empRepo;

    @Autowired
    private PracticasSolicitadasRepo solicitadasRepo;

    @Autowired
    private InformeAlumnoRepo inforRepo;

    /**
     * Método alumno()
     * 
     * @return Retorna la página de inicio de alumno
     */
    @RequestMapping("/alumno")
    public String alumno() {
        LOG.info("Página de inicio del alumno");
        return "alumno";
    }

    /**
     * Método seleccionarPracticas(Mode modelo, @ModelAttribute ("seleccion") PracticasSolicitadas ps)
     * 
     * @param modelo Parámetro para pasar valores al html
     * @param ps Parámetro para coger valores del html
     * @return Retorna la página de seleccionar prácticas. Tabla con las empresas que puede seleccionar el alumno.
     */
    @RequestMapping(value = "/alumno/seleccionarPracticas", method = RequestMethod.GET)
    public String seleccionarPracticas(Model modelo, @ModelAttribute("seleccion") PracticasSolicitadas ps) {
        List<Empresa> listaEmpresas = empRepo.findAll();
        int preferencia = ps.getPreferencia();
        modelo.addAttribute("listaEmpresas", listaEmpresas);
        modelo.addAttribute("preferencia", preferencia);
        LOG.info("El alumno con id: " + ControllerID.IDALUMNO + " ha entrado en la pantalla para soliictar prácticas. La lista de empresas que puede elegir es: " + listaEmpresas);
        return "seleccionarPracticas";
    }

    /**
     * Método guardarSeleccion(@PathVariable(name = "id") Integer id, @ModelAttribute("seleccion") PracticasSolicitadas pract_solicitadas, Model model)
     * 
     * @param id Parámetro con la id correspondiente a la empresa seleccionada
     * @param pract_solicitadas Parámetro para coger valores del html
     * @param model Parámetro para pasar valores al html
     * @return Retorna un String correspondiente con la url a la que accede si se guarda la práctica solicitada o si por el contrario, se ha superado el número y no puede guardar más.
     */
    @RequestMapping(value = "/alumno/seleccionarPracticas/guardarSeleccion/{id}", method = RequestMethod.POST)
    public String guardarSeleccion(@PathVariable(name = "id") Integer id, @ModelAttribute("seleccion") PracticasSolicitadas pract_solicitadas, Model model) {
        String url = " ";
        if (alumRepo.findContPracticas(ControllerID.IDALUMNO) < 10) {
            String horario = empRepo.findEmpresa(id).getTurnos();
            int tiempo = empRepo.findEmpresa(id).getSemanas();

            PracticasSolicitadas ps = new PracticasSolicitadas();
            if (solicitadasRepo.findAll().isEmpty()) {
                ps.setId(1);
            } else {
                ps.setId(solicitadasRepo.findAll().get(solicitadasRepo.findAll().size() - 1).getId() + 1);
            }
            ps.setHorario(horario);
            ps.setTiempo_practicas(tiempo);
            ps.setNota_practica(0);
            ps.setInforme(" ");
            ps.setAlumno_id(ControllerID.IDALUMNO);
            ps.setEmpresa_id(id);
            ps.setResponsable_id(1);
            ps.setPreferencia(pract_solicitadas.getPreferencia());

            solicitadasRepo.save(ps);
            LOG.info("El alumno con id: " + ControllerID.IDALUMNO + " ha hecho una solicitud de la práctica: " + ps.toString());
            url = "redirect:/alumno/seleccionarPracticas";
        } else {
            LOG.error("Error al seleccionar las prácticas. Ha llegado a su límite.");
            url = "redirect:/alumno/seleccionarPracticas/error";
        }
        return url;
    }

    /**
     * Método error_seleccion()
     * 
     * @return Retorna la página de practicasError, al llegar al límite de 10 prácticas solicitadas
     */
    @RequestMapping(value = "/alumno/seleccionarPracticas/error")
    public String error_seleccion() {
        return "practicasError";
    }

    /**
     * Método informeAlumno(Model modelo, @ModelAttribute("informe_alumno") InformeAlumno informe)
     * @param modelo Parámetro para pasar valores al html
     * @param informe Parámetro para coger valores del html
     * @return Retorna la págian informeAlumno en la que aparecen sus datos principales, y en caso de que esté asignado en alguna práctica, aparece también el tutor y la empresa asociada
     */
    @RequestMapping(value = "/alumno/informeAlumno", method = RequestMethod.GET)
    public String informeAlumno(Model modelo, @ModelAttribute("informe_alumno") InformeAlumno informe) {
        int id = ControllerID.IDALUMNO;
        Alumno a = alumRepo.findAlumno(id);

        String nom_empresa = alumRepo.findEmpresa(id);
        String nombre_tutor = alumRepo.findNombreTutor(id);
        String ap_tutor = alumRepo.findApellidoTutor(id);
        String fecha_ini = alumRepo.findFechaInicio(id);
        String fecha_fin = alumRepo.findFechaFinal(id);

        modelo.addAttribute("alumno", a);
        modelo.addAttribute("nombre_empresa", nom_empresa);
        modelo.addAttribute("nombre_tutor", nombre_tutor);
        modelo.addAttribute("apellido_tutor", ap_tutor);
        modelo.addAttribute("fecha_inicio", fecha_ini);
        modelo.addAttribute("fecha_final", fecha_fin);

        LOG.info("El alumno con id: " + ControllerID.IDALUMNO + " mira su informe.");

        return "informeAlumno";
    }

    /**
     * Método guardarInfome(@ModelAttribute("informe_alumno") InformeAlumno informe_alum, Model modelo)
     * @param informe_alum Parámetro para coger valores del html
     * @param modelo Parámetro para pasar valores al html
     * @return Vuelve a la página informeAlumno cuando se pulsa el botón gurdar. Este crea un nuevo informe (o modifica si ya existe uno) con las fechas que se introducen por teclado
     */
    @RequestMapping(value = "/alumno/informeAlumno/guardar", method = RequestMethod.POST)
    public String guardarInforme(@ModelAttribute("informe_alumno") InformeAlumno informe_alum, Model modelo) {
        InformeAlumno informe = new InformeAlumno();
        informe.setId(ControllerID.IDALUMNO);
        informe.setFecha_inicio(informe_alum.getFecha_inicio());
        informe.setFecha_final(informe_alum.getFecha_final());
        informe.setAlumno_id(ControllerID.IDALUMNO);

        inforRepo.save(informe);
        LOG.info("El alumno con id: " + ControllerID.IDALUMNO + "guarda el informe con las fechas. El informe es: " + informe.toString());
        return "redirect:/alumno/informeAlumno";
    }

}
