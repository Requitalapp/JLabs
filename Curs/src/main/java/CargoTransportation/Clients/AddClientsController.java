package CargoTransportation.Clients;

import CargoTransportation.Configs;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.SQLException;

public class AddClientsController {

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
    private TextField address;

    @FXML
    void initialize() {
        Configs dbHandler = new Configs();
        add.setOnAction(even -> {
            String full_name_ = full_name.getText().trim();
            String phone_number_ = phone_number.getText().trim();
            String address_ = address.getText().trim();
            if (!address_.equals("") && !phone_number_.equals("") && !full_name_.equals("")) {
                try {
                    dbHandler.AddClients(full_name.getText(), phone_number.getText(), address.getText());
                    message.setText("Client added!");
                } catch (SQLException e) {
                    e.printStackTrace();
                    message.setText("Something went wrong!");
                }
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

