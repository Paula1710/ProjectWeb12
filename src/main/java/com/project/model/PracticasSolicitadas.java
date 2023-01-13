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
 * Clase Prácticas solicitadad
 * 
 * @author Grupo12
 */

@Entity
@Table(name="practicas_solicitadas")
public class PracticasSolicitadas {
    @Id
    @Column(name="id")
    private int id;
    @Column(name="horario")
    private String horario;
    @Column(name="tiempo_practicas")
    private int tiempo_practicas;
    @Column(name="nota_practica")
    private double nota_practica;
    @Column(name="informe")
    private String informe;
    @Column(name="responsable_id")
    private int responsable_id;
    @Column(name="empresa_id")
    private int empresa_id;
    @Column(name="alumno_id")
    private int alumno_id;
    @Column(name="preferencia")
    private int preferencia;

    /**
     * Constructor vacío de la práctica solicitada
     */
    public PracticasSolicitadas() {
    }
                 
    /**
     * Constructor de la práctica solicitada
     * 
     * @param id
     * @param horario
     * @param tiempo_practicas
     * @param nota_practica
     * @param informe
     * @param responsable_id
     * @param empresa_id
     * @param alumno_id
     * @param preferencia 
     */
    public PracticasSolicitadas(int id, String horario, int tiempo_practicas, double nota_practica, String informe, int responsable_id, int empresa_id, int alumno_id, int preferencia) {
        this.id = id;
        this.horario = horario;
        this.tiempo_practicas = tiempo_practicas;
        this.nota_practica = nota_practica;
        this.informe = informe;
        this.responsable_id = responsable_id;
        this.empresa_id = empresa_id;
        this.alumno_id = alumno_id;
        this.preferencia = preferencia;
    }

    
    /**
     * Método getId()
     *
     * @return Retorna un Integer con el id de la práctica solicitada
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
     * Método getHorario()
     *
     * @return Retorna un String con el horario de la práctica solicitada
     */
    public String getHorario() {
        return horario;
    }

    /**
     * Método setHorario(String horario)
     *
     * @param horario
     */
    public void setHorario(String horario) {
        this.horario = horario;
    }

    /**
     * Método getTiempo_practicas()
     *
     * @return Retorna un Integer con el tiempo de la práctica solicitada (contado en
     * semanas)
     */
    public int getTiempo_practicas() {
        return tiempo_practicas;
    }

    /**
     * Método setTiempo_practicas(int tiempo_practicas)
     *
     * @param tiempo_practicas
     */
    public void setTiempo_practicas(int tiempo_practicas) {
        this.tiempo_practicas = tiempo_practicas;
    }

    /**
     * Método getNota_practica()
     *
     * @return Retorna un Integer con el id de la práctica solicitada
     */
    public double getNota_practica() {
        return nota_practica;
    }

    /**
     * Método setNota_practica(double nota_practica)
     *
     * @param nota_practica
     */
    public void setNota_practica(double nota_practica) {
        this.nota_practica = nota_practica;
    }

    /**
     * Método getInforme()
     *
     * @return Retorna un String con los comentarios del informe de la práctica solicitada
     */
    public String getInforme() {
        return informe;
    }

    /**
     * Método setInfome(String informe)
     *
     * @param informe
     */
    public void setInforme(String informe) {
        this.informe = informe;
    }

    /**
     * Método getResponsable_id()
     *
     * @return Retorna un Integer con el id del responsable asociado a la
     * práctica solicitada
     */
    public int getResponsable_id() {
        return responsable_id;
    }

    /**
     * Método setResponsable_id(int responsable_id)
     *
     * @param responsable_id
     */
    public void setResponsable_id(int responsable_id) {
        this.responsable_id = responsable_id;
    }

    /**
     * Método getEmpresa_id()
     *
     * @return Retorna un Integer con el id de la empresa donde se realiza la
     * práctica solicitada
     */
    public int getEmpresa_id() {
        return empresa_id;
    }

    /**
     * Método setEmpresa_id(int empresa_id)
     *
     * @param empresa_id
     */
    public void setEmpresa_id(int empresa_id) {
        this.empresa_id = empresa_id;
    }

    /**
     * Método getAlumno_id()
     *
     * @return Retorna un Integer con el id el alumno que realiza la práctica solicitada
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
     * Método getPreferencia()
     *
     * @return Retorna un Integer con la preferncia de la práctica solicitada
     */
    public int getPreferencia() {
        return preferencia;
    }

    /**
     * Método setPreferencia(int preferencia)
     *
     * @param preferencia
     */
    public void setPreferencia(int preferencia) {
        this.preferencia = preferencia;
    }

    /**
     * Método hashCode() de la práctica
     *
     * @return Retorna una comparación de objetos
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, horario, tiempo_practicas, nota_practica, informe, responsable_id, empresa_id, alumno_id, preferencia);
    }

    /**
     * Método equals(Object o) de la práctica
     *
     * @param o Objecto que se va a igualar
     * @return Booleano que indica si los objetos son iguales
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PracticasSolicitadas practicasS = (PracticasSolicitadas) o;
        return id == practicasS.id && horario.equals(practicasS.horario) && tiempo_practicas==practicasS.tiempo_practicas && nota_practica ==practicasS.nota_practica && informe.equals(practicasS.informe) && responsable_id == practicasS.responsable_id && empresa_id == practicasS.empresa_id && alumno_id==practicasS.alumno_id && preferencia ==practicasS.preferencia;
    }

    /**
     * Método toString() de la práctica
     *
     * @return Saca el valor de los atributos de la clase
     */
    @Override
    public String toString() {
        return "Práctica solicitada{"
                + "Id=" + id
                + ", horario='" + horario + '\''
                + ", tiempo_practicas='" + tiempo_practicas + '\''
                + ", nota_practica='" + nota_practica + '\''
                + ", informe='" + informe + '\''
                + ", responsable_id='" + responsable_id + '\''
                + ", empresa_id='" + empresa_id + '\''
                + ", alumno_id='" + alumno_id + '\''
                + ", preferencia='" + preferencia + '\''
                + '}';
    }
}
 