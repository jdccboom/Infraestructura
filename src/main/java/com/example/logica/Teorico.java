package com.example.logica;

/**
 * 
 */
public class Teorico extends Materia {

    private final String prerrequisito;

    public Teorico(String codigo, nombreMaterias nombre, int creditos, int intesidadSemanal,String requisito) {
        super(codigo, nombre, creditos, intesidadSemanal);
        prerrequisito= requisito;
    }

    
   
    public String getPrerrequisito() {
        return prerrequisito;
    }
    
    @Override
    public String toString() {
        return "\nTipo = Teorico\n" 
                + "Prerrequisito = " + prerrequisito + this.texto();
    }
    
}