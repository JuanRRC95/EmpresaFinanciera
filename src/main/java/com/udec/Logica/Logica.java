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
        menuConsola();

    }
    
    public void menu(){
        System.out.println("-----Empresa Financiera-----");
        System.out.println("1. Registrar Usuario");
        System.out.println("2. Editar Usuario");
        System.out.println("3. Agregar Antecedentes");
        System.out.println("4. Eliminar Antecedentes");
        System.out.println("5. Ver Antecedentes");
        System.out.println("0. Finalizar");
        System.out.println("----------------------------");    
    }
    
    public void menuConsola(){
        byte bandera=0;
        String cedula="";
        while(bandera==0){
            menu();
            byte opcion=consola.nextByte();
            switch(opcion){
                case 1: crearUsuario();break;
                case 2:System.out.println("Ingrese la cedula del usuario a editar :");
                       cedula= consola.next();
                       crearFicheroConDatos(BusquedaEditarUsuario(cedula));break;
                case 3:System.out.println(" Ingrese la cedula del usuario : ");
                       cedula = consola.next();
                       consolaMenuTipoAntecedentePositivo(cedula);break;
                case 4:System.out.println("Ingrese la cedula del usuario a editar :");
                       crearFicheroConDatos(BusquedaAntecedentesUsuario(consola.next()));
                    break;
                case 5:System.out.println("Ingrese la cedula del usuario a editar :");
                       visualizarAntecedentes(consola.next());
                    break;
                case 0: bandera=1;
                    break;
            }
        }
    }
    
    public void menuAntecedentes(){
        System.out.println("-------Tipo de Antecedente--------");
        System.out.println("-----Categorias de Antecedentes---");
        System.out.println("----------Positivas---------------");
        System.out.println("1. A1 | PAGOS");
        System.out.println("2. A2 | INGRESOS");
        System.out.println("3. A3 | REFERENCIAS");
        System.out.println("----------Negativas---------------");
        System.out.println("4. N1 | PAGOS");
        System.out.println("5. N2 | INGRESOS");
        System.out.println("6. N3 | REFERENCIAS");
        System.out.println("----------------------------------");    
        System.out.println("0. Salir ");
        System.out.println("----------------------------------"); 
        System.out.println("Ingrese el tipo de antecedente :");
  
    }
    
   
    
    public void consolaMenuTipoAntecedentePositivo(String cedula){       
        byte bandera=0;
        while(bandera==0){
            menuAntecedentes();
            byte opcion=consola.nextByte();
            switch(opcion){
                case 1: TipoAntecedente antece1 = new TipoAntecedente("A1","PAGOS");
                        añadirantecedente(antece1, cedula);break;
                case 2: TipoAntecedente antece2 = new TipoAntecedente("A2","INGRESOS");
                        añadirantecedente(antece2, cedula);break;
                case 3: TipoAntecedente antece3 = new TipoAntecedente("A3","REFERENCIAS");
                        añadirantecedente(antece3, cedula);break;
                case 4: TipoAntecedente antece4 = new TipoAntecedente("N1","PAGOS");
                        añadirantecedente(antece4, cedula);break;
                case 5: TipoAntecedente antece5 = new TipoAntecedente("N2","INGRESOS");
                        añadirantecedente(antece5, cedula);break;
                case 6: TipoAntecedente antece6 = new TipoAntecedente("N3","REFERENCIAS");
                        añadirantecedente(antece6, cedula);break;
                case 0: bandera=1;break;
            }
        }
    }
    
    public void añadirantecedente(TipoAntecedente tipo,String cedula){
        System.out.println("Ingrese la descripcion del antecedente :");
        String saltoDeLinea = consola.nextLine();
        String descripcion = consola.nextLine();
        crearFicheroConDatos(BusquedaAntecedentesUsuario(tipo,cedula,descripcion));
        
    }
   
    public List<Persona> BusquedaAntecedentesUsuario(TipoAntecedente tipo,String cedula,String descripcion){
        List<Persona>lista = new ArrayList<>();
        Date fecha = new Date();
        List<Antecedentes> lista2 = new ArrayList<>();
        lista=leerFichero();
        for (Persona usuario : lista) {
            if(usuario.getCedula().equals(cedula)){
                lista2=usuario.getLista();
                Antecedentes antecedente = new Antecedentes(fecha, descripcion, tipo);
                lista2.add(antecedente);
                usuario.setLista(lista2);
            }else{
                System.out.println("EL USUARIO NO EXISTE");
            }
        }
        return lista;
    }
  
    public List<Persona> BusquedaAntecedentesUsuario(String cedula){
        List<Persona>lista = new ArrayList<>();
        byte i=1;
        Date fecha = new Date();
        List<Antecedentes> lista2 = new ArrayList<>();
        lista=leerFichero();
        for (Persona usuario : lista) {
            if(usuario.getCedula().equals(cedula)){
                lista2=usuario.getLista();
                System.out.println("-----Antecedentes Negativos Usuario: "+cedula+"----");
                visualizarAntecedentesNegativos(cedula, lista2);
                System.out.println("Digite el indice del antecedente que desea eliminar: ");
                byte posicion = consola.nextByte();
                lista2.remove(posicion);
                usuario.setLista(lista2);
                
            }
        }
        return lista;
    }
    
    public void visualizarAntecedentes(String cedula){
        int i=0;
        List<Antecedentes> lista2 = new ArrayList<>();
        lista=leerFichero();
        for (Persona usuario : lista) {
            if(usuario.getCedula().equals(cedula)){
                lista2=usuario.getLista();
                for (Antecedentes elemento : lista2) {
                    System.out.println((i++)+": "+" | Antecedente :"+elemento.getDescripcion()+
                       "| Tipo :"+elemento.getTipo().getNombreCaracteristico()+"| FECHA :"+elemento.getFechaAntecedente());
                }
            }
        }
    }
    
    public void visualizarAntecedentesNegativos(String cedula,List<Antecedentes>lista){
        int i=0;
        for (Antecedentes elemento : lista) {
            if(elemento.getTipo().getNombreCaracteristico().equals("N1")||elemento.getTipo().getNombreCaracteristico().equals("N2")||elemento.getTipo().getNombreCaracteristico().equals("N3")){
                System.out.println(lista.indexOf(elemento)+": "+" | Antecedente :"+elemento.getDescripcion()+
                   "| Tipo :"+elemento.getTipo().getNombreCaracteristico()+"| FECHA :"+elemento.getFechaAntecedente());
            }
        }
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
    
    public List<Persona> BusquedaEditarUsuario(String cedula){
        List<Persona>lista = new ArrayList<>();
        lista=leerFichero();
        for (Persona usuario : lista) {
            if(usuario.getCedula().equals(cedula)){
                editarUsuario(usuario);
                usuario=menuEdicion(usuario);
            }else{
                System.out.println("EL USUARIO NO EXISTE");
            }
        }
        return lista;
    }
    
    public void eliminarAntecedente(String cedula){
        List<Persona>lista = new ArrayList<>();
        lista=leerFichero();
        for (Persona usuario : lista) {
            if(usuario.getCedula().equals(cedula)){
                
                usuario=menuEdicion(usuario);
            }else{
                System.out.println("EL USUARIO NO EXISTE");
            }
        }
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
