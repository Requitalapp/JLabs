package CargoTransportation;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import static CargoTransportation.FXActions.changeScene;

;


public class MainPageController {

    @FXML
    private Button cargo;

    @FXML
    private Button clients;

    @FXML
    private Button managers;

    @FXML
    private Button orders;

    @FXML
    private Button drivers;

    @FXML
    private Button vehicles;

    @FXML
    private Button routes;

    @FXML
    private Button requests;

    @FXML
    private Button exit;

    @FXML
    void initialize() {

        clients.setOnAction(event -> {
            changeScene("/CargoTransportation/Clients/Clients.fxml", event);
        });

        managers.setOnAction(event -> {
            changeScene("/CargoTransportation/Managers/Managers.fxml", event);
        });

        orders.setOnAction(event -> {
            changeScene("/CargoTransportation/Orders/Orders.fxml", event);
        });

        drivers.setOnAction(event -> {
            changeScene("/CargoTransportation/Drivers/Drivers.fxml", event);
        });

        vehicles.setOnAction(event -> {
            changeScene("/CargoTransportation/Vehicles/Vehicles.fxml", event);
        });

        routes.setOnAction(event -> {
            changeScene("/CargoTransportation/Routes/Routes.fxml", event);
        });

        cargo.setOnAction(event -> {
            changeScene("/CargoTransportation/Cargo/Cargo.fxml", event);
        });

        requests.setOnAction(event -> {
            changeScene("/CargoTransportation/Requests/Requests.fxml", event);
        });

        exit.setOnAction(event -> {
            Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            stage.close();
        });
    }


}