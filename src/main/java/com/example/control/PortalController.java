/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.control;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * FXML Controller class
 *
 * @author ACER
 */
public class PortalController implements Initializable {

    private static Principal p;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        p= new Principal();
    }    
    
    
    @FXML
    private TextField cedula;

    @FXML
    private TextField nombre;

    @FXML
    void eventoBoton(ActionEvent event) throws Exception {
        String nom=nombre.getText();
        nombre.setText("");
        String ced=cedula.getText();
        cedula.setText("");
       
        if ( p.getUni().verificarEstudiante(nom, ced)!=(-1)){
            p.getUni().registrar( p.getUni().verificarEstudiante(nom, ced));
            
            ocultar(event);
            p.abrirLobby();
        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Datos erronios");
            alert.setContentText("Los datos ingresados son erronios, vuelva a ingresarlos");
            alert.showAndWait();
            
        }
        
    }
    
    public static void setP(Principal p){
        PortalController.p=p;
    }
    
     @FXML
    void eventoSalir(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("Salir");
        alert.setContentText("Gracias por usar este progama ");
        alert.showAndWait();
        ocultar(event);
    }

    public void ocultar(Event even) {
        Stage stage;
        stage = (Stage)(((Node)(even.getSource())).getScene().getWindow());
        stage.close();
    }
    
}
