package edu.proyectodual.pasapalabra.service;

import edu.proyectodual.pasapalabra.service.dto.Ranking;

import java.util.List;

public class ClienteService {
    private ClienteWebService clienteWebService;

    public ClienteService(ClienteWebService clienteWebService) {
        this.clienteWebService = clienteWebService;
    }
    //llamar en la pantalla que quieroque me salga
    public List<Ranking> getRanking(){
        return clienteWebService.getRankings();
    }

    public static void main(String[] args) {
        new ClienteService(new ClienteWebService()).getRanking().forEach(System.out::println);

    }
}
