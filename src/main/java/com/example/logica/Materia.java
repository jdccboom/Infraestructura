package com.example.logica;


import javafx.scene.control.CheckBox;

/**
 * 
 */
public class Materia {

    protected String codigo;

    protected nombreMaterias nombre;
    protected int creditos;
    protected int intesidadSemanal;
    protected CheckBox selecion;

    public Materia(String codigo, nombreMaterias nombre, int creditos, int intesidadSemanal) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.creditos = creditos;
        this.intesidadSemanal = intesidadSemanal;
        selecion= new CheckBox(" ");
    }
    
    

    /**
     * Este metodo calcula la cantidad de horas segun el numero de creditos
     */
    public int calcularHorasSemestre() {
        return creditos*48;
    }

    /**
     * Este metodo calcular la la intensidad de horario en el semestre
     */
    public int calcularIntensidadSemestre() {
        return intesidadSemanal*16;
    }

    /**
     * Este metodo devuelve la informacion de la materia
     */
    public String texto() {
        return    "\nCodigo = " + codigo 
                + "\nNombre = " + nombre 
                + "\nCreditos = " + creditos 
                + "\nIntesidadSemanal = " + intesidadSemanal+ "\n";
    }


    public nombreMaterias getNombre() {
        return nombre;
    }

    public int getCreditos() {
        return creditos;
    }

    public int getIntesidadSemanal() {
        return intesidadSemanal;
    }

    public CheckBox getSelecion() {
        return selecion;
    }
    
}