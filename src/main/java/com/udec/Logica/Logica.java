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
        System.out.println("ingrese la cedula");
        String cedula = consola.next();
        //crearFicheroConDatos(BusquedaEditarUsuario(cedula));
        //crearUsuario();
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
        System.out.println("-----Empresa Financiera-----");
        System.out.println("1. Registrar Usuario");
        System.out.println("2. Editar Usuario");
        System.out.println("3. Agregar Antecedentes");
        System.out.println("4. Ver Antecedentes");
        System.out.println("0. Finalizar");
        System.out.println("----------------------------");    
    }
    
    public void menuConsola(){
        byte bandera=0;
        while(bandera==0){
            byte opcion=consola.nextByte();
            switch(opcion){
                case 1: crearUsuario();
                    break;
                case 2: crearFicheroConDatos(BusquedaEditarUsuario());
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 0: bandera=1;
                    break;
            }
        }
    }
    
    public void menuAntecedentes(){
        System.out.println("-----Tipo de Antecedente-----");
        System.out.println("1. Positiva ");
        System.out.println("2. Negativa ");
        System.out.println("----------------------------");    
    }
    
    public void menuTipoAntecedentePositivos(){
        System.out.println("-----Categoria de Antecedente-----");
        System.out.println("1. A1 | PAGOS");
        System.out.println("2. A2 | INGRESOS");
        System.out.println("3. A3 | REFERENCIAS");
        System.out.println("----------------------------");    
    }
    
    public void menuTipoAntecedenteNegativos(){
        System.out.println("-----Categoria de Antecedente-----");
        System.out.println("1. N1 | PAGOS");
        System.out.println("2. N2 | INGRESOS");
        System.out.println("2. N3 | REFERENCIAS");
        System.out.println("----------------------------");    
    }
    
    public void editarUsuario(Persona usuario){
        System.out.println("----Datos de Usuario----");
        System.out.println("Nombre :"+usuario.getNombre());
        System.out.println("Edad   :"+usuario.getEdad());
        System.out.println("Genero :"+usuario.getGenero());
        System.out.println("------------------------");
    }
    
    public void consolaMenuEdicion(){
        System.out.println("Que dato desea modificar?...");
        System.out.println("1. Nombre");
        System.out.println("2. Edad");
        System.out.println("3. Genero");
        System.out.println("0. Salir y guardar");
    }
    
    
    public void crearUsuario(){
        Persona usuario = null;
        List<Antecedentes> lista2 = new ArrayList<>();
        System.out.println("Ingrese el nombre del usuario : ");
        String nombre = consola.next();
        System.out.println("Ingrese la cedula del usuario :");
        String cedula = consola.next();
        if(!validarUsuario(cedula)){
            System.out.println("Ingrese la edad del usuario :");
            byte edad = consola.nextByte();
            System.out.println("Ingrese el genero del usuario(M/F)");
            String genero = consola.next();            
            usuario = new Persona(nombre, edad,cedula,ingreseGenero(genero),lista2);              
            if(leerFichero().size()<=0){
                crearFicheroInicial(usuario);
            }else if(leerFichero().size()>0){
                crearFicheroConDatos(leerFichero(), usuario);
            }
        }else{
            System.out.println("Esta cedula ya se encuentra registrada.");
        }
    }
    
    public Genero ingreseGenero(String genero){
        if(genero.equals("M")||genero.equals("m")){
                   return Genero.Masculino; 
        }         
        return Genero.Femenino;  
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
    
    public void crearFicheroConDatos(List<Persona>lista){               
        FileOutputStream fos = null;
        ObjectOutputStream salida = null;
        try {
            fos = new FileOutputStream("C:\\Users\\JuanPC\\Documents\\NetBeansProjects\\EmpresaFinanciera\\src\\main\\java\\com\\udec\\Ficheros\\usuarios.ddr");
            salida = new ObjectOutputStream(fos);
            for (Persona elemento : lista) {
                Persona usuario = new Persona(elemento.getNombre(),elemento.getEdad(),elemento.getCedula(),elemento.getGenero(),elemento.getLista());
                salida.writeObject(crearJson(usuario));
            }
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
                System.out.println(aux);
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
    
    public boolean validarUsuario(String cedula){
        for (Persona usuario : leerFichero()) {
            if(usuario.getCedula().equals(cedula)){
                return true;
            }
        }
        return false;
    }
    
    public List<Persona> BusquedaEditarUsuario(){
        System.out.println("Ingrese la cedula del usuario a editar :");
        String cedula = consola.next();
        List<Persona>lista = new ArrayList<>();
        lista=leerFichero();
        for (Persona usuario : lista) {
            if(usuario.getCedula().equals(cedula)){
                editarUsuario(usuario);
                usuario=menuEdicion(usuario);
            }
        }
        return lista;
    }
    
    
    
    public Persona menuEdicion(Persona usuario){
        byte bandera=0;
        while(bandera==0){
            consolaMenuEdicion();
            byte opcion=consola.nextByte();
            switch(opcion){
                case 1:
                    System.out.println("Ingrese el nuevo nombre: ");
                    usuario.setNombre(consola.next());
                    break;
                case 2:
                    System.out.println("Ingrese la nueva edad :");
                    usuario.setEdad(consola.nextByte());
                    break;
                case 3:
                    System.out.println("Ingrese el nuevo genero :");
                    usuario.setGenero(ingreseGenero(consola.next()));
                    break;
                case 0:
                    bandera=1;
                    return usuario;                 
            }
        }
        return usuario;      
    }
    
}
