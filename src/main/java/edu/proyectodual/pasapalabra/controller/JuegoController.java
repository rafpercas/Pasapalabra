package edu.proyectodual.pasapalabra.controller;

import edu.proyectodual.pasapalabra.App;
import javafx.fxml.FXML;

import java.io.IOException;

public class JuegoController {
    @FXML
    private void rendirse() throws IOException {
        App.setRoot("logeado");
    }
    @FXML
    private void enviarRespuesta(){
    }
}
