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
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

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
        try {
            if (usuario.getText().equals("") || email.getText().equals("") || contra.getText().equals("")
                    || repitContra.getText().equals("")) {
                throw new ExcepcionCampoVacio("Debe rellenar los campos.");

            }
            if (new ClienteService(new ClienteWebService()).getUserByName(usuario.getText()).getPassword() == null) {
                if (new ClienteService(new ClienteWebService()).getUserByEmail(email.getText()).getPassword() == null) {
                    if (contra.getText().equals(repitContra.getText())) {
                        Users user = new Users();
                        user.setName(usuario.getText());
                        user.setEmail(email.getText());
                        user.setPassword(contra.getText());
                        System.out.println("llega aqui");
                        Users usuariocreado = new ClienteService(new ClienteWebService()).createUsers(user);
                        System.out.println(usuariocreado);
                        if (usuariocreado == null) {
                            label.setTextFill(Color.RED);
                            label.setText("Ha habido un error al crear el usuario");
                            System.out.println("llega");
                            return;
                        }
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
                } else {
                    label.setTextFill(Color.RED);
                    label.setText("Ese correo ya está registrado.");
                }
            } else {
                label.setTextFill(Color.RED);
                label.setText("Un usuario con ese nombre ya existe.");
            }
        } catch (ExcepcionCampoVacio ecv) {
            ecv.printStackTrace();
            label.setTextFill(Color.RED);
            label.setText("Debe rellenar los campos");
        }
    }
}
