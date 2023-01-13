/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.project.repository;

import com.project.model.Empresa;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Interfaz EmpresaRepo
 *
 * @author Grupo12
 */
public interface EmpresaRepo extends JpaRepository<Empresa, Integer> {

    /**
     * Método findEmpresa(int id)
     *
     * @param id Id de la empresa
     * @return Retorna una empresa dada su id
     */
    @Query(nativeQuery = true, value = "SELECT empresa.* FROM empresa WHERE empresa.id= (:id);")
    Empresa findEmpresa(int id);

    /**
     * Método getEmpresaTutor(int id)
     *
     * @param id Id del tutor
     * @return Retorna una lista de empresas dado el id del tutor
     */
    @Query(nativeQuery = true, value = "SELECT empresa.* FROM empresa INNER JOIN tutor ON tutor.id = empresa.tutor_id WHERE tutor.id = (:id);")
    List<Empresa> getEmpresaTutor(int id);

    /**
     * Método getEmpresaIdAlumno(int id)
     *
     * @param id Id del alumno
     * @return Retorna una empresa dado el id del alumno
     */
    @Query(nativeQuery = true, value = "SELECT empresa.* FROM empresa INNER JOIN practicas ON empresa.id = practicas.empresa_id INNER JOIN alumno ON  practicas.alumno_id = alumno.id WHERE alumno.id = (:id)")
    Empresa getEmpresaIdAlumno(int id);

}
