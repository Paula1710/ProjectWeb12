/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.controller;

import com.config.ControlLog;
import com.project.model.User;
import com.project.repository.AlumnoRepo;
import com.project.repository.ResponsableRepo;
import com.project.repository.TutorRepo;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Clase Login
 *
 * @author Grupo12
 */
@Controller
public class ControllerLogin {

    private static final Logger LOG = ControlLog.getLogger(ControllerLogin.class);

    @Autowired
    private AlumnoRepo alumRepo;

    @Autowired
    private TutorRepo tutorRepo;

    @Autowired
    private ResponsableRepo responsableRepo;

    /**
     * Método login(Model modelo)
     *
     * @param modelo Parámetro para pasar valores al html
     * @return Retorna la página de login
     */
    @RequestMapping("/")
    public String login(Model modelo) {
        User user = new User();
        modelo.addAttribute("user", user);
        LOG.info("Página de inicio de sesión");
        return "login";

    }

    /**
     * Método inicioSesion(@ModelAttribute("user") User user)
     *
     * @param user Parámetro para coger valores del html
     * @return Retorna un String con el contenido de la página html donde debe seguir según su rol(alumno,tutor,responsable)
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String inicioSesion(@ModelAttribute("user") User user) {
        List<String> listaAlumnos = alumRepo.listaCorreoAlumno();
        List<String> listaTutor = tutorRepo.listaCorreoTutor();
        List<String> listaResponsable = responsableRepo.listaCorreoResponsable();
        List<String> listaCorreo = new ArrayList<String>();
        listaCorreo.addAll(listaAlumnos);
        listaCorreo.addAll(listaTutor);
        listaCorreo.addAll(listaResponsable);

        String password = " ";
        String url = "";

        for (int i = 0; i < listaCorreo.size(); i++) {
            if (user.getCorreo().equals(listaCorreo.get(i))) {
                String[] partes = listaCorreo.get(i).split("@");
                if (partes[1].equals("edu.uah.es")) {
                    password = alumRepo.getPasswordAlumno(listaCorreo.get(i));
                    if (user.getPassword().equals(password)) {
                        ControllerID.IDALUMNO = alumRepo.getIdAlumno(listaCorreo.get(i));
                        LOG.info("Inicio sesión del alumno: " + ControllerID.IDALUMNO);
                        url = "redirect:alumno";
                    }
                } else if (partes[1].equals("uah.es")) {
                    password = tutorRepo.getPasswordTutor(listaCorreo.get(i));
                    if (user.getPassword().equals(password)) {
                        ControllerID.IDTUTOR = tutorRepo.getIdTutor(listaCorreo.get(i));
                        LOG.info("Inicio sesión del tutor: " + ControllerID.IDTUTOR);
                        url = "redirect:tutor";
                    }
                } else if (partes[1].equals("admin.es")) {
                    password = responsableRepo.getPasswordResponsable(listaCorreo.get(i));
                    if (user.getPassword().equals(password)) {
                        ControllerID.IDRESPONSABLE = responsableRepo.getIdResponsable(listaCorreo.get(i));
                        LOG.info("Inicio sesión del responsable: " + ControllerID.IDRESPONSABLE);
                        url = "redirect:responsable";
                    }
                }

            }
        }
        if (url.isEmpty()) {
            url = "redirect:errorLogin";
            LOG.error("Error en el inicio de sesión");
        }
        return url;
    }

    /**
     * Método errorLogin()
     * @return Retorna la página errorLogin cuando las credenciales son incorrectas
     */
    @RequestMapping("/errorLogin")
    public String errorLogin() {
        return "errorLogin";
    }

}
