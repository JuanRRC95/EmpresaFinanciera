/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.Logica;

import com.udec.Clases.Antecedentes;
import com.udec.Clases.Fichero;
import com.udec.Clases.Genero;
import com.udec.Clases.Persona;
import com.udec.Clases.TipoAntecedente;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.io.Serializable;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 *
 * @author JuanPC
 */
public class Logica {
    
    private Scanner consola = new Scanner(System.in);
    private List<Persona>lista = new ArrayList<>();
    
    public Logica(){
        crearUsuario();
        //añadirantecedente();
        /*
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
                */
        leerFichero();
    }
    
    public void menu(){
        
    }
    
    public void crearUsuario(){
        Persona usuario = null;
        List<Antecedentes> lista2 = new ArrayList<>();
        System.out.println("Ingrese el nombre del usuario : ");
        String nombre = consola.next();
        System.out.println("Ingrese la cedula del usuario :");
        String cedula = consola.next();
        System.out.println("Ingrese la edad del usuario :");
        byte edad = consola.nextByte();
        System.out.println("Ingrese el genero del usuario(M/F)");
        String genero = consola.next();
        if(genero.equals("M")||genero.equals("m")){
                usuario = new Persona(nombre, edad,cedula, Genero.Masculino,lista2);
            }else if(genero.equals("F")||genero.equals("f")){           
                usuario = new Persona(nombre, edad,cedula, Genero.Femenino,lista2);
            }
        if(leerFichero().size()<=0){
            crearFicheroInicial(usuario);
        }else if(leerFichero().size()>0){
            crearFicheroConDatos(leerFichero(), usuario);
        }
        
    }
    
    public String crearJson(Persona persona){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonEjemplo = gson.toJson(persona);
        return jsonEjemplo;
    }
    
   
    
    public void crearFicheroInicial(Persona persona){ 
        FileOutputStream fos = null;
        ObjectOutputStream salida = null;
        try {
            fos = new FileOutputStream("C:\\Users\\JuanPC\\Documents\\NetBeansProjects\\EmpresaFinanciera\\src\\main\\java\\com\\udec\\Ficheros\\usuarios.ddr");
            salida = new ObjectOutputStream(fos);
            salida.writeObject(crearJson(persona));
        }catch(Exception ex){
            
        }
    }
    
    public void crearFicheroConDatos(List<Persona>lista,Persona persona){               
        FileOutputStream fos = null;
        ObjectOutputStream salida = null;
        try {
            fos = new FileOutputStream("C:\\Users\\JuanPC\\Documents\\NetBeansProjects\\EmpresaFinanciera\\src\\main\\java\\com\\udec\\Ficheros\\usuarios.ddr");
            salida = new ObjectOutputStream(fos);
            for (Persona elemento : lista) {
                Persona usuario = new Persona(elemento.getNombre(),elemento.getEdad(),elemento.getCedula(),elemento.getGenero(),elemento.getLista());
                salida.writeObject(crearJson(usuario));
            }
            salida.writeObject(crearJson(persona));
        }catch(Exception ex){
            
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
       
    public List<Persona> leerFichero(){
        List<Persona> lista = new ArrayList<>();
        try(ObjectInputStream ois=new ObjectInputStream(new FileInputStream("C:\\Users\\JuanPC\\Documents\\NetBeansProjects\\EmpresaFinanciera\\src\\main\\java\\com\\udec\\Ficheros\\usuarios.ddr"))){
            while(true){            
                String aux =(String)ois.readObject();
                //System.out.println(aux);
                Gson gson = new Gson();                
                Persona ejemplo = gson.fromJson(aux, Persona.class);
                lista.add(ejemplo);
            }
        }catch(ClassNotFoundException e){
        }catch(EOFException e){
        }catch(IOException e){
        }
        return lista;
    }
    
    
    public List<Persona> TraerFichero(){
        try(ObjectInputStream ois=new ObjectInputStream(new FileInputStream("C:\\Users\\JuanPC\\Documents\\NetBeansProjects\\EmpresaFinanciera\\src\\main\\java\\com\\udec\\Ficheros\\usuarios.ddr"))){
            //Cuando no haya mas objetos saltara la excepcion EOFException
            List<Persona> lista = new ArrayList<>();
            
                //Fichero aux=(Fichero)ois.readObject();
                lista=(ArrayList)ois.readObject();
                
            
        }catch(ClassNotFoundException e){
        }catch(EOFException e){
        }catch(IOException e){
        }
        return lista;
    }
    
    
}
