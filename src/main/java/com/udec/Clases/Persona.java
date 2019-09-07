/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.Clases;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author JuanPC
 */
public class Persona implements Serializable {
    
    private static final long serialVersionUID = -2873344211410398459L;
    private String nombre;
    private byte edad;
    private String cedula;
    private Genero genero;
    private List<Antecedentes> lista;

    public Persona(String nombre, byte edad, String cedula, Genero genero, List<Antecedentes> lista) {
        this.nombre = nombre;
        this.edad = edad;
        this.cedula = cedula;
        this.genero = genero;
        this.lista = lista;
    }
    
    public List<Antecedentes> getLista() {
        return lista;
    }

    public void setLista(List<Antecedentes> lista) {
        this.lista = lista;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public byte getEdad() {
        return edad;
    }

    public void setEdad(byte edad) {
        this.edad = edad;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public void agregarAntecedente(Antecedentes antecedente){
        lista.add(antecedente);       
    }
    
    public List<Antecedentes> traerAntecedentes(){
        return getLista();
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", edad=" + edad + ", cedula=" + cedula + ", genero=" + genero + ", lista=" + lista + '}';
    }
    
    
    
}
