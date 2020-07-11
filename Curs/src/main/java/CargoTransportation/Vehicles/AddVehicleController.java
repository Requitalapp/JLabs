package CargoTransportation.Vehicles;

import CargoTransportation.Configs;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.SQLException;

public class AddVehicleController {

    @FXML
    private Button add;

    @FXML
    private Button exit;

    @FXML
    private TextArea message;

    @FXML
    private TextField license_plate;

    @FXML
    private TextField model;

    @FXML
    private TextField fuel_consumption;

    @FXML
    private TextField carrying;

    @FXML
    private TextField wagon_volume;

    @FXML
    void initialize() {
        Configs dbHandler = new Configs();
        add.setOnAction(even -> {
            String license_plate_ = license_plate.getText().trim();
            String model_ = model.getText().trim();
            String fuel_consumption_ = fuel_consumption.getText().trim();
            String carrying_ = carrying.getText().trim();
            String wagon_volume_ = wagon_volume.getText().trim();
            if (!wagon_volume_.equals("") && !carrying_.equals("") && !fuel_consumption_.equals("") && !model_.equals("") && !license_plate_.equals("")) {
                if (isNumeric(wagon_volume_) == true && isNumeric(carrying_) == true && isNumeric(fuel_consumption_) == true) {
                    try {
                        dbHandler.AddVehicle(license_plate.getText(), model.getText(), fuel_consumption.getText(), carrying.getText(), wagon_volume.getText());
                        message.setText("Vehicle added!");
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

