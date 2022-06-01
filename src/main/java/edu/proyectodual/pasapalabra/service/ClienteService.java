package edu.proyectodual.pasapalabra.service;

import edu.proyectodual.pasapalabra.service.dto.Ranking;
import edu.proyectodual.pasapalabra.service.dto.Users;

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
    public Users getUser(){return clienteWebService.getUsers("Angel");}
    public boolean validateUsers(String name, String password){
        Users user = new Users();
        user.setName(name);
        user.setPassword(password);
        return clienteWebService.validateUser(user);
    }
    public boolean createUsers(Users users){
        Users user = new Users();
        user.setName(users.getName());
        user.setEmail(users.getEmail());
        user.setPassword(users.getPassword());
        return clienteWebService.createUser(user);
    }
    public static void main(String[] args) {
        new ClienteService(new ClienteWebService()).getRanking().forEach(System.out::println);
        System.out.println( new ClienteService(new ClienteWebService()).validateUsers("Angel","12345"));


    }
}
