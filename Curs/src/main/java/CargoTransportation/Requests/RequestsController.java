package CargoTransportation.Requests;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RequestsController  implements Initializable {

    @FXML
    private Button exit;

    @FXML
    private  Button req1;

    @FXML
    private  Button req2;

    @FXML
    private  Button req3;

    @FXML
    private  Button req4;


    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        req4.setOnAction(event -> {
            show_display("/CargoTransportation/Requests/Req4.fxml");
        });

        req3.setOnAction(event -> {
            show_display("/CargoTransportation/Requests/Req3.fxml");
        });

        req2.setOnAction(event -> {
            show_display("/CargoTransportation/Requests/Req2.fxml");
        });

        req1.setOnAction(event -> {
            show_display("/CargoTransportation/Requests/Req1.fxml");
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
