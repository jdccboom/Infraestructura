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
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * FXML Controller class
 *
 * @author ACER
 */
public class LobbyController implements Initializable {

    private static Principal p;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        p = new Principal();
    }

    public void setP(Principal p) {
        LobbyController.p = p;
        inicio();
    }

    @FXML
    private Label etiqueta;

    /**
     * Este metodo me manda a registrar materia
     *
     */
    @FXML
    void eventoBoton(ActionEvent event) throws Exception {
        
        String cod=p.getUni().getEstu().getCodigoRegistro();
        if (cod.equals("")) {
            p.abrirMaterias();
            ocultar(event);
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("RESGISTRO Completo");
            alert.setContentText(p.getUni().getDato().getListaDetallesRegistros().get(p.getUni().darRegis(cod)).toString());
            alert.showAndWait();
        }

    }

    /**
     * Este metodo sale del lobby
     *
     */
    @FXML
    void eventoSalir(ActionEvent event) throws Exception {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("Cerrar sesion");
        alert.setContentText("Gracias por usar este progama ");
        alert.showAndWait();
        ocultar(event);
        p.abrirPortal();
        ocultar(event);
    }

    /**
     * Este metodo oculta la ventana
     *
     */
    public void ocultar(Event even) {
        Stage stage;
        stage = (Stage) (((Node) (even.getSource())).getScene().getWindow());
        stage.close();
    }

    private void inicio() {
        etiqueta.setText("Bienvenido al tu portal " + p.getUni().getEstu().getNombre());
    }

}
