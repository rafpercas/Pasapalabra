package edu.proyectodual.pasapalabra;

import edu.proyectodual.pasapalabra.service.ClienteService;
import edu.proyectodual.pasapalabra.service.ClienteWebService;

import java.util.ArrayList;
import java.util.List;

public class Juego {
    public Juego() {
    }



    public List<String> preguntasPorLetra(String letra){
        List<String> listaPregunta = new ArrayList<>();

            int random = (int) (Math.random() * 5);
           // new ClienteService(new ClienteWebService()).getRespuestasCon(letra).forEach(System.out::println);
            String preguntaRandom = new ClienteService(new ClienteWebService()).getRespuestasCon(letra).get(random).getPregunta();
            String respuestaRandom = new ClienteService(new ClienteWebService()).getRespuestasCon(letra).get(random).getRespuesta();
        System.out.println(preguntaRandom);
        System.out.println(respuestaRandom);
            listaPregunta.add(preguntaRandom);
            listaPregunta.add(respuestaRandom);

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
