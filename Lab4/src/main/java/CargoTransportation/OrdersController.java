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



public class OrdersController implements Initializable {
    Connection conn = null;
    ResultSet rs = null;
    Statement st = null;

    @FXML
    private TableView<Orders> table;

    @FXML
    private TableColumn<Orders, Integer> id;

    @FXML
    private TableColumn<Orders, Integer> manager_id;

    @FXML
    private TableColumn<Orders, Integer> client_id;

    @FXML
    private TableColumn<Orders, Integer> route_id;

    @FXML
    private TableColumn<Orders, Integer> driver_id;

    @FXML
    private TableColumn<Orders, Integer> cargo_id;

    @FXML
    private TableColumn<Orders, String> order_date;

    @FXML
    private TableColumn<Orders, String> delivery_date;


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
        conn = Configs.ConnectDB();
        final ObservableList data = FXCollections.observableArrayList();
        String query = "SELECT * FROM cargotransportation.orders";
        Statement st = null;
        try {
            st = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ResultSet rs = null;
        try {
            rs = st.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Orders orders;
        try {
            while (rs.next()) {
                int id = rs.getInt("id");
                int managerId = rs.getInt("manager_id");
                int clientId = rs.getInt("client_id");
                int routeId = rs.getInt("route_id");
                int driverId = rs.getInt("driver_id");
                int cargoId = rs.getInt("cargo_id");
                String orderDate = rs.getString("order_date");
                String deliveryDate = rs.getString("delivery_date");
                orders = new Orders(id, managerId, clientId, routeId, driverId, cargoId, orderDate, deliveryDate);
                data.add(orders);
            }
            st.close();
        } catch (Exception e) {
            System.out.println("There is an Exception.");
            System.out.println(e.getMessage());
        }
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        manager_id.setCellValueFactory(new PropertyValueFactory<>("manager_id"));
        client_id.setCellValueFactory(new PropertyValueFactory<>("client_id"));
        route_id.setCellValueFactory(new PropertyValueFactory<>("route_id"));
        driver_id.setCellValueFactory(new PropertyValueFactory<>("driver_id"));
        cargo_id.setCellValueFactory(new PropertyValueFactory<>("cargo_id"));
        order_date.setCellValueFactory(new PropertyValueFactory<>("order_date"));
        delivery_date.setCellValueFactory(new PropertyValueFactory<>("delivery_date"));
        table.setItems(data);

        exit.setOnAction(event -> {
            Stage stage = (Stage) ((javafx.scene.control.Button) event.getSource()).getScene().getWindow();
            stage.close();
        });

        update.setOnAction(event -> {
            show_display("/CargoTransportation/Orders.fxml");
            update.getScene().getWindow().hide();
        });

        add.setOnAction(event -> {
            show_display("/CargoTransportation/AddOrder.fxml");
        });

        delete.setOnAction(event -> {
            show_display("/CargoTransportation/DeleteOrder.fxml");
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