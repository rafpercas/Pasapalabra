package edu.proyectodual.pasapalabra;

import edu.proyectodual.pasapalabra.service.ClienteService;
import edu.proyectodual.pasapalabra.service.ClienteWebService;

import java.util.ArrayList;
import java.util.List;

public class Juego {
    public Juego() {
    }
    List<String> listaPregunta = new ArrayList<>();
    String[] letras = {"a","b","c","d","e","f","g","h","i","j","k",
            "l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};

    public List<String> preguntasPorLetra(){

        for (int i = 0; i < letras.length; i++) {
            String letra = letras[i];
            int random = (int) (Math.random() * 5);
           // new ClienteService(new ClienteWebService()).getRespuestasCon(letra).forEach(System.out::println);
            String preguntaRandom = new ClienteService(new ClienteWebService()).getRespuestasCon(letra).get(random).getPregunta();
            String respuestaRandom = new ClienteService(new ClienteWebService()).getRespuestasCon(letra).get(random).getRespuesta();

            listaPregunta.add(preguntaRandom);
            listaPregunta.add(respuestaRandom);
        }
        return listaPregunta;
    }
    public List<String> listaPreguntasRespuestas(){
        return listaPregunta;
    }
    public boolean pasapalabra(){
return true;
    }
    public boolean acierta(){
        return true;
    }
    public boolean falla(){
        return true;
    }
}
