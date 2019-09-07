/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.Logica;

import com.udec.Clases.Antecedentes;
import com.udec.Clases.Genero;
import com.udec.Clases.Persona;
import com.udec.Clases.TipoAntecedente;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author JuanPC
 */
public class Logica {
    
    private Scanner consola = new Scanner(System.in);
    private List<Persona>lista = new ArrayList<>();
    
    public Logica(){
        crearUsuario();
        añadirantecedente();
        for (Persona p : lista) {
            System.out.println("Nombre :"+p.getNombre());
            System.out.println("Edad :"+p.getEdad());
            System.out.println("Cedula :"+p.getCedula());
            System.out.println("Genero :"+p.getGenero());
            for (Antecedentes lista1 : p.getLista()) {
                System.out.println("Antecedente : "+lista1.getDescripcion());
                System.out.println("Antecedente : "+lista1.getFechaAntecedente());
            }
        }
    }
    
    public void menu(){
        
    }
    
    public void crearUsuario(){          
        System.out.println("Ingrese el nombre del usuario : ");
        String nombre = consola.next();
        System.out.println("Ingrese la cedula del usuario :");
        String cedula = consola.next();
        System.out.println("Ingrese la edad del usuario :");
        byte edad = consola.nextByte();
        System.out.println("Ingrese el genero del usuario(M/F)");
        String genero = consola.next();
        if(genero.equals("M")||genero.equals("m")){
            Persona persona = new Persona(nombre, edad,cedula, Genero.Masculino);
            lista.add(persona);
        }else if(genero.equals("F")||genero.equals("f")){           
            Persona persona = new Persona(nombre, edad,cedula, Genero.Femenino);
            lista.add(persona);
        }      
    }
    
    public void añadirantecedente(){
        for (Persona lista1 : lista) {
            if(lista1.getCedula().equals("1074188634")){
               Date fecha = new Date();
               TipoAntecedente t = new TipoAntecedente("hola","Mundo");
               Antecedentes an = new Antecedentes(fecha,"jumm",t);
               lista1.agregarAntecedente(an);
            }
        }
    }
    
    
}
