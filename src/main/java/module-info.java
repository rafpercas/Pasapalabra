module edu.proyectodual.pasapalabra{

    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires jakarta.ws.rs;
    requires jakarta.xml.bind;
    requires java.mail;
    requires itextpdf;

    opens edu.proyectodual.pasapalabra to javafx.fxml;
    opens edu.proyectodual.pasapalabra.controller to javafx.fxml;
    exports edu.proyectodual.pasapalabra;
    exports edu.proyectodual.pasapalabra.service.dto;
    exports edu.proyectodual.pasapalabra.service;



}
