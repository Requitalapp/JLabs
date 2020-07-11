package CargoTransportation;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;



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
        String query = "SELECT * FROM cargotransportation.clients";
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
                int id = rs.getInt("id");
                String full_name = rs.getString("full_name");
                String phone_number = rs.getString("phone_number");
                String address = rs.getString("address");
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
            Stage stage = (Stage) ((javafx.scene.control.Button) event.getSource()).getScene().getWindow();
            stage.close();
        });

        update.setOnAction(event -> {
            show_display("/CargoTransportation/Clients.fxml");
            update.getScene().getWindow().hide();
        });

        add.setOnAction(event -> {
            show_display("/CargoTransportation/AddClient.fxml");
        });

        delete.setOnAction(event -> {
            show_display("/CargoTransportation/DeleteClient.fxml");
        });

    }

    void show_display(String name) {
        FXMLLoader delFx = new FXMLLoader();
        delFx.setLocation(getClass().getResource(name));

        try {
            delFx.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root_ = delFx.getRoot();
        Stage show = new Stage();
        show.setScene(new Scene(root_));
        show.showAndWait();
    }
}