package edu.proyectodual.pasapalabra.controller;

import edu.proyectodual.pasapalabra.App;
import edu.proyectodual.pasapalabra.service.ClienteService;
import edu.proyectodual.pasapalabra.service.ClienteWebService;
import edu.proyectodual.pasapalabra.service.dto.Users;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import java.io.IOException;

public class RegistroController {
    @FXML
    private TextField usuario;
    @FXML
    private TextField email;
    @FXML
    private PasswordField contra;
    @FXML
    private PasswordField repitContra;
    @FXML
    private Label label;

    @FXML
    private void volverAlLogIn() throws IOException {
        App.setRoot("primary");
    }

    @FXML
    private void registrarUser() {

        if (!new ClienteService(new ClienteWebService()).validateUsers(usuario.getText(), contra.getText())) {
            if (contra.getText().equals(repitContra.getText())) {
                Users user = new Users();
                user.setName(usuario.getText());
                user.setEmail(email.getText());
                user.setPassword(contra.getText());
                new ClienteService(new ClienteWebService()).createUsers(user);
                label.setTextFill(Color.GREEN);
                label.setText("Usuario creado correctamente.");
                usuario.setText("");
                email.setText("");
                contra.setText("");
                repitContra.setText("");

            } else {
                label.setTextFill(Color.RED);
                label.setText("Las contraseñas no coinciden");
            }
        }else{
            label.setTextFill(Color.RED);
            label.setText("Ya existe un usuario con ese nombre.");
        }
    }

}
