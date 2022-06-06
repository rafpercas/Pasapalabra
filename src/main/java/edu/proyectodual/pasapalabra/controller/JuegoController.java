package edu.proyectodual.pasapalabra.controller;

import edu.proyectodual.pasapalabra.App;
import edu.proyectodual.pasapalabra.Juego;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class JuegoController implements Initializable {

    @FXML
    private Label labelAciertos;
    @FXML
    private Label labelLetra;

    @FXML
    private Circle circuloA;
    @FXML
    private Circle circuloB;
    @FXML
    private Circle circuloC;
    @FXML
    private Circle circuloD;
    @FXML
    private Circle circuloE;
    @FXML
    private Circle circuloF;
    @FXML
    private Circle circuloG;
    @FXML
    private Circle circuloH;
    @FXML
    private Circle circuloI;
    @FXML
    private Circle circuloJ;
    @FXML
    private Circle circuloK;
    @FXML
    private Circle circuloL;
    @FXML
    private Circle circuloM;
    @FXML
    private Circle circuloN;
    @FXML
    private Circle circuloO;
    @FXML
    private Circle circuloP;
    @FXML
    private Circle circuloQ;
    @FXML
    private Circle circuloR;
    @FXML
    private Circle circuloS;
    @FXML
    private Circle circuloT;
    @FXML
    private Circle circuloU;
    @FXML
    private Circle circuloV;
    @FXML
    private Circle circuloW;
    @FXML
    private Circle circuloX;
    @FXML
    private Circle circuloY;
    @FXML
    private Circle circuloZ;

    @FXML
    private Label labelErrores;

    @FXML
    private Label label;

    @FXML
    private Label label2;

    @FXML
    private TextField respuesta;

    String[] letras = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T"
            ,"U","V","W","X","Y","Z"};
    List<Circle> circulos;
    int indiceLetras =0;
    int[] letrasPasadas = new int[26];
    int indiceLetrasPasadas =0;
    int cojoLetrasPasadas =0;
    Map<String,String> mapaSaltadas = new TreeMap<>();

    @FXML
    private void rendirse() throws IOException {
        App.setRoot("logeado");
    }
    Juego j1 = new Juego();
    List<String> listaLetra;
    int aciertos = 0;
    int errores = 0;
    int contadorEnvios=0;
    @FXML
    private void comenzar() {
        if(indiceLetras==26){
            System.out.println(mapaSaltadas.toString());
            indiceLetras= letrasPasadas[cojoLetrasPasadas];
            cojoLetrasPasadas++;
        }
        listaLetra = j1.preguntasPorLetra(letras[indiceLetras]);
        System.out.println(listaLetra);
        System.out.println(listaLetra.get(0));
        System.out.println(listaLetra.get(1));
        label.setText(listaLetra.get(0));
        labelLetra.setText("Con la "+letras[indiceLetras]);

    }


    @FXML
    private void pasapalabra() {
        label2.setText("");
        if(indiceLetras==26){

            indiceLetras= letrasPasadas[cojoLetrasPasadas];
            cojoLetrasPasadas++;
        }
        mapaSaltadas.put(listaLetra.get(1),listaLetra.get(0));
        letrasPasadas[indiceLetrasPasadas]=indiceLetras;
        indiceLetrasPasadas++;
        indiceLetras++;
        comenzar();

    }

    @FXML
    private void comprobarRespuesta() {
        label2.setText("");
        contadorEnvios++;
        if(indiceLetras==26){
            indiceLetras= letrasPasadas[cojoLetrasPasadas];
            cojoLetrasPasadas++;
        }
    circulos = Arrays.asList(circuloA,circuloB,circuloC,circuloD,circuloE,circuloF,circuloG,circuloH,circuloI,circuloJ,
            circuloK,circuloL,circuloM,circuloN,circuloO,circuloP,circuloQ,circuloR,circuloS,circuloT,circuloU,circuloV,circuloW,
            circuloX,circuloY,circuloZ);

        if(respuesta.getText().toLowerCase(Locale.ROOT).equals(listaLetra.get(1))){
            label2.setText("");
            aciertos++;
            labelAciertos.setText(String.valueOf(aciertos));
            respuesta.setText("");
            System.out.println("correcto");
            circulos.get(indiceLetras).setFill(Color.GREEN);
        }else if (!respuesta.getText().toLowerCase(Locale.ROOT).equals(listaLetra.get(1))) {
            errores++;
            labelErrores.setText(String.valueOf(errores));
            respuesta.setText("");
            circulos.get(indiceLetras).setFill(Color.RED);
            label2.setText("La respuesta correcta era: "+listaLetra.get(1));
        }
        indiceLetras++;
        comenzar();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        label.setWrapText(true);
    }
}




