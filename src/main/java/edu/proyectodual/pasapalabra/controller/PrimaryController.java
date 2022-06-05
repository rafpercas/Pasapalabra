package edu.proyectodual.pasapalabra.controller;

import edu.proyectodual.pasapalabra.App;
import edu.proyectodual.pasapalabra.excepciones.ExcepcionCampoVacio;
import edu.proyectodual.pasapalabra.service.ClienteService;
import edu.proyectodual.pasapalabra.service.ClienteWebService;
import edu.proyectodual.pasapalabra.service.dto.Users;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import java.io.IOException;

public class PrimaryController {

    @FXML
    private TextField user;
    String usuario;
    @FXML
    private PasswordField password;
    @FXML
    private Label label;

   @FXML
    private void authenticate() throws IOException,ExcepcionCampoVacio {

        try{
            if (user.getText().equals("") || password.getText().equals("")){
                throw new ExcepcionCampoVacio("Debe rellenar los campos.");

            }if(new ClienteService(new ClienteWebService()).validateUsers(user.getText(), password.getText())){
                App.setRoot("logeado");

            }else{
                label.setTextFill(Color.RED);
                label.setText("Usuario o contraseña incorrectos. Inténtelo de nuevo.");
            }
        }catch(ExcepcionCampoVacio ecv){
            ecv.printStackTrace();
            label.setTextFill(Color.RED);
            label.setText("Debe rellenar los campos");
        }


    }
@FXML
public String usuarioLogeado(){

        return usuario;


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
