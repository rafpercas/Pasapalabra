package edu.proyectodual.pasapalabra.service;

import edu.proyectodual.pasapalabra.service.dto.Preguntas;
import edu.proyectodual.pasapalabra.service.dto.Ranking;
import edu.proyectodual.pasapalabra.service.dto.Users;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

public class ClienteService {
    private ClienteWebService clienteWebService;

    public ClienteService(ClienteWebService clienteWebService) {
        this.clienteWebService = clienteWebService;
    }

    //llamar en la pantalla que quieroque me salga
    public List<Ranking> getRanking() {
        return clienteWebService.getRankings();
    }

    public List<Preguntas> getRespuestasCon(String letra) {
        return clienteWebService.getRespuestasCon(letra);
    }

    public Users getUserByEmail(String email) {
        return clienteWebService.getUsersByEmail(email);
    }

    public boolean validateUsers(String name, String password) {
        Users user = new Users();
        user.setName(name);
        user.setPassword(password);
        return clienteWebService.validateUser(user);
    }

    public Users createUsers(Users users) {
        Users user = new Users();
        user.setName(users.getName());
        user.setEmail(users.getEmail());
        user.setPassword(users.getPassword());
        return clienteWebService.createUser(user);

    }
    public Users getUserByName(String name) {
        return clienteWebService.getUsersByName(name);
    }

    public static void main(String[] args) {
        new ClienteService(new ClienteWebService()).getRanking().forEach(System.out::println);
        System.out.println(new ClienteService(new ClienteWebService()).validateUsers("Angel", "12345"));


    }

}
