package edu.proyectodual.pasapalabra.controller;

import edu.proyectodual.pasapalabra.App;
import edu.proyectodual.pasapalabra.service.ClienteService;
import edu.proyectodual.pasapalabra.service.ClienteWebService;
import edu.proyectodual.pasapalabra.service.dto.Ranking;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import javafx.scene.text.Text;

import java.io.IOException;
import java.util.List;

public class LogeadoController {
    @FXML
    private Label label;

    @FXML
    private void verRanking() throws IOException {
        App.setRoot("ranking");
    }

    @FXML
    private void volverAlLogIn() throws IOException {
        App.setRoot("primary");
    }

    @FXML
    private void pasarAJugar() throws IOException {
        App.setRoot("juego");
    }

}
