package CargoTransportation;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.scene.control.Button;


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
    private Button exit;

    @FXML
    void initialize(){
        clients.setOnAction(event -> {
            show_display("/CargoTransportation/Clients.fxml");
        });

        managers.setOnAction(event -> {
            show_display("/CargoTransportation/Managers.fxml");
        });

        orders.setOnAction(event -> {
            show_display("/CargoTransportation/Orders.fxml");
        });

        drivers.setOnAction(event -> {
            show_display("/CargoTransportation/Drivers.fxml");
        });

        vehicles.setOnAction(event -> {
            show_display("/CargoTransportation/Vehicles.fxml");
        });

        routes.setOnAction(event -> {
            show_display("/CargoTransportation/Routes.fxml");
        });

        cargo.setOnAction(event -> {
            show_display("/CargoTransportation/Cargo.fxml");
        });

        exit.setOnAction(event -> {
            Stage stage = (Stage) ((javafx.scene.control.Button) event.getSource()).getScene().getWindow();
            stage.close();
        });
    }

    void show_display(String name){
        FXMLLoader delFx = new FXMLLoader();
        delFx.setLocation(getClass().getResource(name));

        try {
            delFx.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root_ = delFx.getRoot();
        Stage show = new Stage();
        show.setScene(new Scene(root_));
        show.showAndWait();
    }
}