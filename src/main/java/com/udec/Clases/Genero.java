/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.Clases;
/**
 * Clase de tipo enum que contiene los generos.
 * @since EmpresaFinanciera 1.0
 * @version 1.0
 * @author Juan Ricardo Rodriguez Campos
 */
public enum Genero {
    Masculino(1),
    Femenino(2);
    
    private int tipo;
    
    Genero(int genero){
        this.tipo=genero;
    }

    public int getTipo() {
        return tipo;
    }
    
    
}
