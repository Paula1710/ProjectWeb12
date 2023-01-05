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
 *
 * @author Paula
 */
@Entity
@Table(name="telefono")
public class Telefono {
    
    @Id
    @Column(name="telefono")
    private String telefono;

    public Telefono() {
    }

    public Telefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Telefono telefono = (Telefono) o;
        return telefono.equals(telefono.telefono);
    }

    @Override
    public int hashCode() {
        return Objects.hash(telefono);
    }

    @Override
    public String toString() {
        return "Telefono{" +
                "Telefono='" + telefono + '\'' +
                '}';
    }
}
