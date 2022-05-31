package edu.proyectodual.pasapalabra.manager.impl;

import edu.proyectodual.pasapalabra.dao.Users;
import edu.proyectodual.pasapalabra.manager.UsersManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UsersManagerImpl implements UsersManager {
    @Override
    public Set<Users> validateUser(Connection con, String name, String password) {
        String sql = "select name,password "
                + "from Users"
                + "where  name = ?"
                + "and password = ? ";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setString(2, password);
            ResultSet result = stmt.executeQuery();
            result.beforeFirst();

            Set<Users> users = new HashSet<>();

            while (result.next()) {
                Users city = new Users(result);


                users.add(city);
            }

            return users;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Users> findAll(Connection con) {
        return null;
    }

    @Override
    public Users findById(Connection con, String id) {
        return null;
    }

    @Override
    public List<Users> findAllByIds(Connection con, Set<String> ids) {
        return null;
    }
}
