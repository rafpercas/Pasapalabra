package edu.proyectodual.pasapalabra.controller;

import edu.proyectodual.pasapalabra.App;
import edu.proyectodual.pasapalabra.service.ClienteService;
import edu.proyectodual.pasapalabra.service.ClienteWebService;
import edu.proyectodual.pasapalabra.service.dto.Ranking;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;

public class LogeadoController {
    @FXML
    private Label label;

    @FXML
    private void verRanking() throws IOException {
        new ClienteService(new ClienteWebService()).getRanking().forEach(System.out::println);
        label.setText(new ClienteService(new ClienteWebService()).getRanking().toString());
    }

    @FXML
    private void volverAlLogIn() throws IOException {
        App.setRoot("primary");
    }

}
