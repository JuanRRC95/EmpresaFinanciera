/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.Clases;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JuanPC
 */
public class TipoAntecedente implements Serializable{
    
    private static final long serialVersionUID = -2873344211410398459L;
    private String nombreCaracteristico;
    private String descripcion;
    
    
    public TipoAntecedente(String nombreCaracteristico, String descripcion) {
        this.nombreCaracteristico = nombreCaracteristico;
        this.descripcion = descripcion;
    }

    public String getNombreCaracteristico() {
        return nombreCaracteristico;
    }

    public void setNombreCaracteristico(String nombreCaracteristico) {
        this.nombreCaracteristico = nombreCaracteristico;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public void listaTiposAntecedentesPositivos(){
        List<TipoAntecedente>lista = new ArrayList<>();
        lista = new ArrayList<>();
        TipoAntecedente tipo1 = new TipoAntecedente("A1","El usuario tiene un excelente historial de pago");
        TipoAntecedente tipo2 = new TipoAntecedente("A2","El usuario tiene ingresos fijos");
        TipoAntecedente tipo3 = new TipoAntecedente("A3","Tiene buenas refrencias de otras entidades");
        lista.add(tipo1);
        lista.add(tipo2);
        lista.add(tipo3);
    }
    
    public void listaTiposAntecedentesNegativos(){
        List<TipoAntecedente>lista = new ArrayList<>();
        lista = new ArrayList<>();
        TipoAntecedente tipo1 = new TipoAntecedente("N1","El usuario tiene un historial de retardos en los pagos");
        TipoAntecedente tipo2 = new TipoAntecedente("N2","El usuario no tiene ingresos estables");
        TipoAntecedente tipo3 = new TipoAntecedente("N3","El usuario tiene malas referencias de otras entidades o simplemente no las tiene");
        lista.add(tipo1);
        lista.add(tipo2);
        lista.add(tipo3);
        
    }
    
}
