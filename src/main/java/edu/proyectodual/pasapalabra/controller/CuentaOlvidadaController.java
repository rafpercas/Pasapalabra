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
        Users usuarioRecibido = new ClienteService(new ClienteWebService()).getUserByEmail(email.getText());
        if (usuarioRecibido != null) {

            PdfCreator pdfCreator = new PdfCreator();

            pdfCreator.createPdf("datos_cuenta", "Nombre de usuario: " + usuarioRecibido.getName() + "\n" + "Contraseña: " + usuarioRecibido.getPassword());
            //File archivo = new File("datos_cuenta");
            Sender sender = new Sender();
            String content = "Nombre de usuario: " + usuarioRecibido.getName() + "\n" + "Contraseña: " + usuarioRecibido.getPassword();
            sender.send("proyectodualpasapalabra@gmail.com", email.getText(), "Recuperacion de cuenta", content );
            label1.setTextFill(Color.GREEN);
            label1.setText("El correo se ha enviado correctamente.");
        } else {
            label1.setTextFill(Color.RED);
            label1.setText("El correo indicado no existe.");
        }
    }

}
