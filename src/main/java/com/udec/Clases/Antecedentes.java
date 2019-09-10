package com.udec.Clases;

import java.io.Serializable;
import java.util.Date;

/**
 * Clase Antecedentes .
 * @since EmpresaFinanciera 1.0
 * @version 1.0
 * @author Juan Ricardo Rodriguez Campos
 */
public class Antecedentes implements Serializable{
    
    /**
     * Atributos de la clase
     */
    private static final long serialVersionUID = -2873344211410398459L;
    private Date fechaAntecedente;
    private String descripcion;
    private TipoAntecedente tipo;

    /**
     * Constructor de la clase Antecedentes.
     * @param fechaAntecedente
     * @param descripcion
     * @param tipo 
     */
    public Antecedentes(Date fechaAntecedente, String descripcion, TipoAntecedente tipo) {
        this.fechaAntecedente = fechaAntecedente;
        this.descripcion = descripcion;
        this.tipo = tipo;
    }

    /**
     * Metodos Get y Set.  
     */
    
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
