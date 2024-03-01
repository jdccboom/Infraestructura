package com.example.control;


import com.example.logica.Universidad;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

/**
 *
 * @author ACER
 */
public class Principal extends Application {

    private final Universidad uni;
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(Principal.class.getResource("views/Portal.fxml")));
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }
    
    /**
     * Este metodo muestra las ventanas
     */
    public void abrirMaterias() throws Exception {

        abrirVentana("views/Materias.fxml").getController();
        MateriasController.setP(this);
    }
    
    /**
     * Este metodo muestra las ventanas
     */
    public void abrirFactura() throws Exception {
       
        FacturaController mat= abrirVentana("views/Factura.fxml").getController();
        mat.setP(this);
        
    }
    
    
    /**
     * Este metodo muestra las ventanas
     */
    public void abrirPortal() throws Exception {
        abrirVentana("views/Portal.fxml").getController();
        PortalController.setP(this);
        
    }
    
    /**
     * Este metodo muestra las ventanas
     */
     public void abrirDaviplata() throws Exception {
        
        BancosController mat= abrirVentana("views/Daviplata.fxml").getController();
        mat.setP(this);
        
    }
     
     
     /**
     * Este metodo muestra las ventanas
      */
    public void abrirAvevilla() throws Exception {
          
        BancosController mat= abrirVentana("views/Avevilla.fxml").getController();
        mat.setP(this);
        
    }
    
    /**
     * Este metodo muestra las ventanas
     */
    public void abrirBancolombia() throws Exception {
        BancosController mat= abrirVentana("views/Bancolombia.fxml").getController();
        mat.setP(this);
    }
    
    
    /**
     * Este metodo muestra las ventanas
     */
    public void abrirLobby() throws Exception {
        LobbyController mat= abrirVentana("views/Lobby.fxml").getController();
        mat.setP(this);
    }
    
    /**
     * Este metodo muestra las ventanas
     */
    public  FXMLLoader abrirVentana(String ulr) throws IOException{
        FXMLLoader fxmllLoader= new FXMLLoader(getClass().getResource(ulr));
        Parent root = fxmllLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
        return fxmllLoader;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Default constructor
     */
    public Principal() {
        uni= new Universidad();
        
    }

    public Universidad getUni() {
        return uni;
    }


}

