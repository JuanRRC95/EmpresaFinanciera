/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.Clases;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author JuanPC
 */
public class Antecedentes implements Serializable{
    
    private static final long serialVersionUID = -2873344211410398459L;
    private Date fechaAntecedente;
    private String descripcion;
    private TipoAntecedente tipo;

    public Antecedentes(Date fechaAntecedente, String descripcion, TipoAntecedente tipo) {
        this.fechaAntecedente = fechaAntecedente;
        this.descripcion = descripcion;
        this.tipo = tipo;
    }

    public Date getFechaAntecedente() {
        return fechaAntecedente;
    }

    public void setFechaAntecedente(Date fechaAntecedente) {
        this.fechaAntecedente = fechaAntecedente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TipoAntecedente getTipo() {
        return tipo;
    }

    public void setTipo(TipoAntecedente tipo) {
        this.tipo = tipo;
    }

    
}
