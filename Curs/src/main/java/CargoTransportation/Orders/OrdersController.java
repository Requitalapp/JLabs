package CargoTransportation.Orders;

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


public class OrdersController implements Initializable {
    ResultSet rs = null;
    Statement st = null;

    @FXML
    private TableView<Orders> table;

    @FXML
    private TableColumn<Orders, Integer> id;

    @FXML
    private TableColumn<Orders, String> manager_name;

    @FXML
    private TableColumn<Orders, String> client_name;

    @FXML
    private TableColumn<Orders, String> start_point;

    @FXML
    private TableColumn<Orders, String> end_point;

    @FXML
    private TableColumn<Orders, String> driver_name;

    @FXML
    private TableColumn<Orders, String> cargo_type;

    @FXML
    private TableColumn<Orders, String> license_plate;

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
        final ObservableList data = FXCollections.observableArrayList();
//        String query = "SELECT * FROM " + Const.ORDERS_TABLE;
        String query = "SELECT o.id, m.full_name, cl.full_name, r.start_point, r.end_point, d.full_name, v.license_plate, c.type, o.order_date, o.delivery_date " +
                "FROM " + Const.ORDERS_TABLE + " as o ," + Const.CARGO_TABLE + " as c ," + Const.MANAGERS_TABLE + " as m ,"
                + Const.CLIENTS_TABLE + " as cl ," + Const.DRIVERS_TABLE + " as d ," + Const.ROUTES_TABLE + " as r," + Const.VEHICLES_TABLE + " as v " +
                "WHERE o.manager_id = m.id and o.client_id = cl.id and o.route_id = r.id and o.driver_id = d.id and o.cargo_id = c.id and d.vehicle_id = v.id ";
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
        Orders orders;
        try {
            while (rs.next()) {
                int id = rs.getInt(Const.ORDERS_ID);
                String manager_name = rs.getString("m.full_name");
                String client_name = rs.getString("cl.full_name");
                String route_start = rs.getString("r.start_point");
                String route_end = rs.getString("r.end_point");
                String driver_name = rs.getString("d.full_name");
                String vehicle_license_plate = rs.getString("v.license_plate");
                String cargo_type = rs.getString("c.type");
                String orderDate = rs.getString("o.order_date");
                String deliveryDate = rs.getString("o.delivery_date");
                orders = new Orders(id, manager_name, client_name, route_start, route_end, driver_name, vehicle_license_plate, cargo_type,
                        orderDate, deliveryDate);
                data.add(orders);
            }
            st.close();
        } catch (Exception e) {
            System.out.println("There is an Exception.");
            System.out.println(e.getMessage());
        }
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        manager_name.setCellValueFactory(new PropertyValueFactory<>("manager_name"));
        client_name.setCellValueFactory(new PropertyValueFactory<>("client_name"));
        start_point.setCellValueFactory(new PropertyValueFactory<>("route_start"));
        end_point.setCellValueFactory(new PropertyValueFactory<>("route_end"));
        driver_name.setCellValueFactory(new PropertyValueFactory<>("driver_name"));
        license_plate.setCellValueFactory(new PropertyValueFactory<>("vehicle_license_plate"));
        cargo_type.setCellValueFactory(new PropertyValueFactory<>("cargo_type"));
        order_date.setCellValueFactory(new PropertyValueFactory<>("order_date"));
        delivery_date.setCellValueFactory(new PropertyValueFactory<>("delivery_date"));
        table.setItems(data);

        exit.setOnAction(event -> {
            changeScene("/CargoTransportation/MainPage.fxml", event);

        });

        update.setOnAction(event -> {
            changeScene("/CargoTransportation/Orders/Orders.fxml", event);
        });

        add.setOnAction(event -> {
            show_display("/CargoTransportation/Orders/AddOrder.fxml");
            changeScene("/CargoTransportation/Orders/Orders.fxml", event);
        });

        delete.setOnAction(event -> {
            show_display("/CargoTransportation/Orders/DeleteOrder.fxml");
            changeScene("/CargoTransportation/Orders/Orders.fxml", event);
        });
    }
}