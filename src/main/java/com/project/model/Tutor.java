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
 * Clase Tutor
 *
 * @author Grupo12
 */
@Entity
@Table(name = "tutor")
public class Tutor {

    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellidos")
    private String apellidos;
    @Column(name = "correo")
    private String correo;
    @Column(name = "contrasenna")
    private String contrasenna;

    /**
     * Constructor vacío del tutor
     */
    public Tutor() {
    }

    /**
     * Constructor del tutor
     *
     * @param id
     * @param nombre
     * @param apellidos
     * @param correo
     * @param contrasenna
     */
    public Tutor(int id, String nombre, String apellidos, String correo, String contrasenna) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.contrasenna = contrasenna;
    }

    /**
     * Método getID()
     *
     * @return Retorna un integer con el id del tutor
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
     * @return Retorna un String con el nombre del tutor
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
     * Método getApellidos()
     *
     * @return Retorna un String con los apellidos del tutor
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
     * Método getCorreo()
     *
     * @return Retorna un String con el correo electrónico del tutor
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
     * Método getContrasenna()
     *
     * @return Retorna un String con la contraseña del tutor
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
     * Método equals(Object o) del Tutor
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
        Tutor tutor = (Tutor) o;
        return id == tutor.id && nombre.equals(tutor.nombre) && apellidos.equals(tutor.apellidos) && correo.equals(tutor.correo) && contrasenna.equals(tutor.contrasenna);
    }

    /**
     * Método hashCode() del Tutor
     *
     * @return Retorna una comparación de objetos
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, apellidos, correo, contrasenna);
    }

    /**
     * Método toString() del Tutor
     *
     * @return Saca el valor de los atributos de la clase
     */
    @Override
    public String toString() {
        return "Tutor{"
                + "Id=" + id
                + ", nombre='" + nombre + '\''
                + ", apellidos='" + apellidos + '\''
                + ", correo='" + correo + '\''
                + ", contraseña='" + contrasenna + '\''
                + '}';
    }
}