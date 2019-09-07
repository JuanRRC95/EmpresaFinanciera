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
public class Fichero implements Serializable{
 
    private List<Persona> lista;

    public Fichero(List<Persona> lista) {
        this.lista = lista;
    }

    public List<Persona> getLista() {
        return lista;
    }

    public void setLista(List<Persona> lista) {
        this.lista = lista;
    }
    
    
    
}
