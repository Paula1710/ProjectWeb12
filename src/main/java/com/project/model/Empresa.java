/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 *
 * @author Alberto Galindo
 */

@Entity
@Table(name="empresa")
public class Empresa {
    
    @Id
    @Column(name="id")
    private int id;
    @Column(name="nombre")
    private String nombre;
    @Column(name="direccion")
    private String direccion;
    @Column(name="capacidad")
    private int capacidad;
    @Column(name="tutor_id")
    private int tutor_id;
    @Column(name="telefono")
    private int telefono;

    public Empresa(int id, String nombre, String direccion, int capacidad, int tutor_id, int telefono) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.capacidad = capacidad;
        this.tutor_id = tutor_id;
        this.telefono = telefono;
    }

    public Empresa(String nombre, String direccion, int capacidad, int tutor_id, int telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.capacidad = capacidad;
        this.tutor_id = tutor_id;
        this.telefono = telefono;
    }

    public Empresa() {
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getTutor_id() {
        return tutor_id;
    }

    public void setTutor_id(int tutor_id) {
        this.tutor_id = tutor_id;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    
    @Override
    public String toString() {
        return "Empresa{" +
                "Id=" + id +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", capacidad='" + capacidad + '\'' +
                ", id del tutor='" + tutor_id + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
    
}
