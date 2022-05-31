package edu.proyectodual.pasapalabra.manager;

import edu.proyectodual.pasapalabra.dao.Users;

import java.sql.Connection;
import java.util.Set;

public interface UsersManager extends Manager<Users, String> {

    Set<Users> validateUser(Connection con, String name,String password);
}
