package com.example.logica;


import java.util.*;

/**
 * 
 */
public class Estudiante {

    private final String nombre;
    private final String cedula;
    private final ArrayList<String> historial;
    private String codigoRegistro;
    
    public Estudiante(String nombre, String cedula) {
        this.nombre = nombre;
        this.cedula = cedula;
        codigoRegistro= "";
        historial= new ArrayList<>();
    }

    public String getCodigoRegistro() {
        return codigoRegistro;
    }

    public void setCodigoRegistro(String codigoRegistro) {
        this.codigoRegistro = codigoRegistro;
    }

    
    public String getNombre() {
        return nombre;
    }

    public String getCedula() {
        return cedula;
    }
    public void addHistorial(String nombre){
        historial.add(nombre);
    }
    public boolean verificarRequisito(String nom){
        boolean ban= false;
        for (String s : historial) {
            if (s.equals(nom)) {
                ban = true;
                break;
            }
        }
        return ban;
    }

    @Override
    public String toString() {
        return "\n"
                + "Nombre = " + nombre 
                + "\nCedula =" + cedula ;
    }
    
}