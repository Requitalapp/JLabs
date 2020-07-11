package CargoTransportation.Routes;

import CargoTransportation.Configs;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.SQLException;

public class AddRouteController {

    @FXML
    private Button add;

    @FXML
    private Button exit;

    @FXML
    private TextArea message;

    @FXML
    private TextField start_point;

    @FXML
    private TextField end_point;

    @FXML
    private TextField distance;


    @FXML
    void initialize() {
        Configs dbHandler = new Configs();
        add.setOnAction(even -> {
            String start_point_ = start_point.getText().trim();
            String end_point_ = end_point.getText().trim();
            String distance_ = distance.getText().trim();
            if (!start_point_.equals("") && !end_point_.equals("") && !distance_.equals("")) {
                if (isNumeric(distance_) == true) {
                    try {
                        dbHandler.AddRoute(start_point.getText(), end_point.getText(), distance.getText());
                        message.setText("Route added!");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                } else message.setText("Wrong input!");
            } else
                message.setText("Fill all fields!");
        });


        exit.setOnAction(event -> {
            Stage stage = (Stage) ((javafx.scene.control.Button) event.getSource()).getScene().getWindow();
            stage.close();
        });
    }

    public static boolean isNumeric(String str) {
        try {
            double d = Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}

