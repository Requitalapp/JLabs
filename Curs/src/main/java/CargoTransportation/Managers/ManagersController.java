package CargoTransportation.Managers;

import CargoTransportation.Clients.Clients;
import CargoTransportation.ConnectionToDB;
import CargoTransportation.Const;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import static CargoTransportation.FXActions.changeScene;
import static CargoTransportation.FXActions.show_display;


public class ManagersController implements Initializable {
    ResultSet rs = null;
    Statement st = null;

    @FXML
    private TableView<Clients> table;

    @FXML
    private TableColumn<Clients, Integer> id;

    @FXML
    private TableColumn<Clients, String> full_name;

    @FXML
    private TableColumn<Clients, String> phone_number;

    @FXML
    private Button add;

    @FXML
    private Button update;

    @FXML
    private Button delete;

    @FXML
    private Button exit;


    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        final ObservableList data = FXCollections.observableArrayList();
        String query = "SELECT * FROM " + Const.MANAGERS_TABLE;
        Statement st = null;
        try {
            st = ConnectionToDB.getConnection().createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ResultSet rs = null;
        try {
            rs = st.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Managers managers;
        try {
            while (rs.next()) {
                int id = rs.getInt(Const.MANAGERS_ID);
                String full_name = rs.getString(Const.MANAGERS_FULL_NAME);
                String phone_number = rs.getString(Const.MANAGERS_PHONE_NUMBER);
                managers = new Managers(id, full_name, phone_number);
                data.add(managers);
            }
            st.close();
        } catch (Exception e) {
            System.out.println("There is an Exception.");
            System.out.println(e.getMessage());
        }
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        full_name.setCellValueFactory(new PropertyValueFactory<>("full_name"));
        phone_number.setCellValueFactory(new PropertyValueFactory<>("phone_number"));
        table.setItems(data);

        exit.setOnAction(event -> {
            changeScene("/CargoTransportation/MainPage.fxml", event);
        });

        update.setOnAction(event -> {
            changeScene("/CargoTransportation/Managers/Managers.fxml", event);
        });

        add.setOnAction(event -> {
            show_display("/CargoTransportation/Managers/AddManager.fxml");
            changeScene("/CargoTransportation/Managers/Managers.fxml", event);
        });

        delete.setOnAction(event -> {
            show_display("/CargoTransportation/Managers/DeleteManager.fxml");
            changeScene("/CargoTransportation/Managers/Managers.fxml", event);
        });

    }
}