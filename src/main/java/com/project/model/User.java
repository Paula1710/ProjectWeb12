/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.model;


import java.util.Objects;

/**
 * Clase Usuario
 *
 * @author Grupo12
 */
public class User {

    private String correo;
    private String password;

    /**
     * Constructor vacío del usuario
     */
    public User() {
    }

    /**
     * Contructor del usuario
     * 
     * @param correo
     * @param password 
     */
    public User(String correo, String password) {
        this.correo = correo;
        this.password = password;
    }

    /**
     * Método getCorreo()
     *
     * @return Retorna un String con el correo electrónico del usuario
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
     * @return Retorna un String con la contraseña del usuario
     */
    public String getPassword() {
        return password;
    }

    /**
     * Método setContrasenna(String password)
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Método equals(Object o) del Usuario
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
        User user = (User) o;
        return correo.equals(user.correo) && password.equals(user.password);
    }

    /**
     * Método hashCode() del Usuario
     *
     * @return Retorna una comparación de objetos
     */
    @Override
    public int hashCode() {
        return Objects.hash(correo, password);
    }

    /**
     * Método toString() del Usuario
     *
     * @return Saca el valor de los atributos de la clase
     */
    @Override
    public String toString() {
        return "User{" + "correo=" + correo + ", password=" + password + '}';
    }

}