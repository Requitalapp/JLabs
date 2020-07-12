package CargoTransportation.Orders;

import CargoTransportation.Const;
import CargoTransportation.DBHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.SQLException;

public class DeleteOrderController {

    @FXML
    private Button delete;

    @FXML
    private Button exit;

    @FXML
    private TextField id;

    @FXML
    private TextArea message;

    @FXML
    void initialize() {
        delete.setOnAction(even -> {
            String id_ = id.getText().trim();
            if (!id_.equals("")) {
                if (isNumeric(id_) == true) {
                    try {
                        if (DBHandler.Del(Const.ORDERS_TABLE, id.getText())){
                            message.setText("Order has been deleted");
                        }else {
                            message.setText("No orders with this id found");
                        }
                    } catch (SQLException e) {
                        message.setText("Something went wrong!");
                        System.out.println(e.getErrorCode());
                        e.printStackTrace();
                    }
                } else message.setText("Enter another ID!");
            } else
                message.setText("Fill the field!");
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
