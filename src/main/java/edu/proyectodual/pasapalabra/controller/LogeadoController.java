package edu.proyectodual.pasapalabra.controller;

import edu.proyectodual.pasapalabra.App;
import edu.proyectodual.pasapalabra.service.ClienteService;
import edu.proyectodual.pasapalabra.service.ClienteWebService;
import edu.proyectodual.pasapalabra.service.dto.Ranking;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class LogeadoController implements Initializable {
    @FXML
    private Label labelUsuarioLogeado;



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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        labelUsuarioLogeado.setText(App.getUsuario());
    }
}
