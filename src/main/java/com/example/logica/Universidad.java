package com.example.logica;


/**
 * 
 */
public class Universidad {

    private final String nombre;
    private final BaseDatos dato;
    private Estudiante estu;
    private DetalleRegistro regis;
    private DetallesPago pago;

    public Universidad() {
        this.nombre = "San Jorge";
        this.dato = new BaseDatos();
        regis= new DetalleRegistro();
    }
    
    

    /**
     * Este metodo se usa para consultar los datos de las materias
     */
    public Materia consultarDatos(nombreMaterias materia) {
        Materia ban= null;
        boolean encontrado=false;
        for(int i = 0; i< dato.getListaMateria().size()&& !encontrado; i++){
            if (dato.getListaMateria().get(i).getNombre().equals(materia)){
                ban= dato.getListaMateria().get(i);
                encontrado=true;
            }
        }
        return ban;
    }

    /**
     * Este metodo se encargar de rigistrar las materia
     */
    public void registrar(int posicion){
        estu= dato.getListaEstudiantes().get(posicion);
        dato.addListaDetallesRegistros(regis);
    }
    
    /**
     * Metodo utilizado para agragar las materias a la lista de detallesRegistro
     */
    public boolean agragarMateria(nombreMaterias nom) {
        boolean regi=false;
        if (consultarDatos(nom)!=null){
            regis.agregarMateria(consultarDatos(nom));
            regi=true;
        }
        return regi;
    }

    /**
     * Este metodo se usa para verificar que cumpla las condiciones de pago y retorna el valor de la matricula
     */
    public double verificarPago(){
        double res= 0;
        if ((regis.totalCreditos()>=12) && (regis.totalCreditos()<=20)){
            if(regis.cumpleNpractico()){
                res= (regis.totalCreditos())*45000;
            }
        }
        return res;
    }
    
    
    /**
     * metodo para escoger el banco donde realiza el pago
     */
    public void escogerBanco(Bancos banco){
        pago = new DetallesPago(banco, estu, regis);
        dato.addDetallesPagos(pago);
        regis=new DetalleRegistro();
    }
    
    /**
     * Este metodo se encargar de verificar si el los datos ingrasados estan en la base de datos
     */
    public int verificarEstudiante(String nom, String ced){
        int ban=-1;
        for(int i=0;i< dato.getListaEstudiantes().size();i++){
            if (dato.getListaEstudiantes().get(i).getNombre().equals(nom)){
                if (dato.getListaEstudiantes().get(i).getCedula().equals(ced)){
                    ban=i;
                }
            }
        }
        return ban;
    }
    
    /**
     * Este metodo se encarga de limpiar la lista de materias 
     * en caso que no se cumpla los requisitos de registro
     */
    public void borrarLista(){
        regis.getListaMateriaR().clear();
        
    }
    
    /**
     * Este medodo se utiliza para dar la posision donde esta el registro
     */
    public int darRegis(String cod){
        int ban=-1;
        for(int i=0;i< dato.getListaDetallesRegistros().size();i++){
            if (dato.getListaDetallesRegistros().get(i).getCodigoRegistro().equals(cod)){
               ban=i;
            }
        }
        return ban;
        
    } 
    
    public Estudiante getEstu() {
        return estu;
    }

    public DetalleRegistro getRegis() {
        return regis;
    }

    public DetallesPago getPago() {
        return pago;
    }

    public BaseDatos getDato() {
        return dato;
    }
    
    
    @Override
    public String toString() {
        return "Universidad  "+this.nombre+" \n"
                + regis;
    }
    

}