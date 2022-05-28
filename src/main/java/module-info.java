module edu.proyectodal.pasapalabra {

    requires javafx.controls;
    requires javafx.fxml;

    opens edu.proyectodual.pasapalabra to javafx.fxml;
    exports edu.proyectodual.pasapalabra;
}
