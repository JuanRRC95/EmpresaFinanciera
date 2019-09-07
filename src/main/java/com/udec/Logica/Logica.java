/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.Logica;

import com.udec.Clases.Genero;
import com.udec.Clases.Persona;
import java.util.ArrayList;
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
        for (Persona p : lista) {
            System.out.println("Nombre :"+p.getNombre());
            System.out.println("Edad :"+p.getEdad());
            System.out.println("Cedula :"+p.getCedula());
            System.out.println("Genero :"+p.getGenero());
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
        
    }
    
    
}
