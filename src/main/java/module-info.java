module edu.proyectodual.pasapalabra{

    requires javafx.controls;
    requires javafx.fxml;

    opens edu.proyectodual.pasapalabra to javafx.fxml;
    opens edu.proyectodual.pasapalabra.controller to javafx.fxml;
    exports edu.proyectodual.pasapalabra;

}
