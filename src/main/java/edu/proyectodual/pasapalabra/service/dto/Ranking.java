package edu.proyectodual.pasapalabra.service.dto;

import jakarta.xml.bind.annotation.XmlRootElement;
import java.sql.ResultSet;
import java.sql.SQLException;

@XmlRootElement
public class Ranking {
    private String name;
    private Integer points;


    @Override
    public String toString() {
        return
                "Nombre: " + name +
                " - Puntuación: " + points+"\n";
    }

    public Ranking() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }
}
