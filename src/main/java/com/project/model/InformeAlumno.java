/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Objects;

/**
 * Clase InformeAlumno
 *
 * @author Grupo12
 */
@Entity
@Table(name = "informe_alumno")
public class InformeAlumno {

    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "fecha_inicio")
    private String fecha_inicio;
    @Column(name = "fecha_final")
    private String fecha_final;
    @Column(name = "alumno_id")
    private int alumno_id;

    /**
     * Constructor vacío del informeAlumno
     */
    public InformeAlumno() {
    }

    /**
     * Constructor del informeAlumno
     *
     * @param id
     * @param fecha_inicio
     * @param fecha_final
     * @param alumno_id
     */
    public InformeAlumno(int id, String fecha_inicio, String fecha_final, int alumno_id) {
        this.id = id;
        this.fecha_inicio = fecha_inicio;
        this.fecha_final = fecha_final;
        this.alumno_id = alumno_id;
    }

    /**
     * Método getID()
     *
     * @return Retorna un integer con el id del informe
     */
    public int getId() {
        return id;
    }

    /**
     * Método setId(int id)
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Método getFecha_inicio()
     *
     * @return Retorna la fecha en la que inició las prácticas
     */
    public String getFecha_inicio() {
        return fecha_inicio;
    }

    /**
     * Método setFecha_inicio(String fecha_inicio)
     *
     * @param fecha_inicio
     */
    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    /**
     * Método getFechaFinal()
     *
     * @return Retorna la fecha en la que finaliza las prácticas el alumno
     */
    public String getFecha_final() {
        return fecha_final;
    }

    /**
     * Método setFecha_inicial(String fecha_final)
     *
     * @param fecha_final
     */
    public void setFecha_final(String fecha_final) {
        this.fecha_final = fecha_final;
    }

    /**
     * Método getAlumno_id()
     *
     * @return Retorna el id del alumno
     */
    public int getAlumno_id() {
        return alumno_id;
    }

    /**
     * Método setAlumno_id(int alumno_id)
     *
     * @param alumno_id
     */
    public void setAlumno_id(int alumno_id) {
        this.alumno_id = alumno_id;
    }

    /**
     * Método toString() de informeAlumno
     *
     * @return Saca el valor de los atributos de la clase
     */
    @Override
    public String toString() {
        return "InformeAlumno{" + "id=" + id + ", fecha_inicio=" + fecha_inicio + ", fecha_final=" + fecha_final + ", alumno_id=" + alumno_id + '}';
    }

    /**
     * Método equals(Object o) del informeAlumno
     * 
     * @param o Objecto que se va a igualar
     * @return  Booleano que indica si los objetos son iguales
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InformeAlumno informeAlumno = (InformeAlumno) o;
        return id == informeAlumno.id && fecha_inicio.equals(informeAlumno.fecha_inicio) && fecha_final.equals(informeAlumno.fecha_final) && alumno_id == informeAlumno.alumno_id;
    }

    /**
     * Método hashCode() del informeAlumno
     *
     * @return Retorna una comparación de objetos
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, fecha_inicio, fecha_final, alumno_id);
    }

}