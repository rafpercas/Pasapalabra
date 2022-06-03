package edu.proyectodual.pasapalabra.controller;

import edu.proyectodual.pasapalabra.App;
import edu.proyectodual.pasapalabra.Juego;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.shape.Circle;

import java.io.IOException;

public class JuegoController {

    @FXML
    private Label labelAciertos;

    @FXML
    private Circle circuloA;

    @FXML
    private Label labelErrores;

    @FXML
    private Label label;

    @FXML
    private TextField respuesta;

    @FXML
    private void rendirse() throws IOException {
        App.setRoot("logeado");
    }

    @FXML
    private void respuestasCon() {
        int aciertos = 0;
        int errores = 0;

        Juego j1 = new Juego();
        System.out.println(j1.preguntasPorLetra());
        while (j1.preguntasPorLetra().size() > 0) {
            for (int i = 0; i < j1.preguntasPorLetra().size(); i++) {
                labelAciertos.setText(String.valueOf(aciertos));
                labelErrores.setText(String.valueOf(errores));
                label.setText(j1.preguntasPorLetra().get(i));
                if (j1.pasapalabra()) {
                    return;
                } else if (respuesta.getText().equals(j1.preguntasPorLetra().get(i+1))) {
                    aciertos++;
                    j1.preguntasPorLetra().remove(i);
                    j1.preguntasPorLetra().remove(i+1);


                } else if (j1.falla()) {
                    errores++;
                    j1.preguntasPorLetra().remove(i);
                }

            }
        }


    }


}
