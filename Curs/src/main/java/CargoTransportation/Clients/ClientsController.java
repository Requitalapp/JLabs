package CargoTransportation.Clients;

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


public class ClientsController implements Initializable {
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
    private TableColumn<Clients, String> address;

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
        String query = "SELECT * FROM " + Const.CLIENTS_TABLE;
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
        Clients clients;
        try {
            while (rs.next()) {
                int id = rs.getInt(Const.CLIENTS_ID);
                String full_name = rs.getString(Const.CLIENTS_FULL_NAME);
                String phone_number = rs.getString(Const.CLIENTS_PHONE_NUMBER);
                String address = rs.getString(Const.CLIENTS_ADDRESS);
                clients = new Clients(id, full_name, phone_number, address);
                data.add(clients);
            }
            st.close();
        } catch (Exception e) {
            System.out.println("There is an Exception.");
            System.out.println(e.getMessage());
        }
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        full_name.setCellValueFactory(new PropertyValueFactory<>("full_name"));
        phone_number.setCellValueFactory(new PropertyValueFactory<>("phone_number"));
        address.setCellValueFactory(new PropertyValueFactory<>("address"));
        table.setItems(data);

        exit.setOnAction(event -> {
            changeScene("/CargoTransportation/MainPage.fxml", event);
        });

        update.setOnAction(event -> {
            changeScene("/CargoTransportation/Clients/Clients.fxml", event);
        });

        add.setOnAction(event -> {
            show_display("/CargoTransportation/Clients/AddClient.fxml");
            changeScene("/CargoTransportation/Clients/Clients.fxml", event);
        });

        delete.setOnAction(event -> {
            show_display("/CargoTransportation/Clients/DeleteClient.fxml");
            changeScene("/CargoTransportation/Clients/Clients.fxml", event);
        });

    }
}