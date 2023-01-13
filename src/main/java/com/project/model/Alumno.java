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
 * Clase Alumno
 *
 * @author Grupo12
 */
@Entity
@Table(name = "alumno")
public class Alumno {

    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellidos")
    private String apellidos;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "correo")
    private String correo;
    @Column(name = "fecha_nacimiento")
    private Date fecha_nacimiento;
    @Column(name = "nota_media")
    private double nota_media;
    @Column(name = "contrasenna")
    private String contrasenna;
    @Column(name = "telefono")
    private String telefono;

    /**
     * Constructor vacío del alumno
     */
    public Alumno() {
    }

    /**
     * Constructor del alumno
     *
     * @param id 
     * @param nombre 
     * @param apellidos 
     * @param direccion 
     * @param correo 
     * @param fecha_nacimiento 
     * @param nota_media 
     * @param contrasenna 
     * @param telefono 
     */
    public Alumno(int id, String nombre, String apellidos, String direccion, String correo, Date fecha_nacimiento, double nota_media, String contrasenna, String telefono) {
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

    /**
     * Método getID()
     *
     * @return Retorna un integer con el id del alumno
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
     * Método getNombre()
     *
     * @return Retorna un String con el nombre del alumno
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método setNomnbre(String nombre)
     *
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método getApellidos()
     *
     * @return Retorna un String con los apellidos del alumno
     */
    public String getApellidos() {
        return apellidos;
    }

    
    /**
     * Método setApellidos(String apellidos)
     *
     * @param apellidos 
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * Método getDireccion()
     *
     * @return Retorna un String con la dirección del alumno
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
     * Método getCorreo()
     *
     * @return Retorna un String con el correo electrónico del alumno
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Método setCorreo(String correo)
     *
     * @param correo 
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Método getFecha_nacimiento()
     *
     * @return Retorna un Date con la fecha de nacimiento del alumno
     */
    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    /**
     * Método setFecha_nacimiento(Date fecha_nacimiento)
     *
     * @param fecha_nacimiento 
     */
    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    /**
     * Método getNota_media()
     *
     * @return Retorna un Double con la nota media del alumno
     */
    public double getNota_media() {
        return nota_media;
    }

    /**
     * Método setNota_media(double nota_media)
     *
     * @param nota_media 
     */
    public void setNota_media(double nota_media) {
        this.nota_media = nota_media;
    }

    /**
     * Método getContrasenna()
     *
     * @return Retorna un String con la contraseña del alumno
     */
    public String getContrasenna() {
        return contrasenna;
    }

    /**
     * Método setContrasenna(String contrasenna)
     *
     * @param contrasenna 
     */
    public void setContrasenna(String contrasenna) {
        this.contrasenna = contrasenna;
    }

    /**
     * Método getTelefono()
     *
     * @return Retorna un String con el teléfono del alumno
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
     * Método hashCode() del alumno
     * 
     * @return Retorna una comparación de objetos
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, apellidos, direccion, correo, fecha_nacimiento, nota_media, contrasenna, telefono);
    }

    /**
     * Método equals(Object o) del Alumno
     * 
     * @param o Objecto que se va a igualar
     * @return  Booleano que indica si los objetos son iguales
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Alumno alumno = (Alumno) o;
        return id == alumno.id && nombre.equals(alumno.nombre) && apellidos.equals(alumno.apellidos) && direccion.equals(alumno.direccion) && correo.equals(alumno.correo) && fecha_nacimiento.equals(alumno.fecha_nacimiento) && nota_media == alumno.nota_media && contrasenna.equals(alumno.contrasenna) && telefono.equals(alumno.telefono);
    }
    
    /**
     * Método toString() del Alumno
     * 
     * @return Saca el valor de los atributos de la clase
     */
    @Override
    public String toString() {
        return "Alumno{"
                + "Id=" + id
                + ", nombre='" + nombre + '\''
                + ", apellidos='" + apellidos + '\''
                + ", direccion='" + direccion + '\''
                + ", correo='" + correo + '\''
                + ", fecha de nacimiento='" + fecha_nacimiento + '\''
                + ", nota media='" + nota_media + '\''
                + ", contraseña='" + contrasenna + '\''
                + ", telefono='" + telefono + '\''
                + '}';
    }
}
