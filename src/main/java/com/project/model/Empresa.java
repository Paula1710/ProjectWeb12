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
 * Clase Empresa
 *
 * @author Grupo12
 */
@Entity
@Table(name = "empresa")
public class Empresa {

    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "capacidad")
    private int capacidad;
    @Column(name = "tutor_id")
    private int tutor_id;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "turnos")
    private String turnos;
    @Column(name = "semanas")
    private int semanas;

    /**
     * Constructor vacío de la empresa
     */
    public Empresa() {
    }

    /**
     * Constructor de la empresa
     *
     * @param id
     * @param nombre
     * @param direccion
     * @param capacidad
     * @param tutor_id
     * @param telefono
     * @param turnos
     * @param semanas
     */
    public Empresa(int id, String nombre, String direccion, int capacidad, int tutor_id, String telefono, String turnos, int semanas) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.capacidad = capacidad;
        this.tutor_id = tutor_id;
        this.telefono = telefono;
        this.turnos = turnos;
        this.semanas = semanas;
    }

    /**
     * Método getId()
     *
     * @return Retorna un Integer con el id de la empresa
     */
    public int getId() {
        return id;
    }

    /**
     * Método setID(int id)
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Método getNombre()
     *
     * @return Retorna un String con el nombre de la empresa
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método setNombre(String nombre)
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método getDireccion()
     *
     * @return Retorna un String con la direccion de la empresa
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Método setDireccion(String direccion)
     *
     * @param direccion
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Método getCapacidad()
     *
     * @return Retorna un Integer con la capacidad de la empresa
     */
    public int getCapacidad() {
        return capacidad;
    }

    /**
     * Método setCapacidad(int capacidad)
     *
     * @param capacidad
     */
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    /**
     * Método getTutor_id()
     *
     * @return Retorna un Integer con el id del tutor asociado a la empresa
     */
    public int getTutor_id() {
        return tutor_id;
    }

    /**
     * Método setTutor_id(int tutor_id)
     *
     * @param tutor_id
     */
    public void setTutor_id(int tutor_id) {
        this.tutor_id = tutor_id;
    }

    /**
     * Método getTelefono()
     *
     * @return Retorna un String con el teléfono de la empresa
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Método setTelefono(String telefono)
     *
     * @param telefono
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Método getTurnos()
     *
     * @return Retorna un String con los turnos disponibles de la empresa
     */
    public String getTurnos() {
        return turnos;
    }

    /**
     * Método setTurnos(String turnos)
     *
     * @param turnos
     */
    public void setTurnos(String turnos) {
        this.turnos = turnos;
    }

    /**
     * Método getSemanas()
     *
     * @return Retorna un Integer con el número de semanas que la empresa
     * incorpora a los alumnos
     */
    public int getSemanas() {
        return semanas;
    }

    /**
     * Método setSemanas(int semanas)
     *
     * @param semanas
     */
    public void setSemanas(int semanas) {
        this.semanas = semanas;
    }

        /**
     * Método hashCode() de la empresa
     * 
     * @return Retorna una comparación de objetos
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, direccion, capacidad, tutor_id, telefono, turnos, semanas);
    }

    /**
     * Método equals(Object o) de la empresa
     * 
     * @param o Objecto que se va a igualar
     * @return  Booleano que indica si los objetos son iguales
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empresa empresa = (Empresa) o;
        return id == empresa.id && nombre.equals(empresa.nombre) && direccion.equals(empresa.direccion) && capacidad == empresa.capacidad && tutor_id == empresa.tutor_id && telefono.equals(empresa.telefono) && turnos.equals(empresa.turnos) && semanas == empresa.semanas;
    }
    
    /**
     * Método toString() de la empresa
     * 
     * @return Saca el valor de los atributos de la clase
     */
    @Override
    public String toString() {
        return "Empresa{"
                + "Id=" + id
                + ", nombre='" + nombre + '\''
                + ", direccion='" + direccion + '\''
                + ", capacidad='" + capacidad + '\''
                + ", tutor_id='" + tutor_id + '\''
                + ", telefono" + telefono + '\''
                + ", turnos='" + turnos + '\''
                + ", semanas='" + semanas + '\''
                + '}';
    }
}


