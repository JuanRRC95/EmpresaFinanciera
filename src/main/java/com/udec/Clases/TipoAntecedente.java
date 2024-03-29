package com.udec.Clases;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Clase TipoAntecedente
 * @since EmpresaFinanciera 1.0
 * @version 1.0
 * @author Juan Ricardo Rodriguez Campos
 */

public class TipoAntecedente implements Serializable{
    
    /**
     * Atributos de la clase
     */
    private static final long serialVersionUID = -2873344211410398459L;
    private String nombreCaracteristico;
    private String descripcion;
    private Map<String, String> map = new HashMap<String, String>();
    
    /**
     * Constructor de la clase TipoAntecedente.
     * @param nombreCaracteristico
     * @param descripcion 
     */
    public TipoAntecedente(String nombreCaracteristico, String descripcion) {
        this.nombreCaracteristico = nombreCaracteristico;
        this.descripcion = descripcion;
    }

    /**
     * Metodos Get y Set 
     */
    
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

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

        
    public Map listaTiposAntecedentesPositivos(){      
        map.put("A1","PAGOS");
        map.put("A2","INGRESOS");
        map.put("A3","REFERENCIAS");
        map.put("N1","PAGOS");
        map.put("N2","INGRESOS");
        map.put("N3","REFERENCIAS");
        setMap(map);
        return map;
    }
    
}
