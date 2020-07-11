package CargoTransportation;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.SQLException;

public class DeleteCargoController {

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
        Configs dbHandler = new Configs();
        delete.setOnAction(even -> {
            String id_ = id.getText().trim();
            if (!id_.equals("")) {
                if (isNumeric(id_) == true) {
                    try {
                        dbHandler.Del("cargotransportation.cargo", id.getText());
                        message.setText("Cargo has been deleted");
                    }catch(SQLException e){
                        System.out.println(e.getErrorCode());
                        System.out.println("Something went wrong!");
                        e.printStackTrace();
                    }
                } else message.setText("Wrong input!");
            } else
                message.setText("Fill the field!");
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
