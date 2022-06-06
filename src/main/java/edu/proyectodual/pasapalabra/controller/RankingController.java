package edu.proyectodual.pasapalabra.controller;

import edu.proyectodual.pasapalabra.App;
import edu.proyectodual.pasapalabra.service.ClienteService;
import edu.proyectodual.pasapalabra.service.ClienteWebService;
import edu.proyectodual.pasapalabra.service.dto.Ranking;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class RankingController implements Initializable {

    @FXML
    private  TableView table;

    @FXML
    private void volver() throws IOException {
        App.setRoot("logeado");
    }

    @FXML
    private void verRanking() {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        List<Ranking> ranking = new ClienteService(new ClienteWebService()).getRanking();
        TableView tableView = new TableView();

        TableColumn<String, String> column1 =
                new TableColumn<>("Usuario");

        column1.setCellValueFactory(
                new PropertyValueFactory<>("name"));


        TableColumn<String, String> column2 =
                new TableColumn<>("Puntos");

        column2.setCellValueFactory(
                new PropertyValueFactory<>("points"));

        table.getColumns().clear();

        table.getColumns().add(column1);
        table.getColumns().add(column2);
        table.resizeColumn(column1,160);
        table.resizeColumn(column2,160);
        table.getItems().clear();
        for (int i = 0; i < ranking.size(); i++) {
            table.getItems().add(ranking.get(i));
        }

    }
}
