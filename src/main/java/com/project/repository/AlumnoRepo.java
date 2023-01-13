/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.project.repository;

import com.project.model.Alumno;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Interfaz AlumnoRepo
 *
 * @author Grupo12
 */
public interface AlumnoRepo extends JpaRepository<Alumno, Integer> {

    /**
     * Método findAlumno(int id)
     *
     * @param id Id del alumno
     * @return Retorna el objeto alumno dada su id
     */
    @Query(nativeQuery = true, value = "SELECT alumno.* FROM alumno WHERE id=(:id);")
    Alumno findAlumno(int id);

    /**
     * Método findNombreTutor(int id)
     *
     * @param id Id del alumno
     * @return Retorna el nombre del tutor de prácticas dada la Id del alumno
     */
    @Query(nativeQuery = true, value = "SELECT tutor.nombre, tutor.id FROM alumno INNER JOIN practicas ON alumno.id = practicas.alumno_id \n"
            + "INNER JOIN empresa ON empresa.id = practicas.empresa_id \n"
            + "INNER JOIN tutor ON empresa.tutor_id = tutor.id\n"
            + "WHERE alumno.id=(:id);")
    String findNombreTutor(int id);

    /**
     * Método findApellidoTutor(int id)
     *
     * @param id Id del alumno
     * @return Retorna el apellido del tutor de prácticas dada la Id del alumno
     */
    @Query(nativeQuery = true, value = "SELECT tutor.apellidos FROM alumno INNER JOIN practicas ON alumno.id = practicas.alumno_id \n"
            + "INNER JOIN empresa ON empresa.id = practicas.empresa_id \n"
            + "INNER JOIN tutor ON empresa.tutor_id = tutor.id\n"
            + "WHERE alumno.id=(:id);")
    String findApellidoTutor(int id);

    /**
     * Método findEmpresa(int id)
     *
     * @param id Id del alumno
     * @return Retorna el nombre de la empresa dada la Id del alumno
     */
    @Query(nativeQuery = true, value = "SELECT empresa.nombre FROM alumno INNER JOIN practicas ON alumno.id = practicas.alumno_id \n"
            + "INNER JOIN empresa ON empresa.id = practicas.empresa_id \n"
            + "WHERE alumno.id=(:id)")
    String findEmpresa(int id);

    /**
     * Método findFechaInicio(int id)
     *
     * @param id Id del alumno
     * @return Retorna la fecha de inicio de prácticas dada la Id del alumno
     */
    @Query(nativeQuery = true, value = "SELECT informe_alumno.fecha_inicio FROM informe_alumno INNER JOIN alumno ON informe_alumno.alumno_id = alumno.id WHERE alumno.id = (:id)")
    String findFechaInicio(int id);

     /**
     * Método findFechaFinal(int id)
     *
     * @param id Id del alumno
     * @return Retorna la fecha de final de prácticas dada la Id del alumno
     */
    @Query(nativeQuery = true, value = "SELECT informe_alumno.fecha_final FROM informe_alumno INNER JOIN alumno ON informe_alumno.alumno_id = alumno.id WHERE alumno.id = (:id)")
    String findFechaFinal(int id);

    /**
     * Método findContPracticas(int id)
     *
     * @param id Id del alumno
     * @return Retorna el valor del contador de las prácticas solicitadas dada
     * la Id del alumno
     */
    @Query(nativeQuery = true, value = "SELECT COUNT(practicas_solicitadas.id) FROM alumno INNER JOIN practicas_solicitadas ON alumno.id = practicas_solicitadas.alumno_id WHERE alumno.id=(:id)")
    int findContPracticas(int id);

    /**
     * Método listaCorreoAlumno()
     *
     * @return Retorna una lista de correos de alumnos.
     */
    @Query(nativeQuery = true, value = "SELECT alumno.correo FROM alumno")
    List<String> listaCorreoAlumno();

    /**
     * Método getPasswordAlumno(String correo)
     *
     * @param correo Correo del alumno
     * @return Retorna la contraseña del alumno dado su correo
     */
    @Query(nativeQuery = true, value = "SELECT alumno.contrasenna FROM alumno WHERE alumno.correo=(:correo);")
    String getPasswordAlumno(String correo);

    /**
     * Método getIdAlumno(String correo)
     *
     * @param correo Correo del alumno
     * @return Retorna el Id del alumno dada la id del alumno
     */
    @Query(nativeQuery = true, value = "SELECT alumno.id FROM alumno WHERE alumno.correo = (:correo);")
    Integer getIdAlumno(String correo);

    /**
     * Método numeroAlumnos()
     *
     * @return Retorna el número de alumnos
     */
    @Query(nativeQuery = true, value = "SELECT COUNT(*) FROM alumno")
    int numeroAlumnos();

     /**
     * Método getAlumnoPracticas(int id)
     *
     * @param id Id del tutor
     * @return Retorna una lista de alumnos que estén en prácticas dada la Id
     * del tutor
     */
    @Query(nativeQuery = true, value = "SELECT alumno.* FROM alumno INNER JOIN practicas ON alumno.id= practicas.alumno_id INNER JOIN empresa ON practicas.empresa_id = empresa.id INNER JOIN tutor ON empresa.tutor_id = tutor.id WHERE tutor.id =(:id);")
    List<Alumno> getAlumnoPracticas(int id);

    /**
     * Método getAlumnoPracticasRepo(int id)
     *
     * @param id Id de las prácticas
     * @return Retorna el alumno dada la Id de la práctica
     */
    @Query(nativeQuery = true, value = "SELECT alumno.* FROM alumno INNER JOIN practicas ON alumno.id = practicas.alumno_id WHERE practicas.id = (:id)")
    Alumno getAlumnoPracticasRepo(int id);
}
