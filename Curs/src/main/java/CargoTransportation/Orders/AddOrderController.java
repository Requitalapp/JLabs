package CargoTransportation.Orders;

import CargoTransportation.Configs;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.SQLException;

public class AddOrderController {

    @FXML
    private Button add;

    @FXML
    private Button exit;

    @FXML
    private TextArea message;

    @FXML
    private TextField manager_id;

    @FXML
    private TextField client_id;

    @FXML
    private TextField route_id;

    @FXML
    private TextField driver_id;

    @FXML
    private TextField cargo_id;

    @FXML
    private TextField order_date;

    @FXML
    private TextField delivery_date;

    @FXML
    void initialize() {
        Configs dbHandler = new Configs();
        add.setOnAction(even -> {
            String manager_id_ = manager_id.getText().trim();
            String client_id_ = client_id.getText().trim();
            String route_id_ = route_id.getText().trim();
            String driver_id_ = driver_id.getText().trim();
            String cargo_id_ = cargo_id.getText().trim();
            String order_date_ = order_date.getText().trim();
            String delivery_date_ = delivery_date.getText().trim();

            if (!delivery_date_.equals("") && !order_date_.equals("") && !cargo_id_.equals("") && !driver_id_.equals("")
                    && !route_id_.equals("") && !client_id_.equals("") && !manager_id_.equals("")) {
                if (isNumeric(manager_id_) == true && isNumeric(client_id_) == true && isNumeric(route_id_) == true
                        && isNumeric(driver_id_) == true && isNumeric(cargo_id_) == true) {
                    try {
                        dbHandler.AddOrder(manager_id.getText(), client_id.getText(), route_id.getText(),
                                driver_id.getText(), cargo_id.getText(), order_date.getText(), delivery_date.getText());
                        message.setText("Order added!");
                    } catch (SQLException e) {
                        if (e.getErrorCode() == 1452) {
                            message.setText("You entered nonexistent id!");
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

