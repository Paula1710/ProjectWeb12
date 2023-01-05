/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Paula
 */

@Entity
@Table (name="alumno")
public class Alumno {
    
    @Id
    @Column(name="id")
    private int id;
    @Column(name="nombre")
    private String nombre;
    @Column(name="apellidos")
    private String apellidos;
    @Column(name="direccion")
    private String direccion;
    @Column(name="correo")
    private String correo;
    @Column(name="fecha_nacimiento")
    private Date fecha_nacimiento;
    @Column(name="nota_media")
    private double nota_media;
    @Column(name="contrasenna")
    private String contrasenna;
    @Column(name="telefono")
    private int telefono;

    public Alumno() {
    }

    public Alumno(int id, String nombre, String apellidos, String direccion, String correo, Date fecha_nacimiento, double nota_media, String contrasenna, int telefono) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.correo = correo;
        this.fecha_nacimiento = fecha_nacimiento;
        this.nota_media = nota_media;
        this.contrasenna = contrasenna;
        this.telefono = telefono;
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

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public double getNota_media() {
        return nota_media;
    }

    public void setNota_media(double nota_media) {
        this.nota_media = nota_media;
    }

    public String getContrasenna() {
        return contrasenna;
    }

    public void setContrasenna(String contrasenna) {
        this.contrasenna = contrasenna;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    
 

    @Override
    public int hashCode() {
        return Objects.hash(id,nombre, apellidos,direccion,correo,fecha_nacimiento,nota_media,contrasenna,telefono);
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "Id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", direccion='" + direccion + '\'' +
                ", correo='" + correo + '\'' +
                ", fecha de nacimiento='" + fecha_nacimiento + '\'' +
                ", nota media='" + nota_media + '\'' +
                ", contraseña='" + contrasenna + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}
