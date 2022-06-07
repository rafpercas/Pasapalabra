package edu.proyectodual.pasapalabra.controller;

import com.itextpdf.text.DocumentException;
import edu.proyectodual.pasapalabra.App;
import edu.proyectodual.pasapalabra.crearpdf.PdfCreator;
import edu.proyectodual.pasapalabra.email.Sender;
import edu.proyectodual.pasapalabra.service.ClienteService;
import edu.proyectodual.pasapalabra.service.ClienteWebService;
import edu.proyectodual.pasapalabra.service.dto.Users;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

public class CuentaOlvidadaController {
    @FXML
    private Label label1;

    @FXML
    private TextField email;

    @FXML
    private void volver() throws IOException {
        App.setRoot("primary");
    }

    @FXML
    private void enviar() throws IOException, DocumentException, URISyntaxException {
        Users usuarioRecibido = new ClienteService(new ClienteWebService()).enviarEmail(email.getText());
        if (usuarioRecibido.getName()!=null) {
            label1.setTextFill(Color.GREEN);
            label1.setText("Correo enviado.");
        } else {
            label1.setTextFill(Color.RED);
            label1.setText("El correo indicado no está registrado.");
        }
    }

}
