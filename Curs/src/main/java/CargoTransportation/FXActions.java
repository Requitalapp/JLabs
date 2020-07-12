package CargoTransportation;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FXActions {

    public static void changeScene(String name, ActionEvent event) {
        try {
            Parent parent = FXMLLoader.load(Main.class.getResource(name));
            Scene newScene = new Scene(parent);

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(newScene);
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void show_display(String name) {

        Parent parent = null;
        try {
            parent = FXMLLoader.load(Main.class.getResource(name));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene newScene = new Scene(parent);
        Stage window = new Stage();
        window.setScene(newScene);
        window.showAndWait();
    }
}
