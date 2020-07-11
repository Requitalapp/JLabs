package CargoTransportation.Drivers;

import CargoTransportation.Configs;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.SQLException;

public class AddDriverController {

    @FXML
    private Button add;

    @FXML
    private Button exit;

    @FXML
    private TextArea message;

    @FXML
    private TextField full_name;

    @FXML
    private TextField license;

    @FXML
    private TextField phone_number;

    @FXML
    private TextField vehicle_id;

    @FXML
    void initialize() {
        Configs dbHandler = new Configs();
        add.setOnAction(even -> {
            String full_name_ = full_name.getText().trim();
            String license_ = license.getText().trim();
            String phone_number_ = phone_number.getText().trim();
            String vehicle_id_ = vehicle_id.getText().trim();
            if (!vehicle_id_.equals("") && !phone_number_.equals("") && !full_name_.equals("") && !license_.equals("")) {
                if (isNumeric(vehicle_id_) == true) {
                    try {
                        dbHandler.AddDriver(full_name.getText(), license.getText(), phone_number.getText(), vehicle_id.getText());
                        message.setText("Driver added!");
                    } catch (SQLException e) {
                        if (e.getErrorCode() == 1452) {
                            message.setText("This vehicle_id doesn't exist!");
                        } else {
                            message.setText("Something went wrong!");
                        }
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

