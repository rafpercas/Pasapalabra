package edu.proyectodual.pasapalabra.service.dto;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Preguntas {
    private String pregunta;
    private String respuesta;

    public Preguntas() {
    }

    @Override
    public String toString() {
        return "Preguntas{" +
                "pregunta='" + pregunta + '\'' +
                ", respuesta='" + respuesta + '\'' +
                '}';
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }
}
