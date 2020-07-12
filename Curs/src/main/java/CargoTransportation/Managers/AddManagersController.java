package CargoTransportation.Managers;

import CargoTransportation.DBHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.SQLException;

public class AddManagersController {

    @FXML
    private Button add;

    @FXML
    private Button exit;

    @FXML
    private TextArea message;

    @FXML
    private TextField full_name;

    @FXML
    private TextField phone_number;

    @FXML
    void initialize() {
        add.setOnAction(even -> {
            String full_name_ = full_name.getText().trim();
            String phone_number_ = phone_number.getText().trim();
            if (!phone_number_.equals("") && !full_name_.equals("")) {
                try {
                    DBHandler.AddManager(full_name.getText(), phone_number.getText());
                    message.setText("Manager added!");
                } catch (SQLException e) {
                    message.setText("Something went wrong!");
                    e.printStackTrace();
                }
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

