package CargoTransportation.Requests;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

import static CargoTransportation.FXActions.changeScene;

public class RequestsController implements Initializable {

    @FXML
    private Button exit;

    @FXML
    private Button req1;

    @FXML
    private Button req2;

    @FXML
    private Button req3;

    @FXML
    private Button req4;


    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        req4.setOnAction(event -> {
            changeScene("/CargoTransportation/Requests/Req4.fxml", event);
        });

        req3.setOnAction(event -> {
            changeScene("/CargoTransportation/Requests/Req3.fxml", event);
        });

        req2.setOnAction(event -> {
            changeScene("/CargoTransportation/Requests/Req2.fxml", event);
        });

        req1.setOnAction(event -> {
            changeScene("/CargoTransportation/Requests/Req1.fxml", event);
        });

        exit.setOnAction(event -> {
            changeScene("/CargoTransportation/MainPage.fxml", event);
        });
    }
}
