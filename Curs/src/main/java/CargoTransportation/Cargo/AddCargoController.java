package CargoTransportation.Cargo;

import CargoTransportation.DBHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.SQLException;

public class AddCargoController {

    @FXML
    private Button add;

    @FXML
    private Button exit;

    @FXML
    private TextArea message;

    @FXML
    private TextField type;

    @FXML
    private TextField cost;

    @FXML
    private TextField volume;

    @FXML
    private TextField weight;

    @FXML
    void initialize() {
        add.setOnAction(even -> {
            String type_ = type.getText().trim();
            String cost_ = cost.getText().trim();
            String volume_ = volume.getText().trim();
            String weight_ = weight.getText().trim();
            if (!weight_.equals("") && !volume_.equals("") && !cost_.equals("") && !type_.equals("")) {
                if (isNumeric(cost_) && isNumeric(volume_) && isNumeric(weight_)) {
                    try {
                        DBHandler.AddCargo(type.getText(), cost.getText(), volume.getText(), weight.getText());
                        message.setText("Cargo added!");
                    } catch (SQLException e) {
                        message.setText("Something went wrong!");
                        e.printStackTrace();
                    }
                } else message.setText("Wrong input!");
            } else
                message.setText("Fill all fields!");
        });


        exit.setOnAction(event -> {
            Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
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

