package com.example.logica;

/**
 * 
 */
public class Teorico_Practico extends Materia {

    private final int horasTeoria;
    private final int horasPractica;

    public Teorico_Practico(int horasTeoria, int horasPractica, String codigo, nombreMaterias nombre, int creditos, int intesidadSemanal) {
        super(codigo, nombre, creditos, intesidadSemanal);
        this.horasTeoria = horasTeoria;
        this.horasPractica = horasPractica;
    }

    
    public int getHorasTeoria() {
        return horasTeoria;
    }

    public int getHorasPractica() {
        return horasPractica;
    }

    @Override
    public String toString() {
        return "\nTipo = Teorico_Practico\n" 
                + "Horas Teoria = " + horasTeoria 
                + "\nHoras Practica = " + horasPractica + this.texto();
    }
    
    
    
}