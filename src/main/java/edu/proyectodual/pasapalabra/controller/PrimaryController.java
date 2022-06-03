package edu.proyectodual.pasapalabra.controller;

import edu.proyectodual.pasapalabra.App;
import edu.proyectodual.pasapalabra.service.ClienteService;
import edu.proyectodual.pasapalabra.service.ClienteWebService;
import edu.proyectodual.pasapalabra.service.dto.Users;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class PrimaryController {

    @FXML
    private TextField user;
    @FXML
    private PasswordField password;
    @FXML
    private Label label;

   @FXML
    private void authenticate() throws IOException {


       if(new ClienteService(new ClienteWebService()).validateUsers(user.getText(), password.getText())){
           App.setRoot("logeado");
           Users usuarioLogeado = new Users(user.getText());
       }else{
           label.setText("Usuario o contraseña incorrectos. Inténtelo de nuevo.");
       }

    }

    @FXML
    private void registrar() throws IOException {
        App.setRoot("registro");
    }
    @FXML
    private void resetField(){
        user.setText("");
        password.setText("");
    }
    @FXML
    private void recuperarCuenta() throws IOException {
        App.setRoot("cuentaOlvidada");
    }

}
