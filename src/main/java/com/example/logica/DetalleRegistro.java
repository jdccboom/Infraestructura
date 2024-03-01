package com.example.logica;

import java.util.*;
import java.time.LocalDateTime;

/**
 * 
 */
public class DetalleRegistro {

    private final ArrayList<Materia> listaMateriaR;
    private String codigoRegistro;
    private final String fechaRegistro;
    private final String horaRegistro;

    public DetalleRegistro() {
        this.listaMateriaR = new ArrayList<>();
        LocalDateTime fechaHoy= LocalDateTime.now();
        String fecha=""+ (fechaHoy);
        String[]fyH= fecha.split(""+(fecha.charAt(10)));
        fechaRegistro= fyH[0];
        horaRegistro= fyH[1];
        generarCodigo();
    }

    
    /**
     * Este metodo agrega una materia a la lista de materias
     */
    public void agregarMateria(Materia materia ) {
        this.listaMateriaR.add(materia);
    }

    /**
     * Este metodo genera los el codigo del registro
     */
    private void generarCodigo(){
        codigoRegistro= "";
        for (int i= 0; i <4; i ++){
            codigoRegistro+= String.valueOf((int)(Math.random()*10));
        }
        
    }
    
    /**
     * Este metodo retorna el numero total de creditos que registro
     */
    public int totalCreditos() {
        int sum=0;
        for (Materia materia : listaMateriaR) {
            sum += materia.getCreditos();
        }
        return sum;
    }

    /**
     *  Este metodo retorna el total de intencidad semanal del registro
     */
    public int totalIntensidadSemanal() {
        int sum= 0;
        for (Materia materia : listaMateriaR) {
            sum += materia.getIntesidadSemanal();
        }
        return sum;
    }
    
    /**
     * Este medoto devuelve la cantidad de horas en el semestre
     */
    public int totalHorasSemestre(){
        return totalCreditos()*48;
    }
    
    /**
     * Este medoto devuelve la cantidad horaria semanal en el semestre
     */
    public int totalIntensidadSemestre(){
        
        return totalIntensidadSemanal()*16;
    }
    /**
     * Este metodo verifica que cumpla el numero de materias precticas que se pueden registrar
     */
    public boolean cumpleNpractico(){
        boolean ban=false;
        int sum=0;
        for (Materia materia : listaMateriaR) {
            if (materia instanceof Practico) {
                sum++;
            }
        }
        if (sum <= 2){
            ban=true;
        }
        return ban;
    }

    public ArrayList<Materia> getListaMateriaR() {
        return listaMateriaR;
    }

    public String getCodigoRegistro() {
        return codigoRegistro;
    }
    
    
    @Override
    public String toString() {
        return "\nDetalle del Registro\n"+
               "Codigo del Registro = " + codigoRegistro + 
               "\nFecha del Registro = " + fechaRegistro + 
               "\nHora de Registro = " + horaRegistro
                +"\nMaterias Registradas \n" + 
                listaMateriaR + "\n";
    }

    
}