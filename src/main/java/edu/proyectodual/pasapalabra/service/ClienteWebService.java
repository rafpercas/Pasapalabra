package edu.proyectodual.pasapalabra.service;

import edu.proyectodual.pasapalabra.service.dto.Preguntas;
import edu.proyectodual.pasapalabra.service.dto.Ranking;
import edu.proyectodual.pasapalabra.service.dto.Users;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Arrays;
import java.util.List;

public class ClienteWebService {

    private final WebTarget webTarget;

    public ClienteWebService() {
        Client client = ClientBuilder.newClient();
        this.webTarget = client.target("http://localhost:8080/pasapalabrawebservice/api/");
    }

    public List<Ranking> getRankings() {

        return Arrays.asList(webTarget.path("ranking")
                .request(MediaType.APPLICATION_JSON)
                .get(Ranking[].class));
    }
    public Users getUsersByEmail(String email) {

        return webTarget.path("users/email/"+email)
                .request(MediaType.APPLICATION_JSON)
                .get(Users.class);
    }
    public Users enviarEmail(String email) {

        return webTarget.path("users/cuenta/"+email)
                .request(MediaType.APPLICATION_JSON)
                .get(Users.class);
    }
    public Users getUsersByName(String name) {

        return webTarget.path("users/"+name)
                .request(MediaType.APPLICATION_JSON)
                .get(Users.class);
    }

    public Users createUser(Users users)  {
        return webTarget.path("users/createuser")
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(users,MediaType.APPLICATION_JSON),Users.class);
    }
    public Ranking createRanking(Ranking ranking)  {
        return webTarget.path("ranking/addranking")
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(ranking,MediaType.APPLICATION_JSON),Ranking.class);
    }
    public boolean validateUser(Users users){
        Response response = webTarget.path("users/validateuser")
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(users,MediaType.APPLICATION_JSON));
        return response.getStatus()==200;

    }
    public List<Preguntas> getRespuestasCon(String letra) {

        return Arrays.asList(webTarget.path("preguntas/"+letra)
                .request(MediaType.APPLICATION_JSON)
                .get(Preguntas[].class));
    }

}
