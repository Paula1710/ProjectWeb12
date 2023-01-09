/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.service;

import com.project.model.Empresa;
import com.project.model.Practica;
import com.project.model.Tutor;
import com.project.repository.EmpresaRepo;
import com.project.repository.TutorRepo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Paula
 */
@Service
public class TutorService {
    
    private EmpresaRepo empresaRepository;
    private TutorRepo tutorRepository;
     
    
    @Autowired
    public TutorService(EmpresaRepo empresaRepository, TutorRepo tutorRepository) {
        this.empresaRepository = empresaRepository;
        this.tutorRepository = tutorRepository;
    }
    
    public List<Empresa> listarEmpresa(){
        return empresaRepository.findAll();
    }

    public void crearEmpresa(Empresa empresa){
         empresaRepository.save(empresa);
    }
    
    public void borrarEmpresa(int id){
        empresaRepository.deleteById(id);
    } 
    
    public Optional<Empresa> getEmpresa(int id){
        return empresaRepository.findById(id);
    }
    
    public List<Practica> listarPracticasTutor (int id){
        return tutorRepository.findAllPracticas(id);
    }
}
