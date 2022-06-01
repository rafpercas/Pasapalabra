package edu.proyectodual.pasapalabra.service.dto;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Users {

    private String name;
    private String email;
    private String password;

    @Override
    public String toString() {
        return "Users{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password=" + password +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Users() {
    }
}
