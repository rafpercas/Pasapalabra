package edu.proyectodual.pasapalabra.service;
import edu.proyectodual.pasapalabra.service.dto.Ranking;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;

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





}
