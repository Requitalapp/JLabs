package CargoTransportation.Drivers;

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


public class DriversController implements Initializable {
    ResultSet rs = null;
    Statement st = null;

    @FXML
    private TableView<Drivers> table;

    @FXML
    private TableColumn<Drivers, Integer> id;

    @FXML
    private TableColumn<Drivers, String> full_name;

    @FXML
    private TableColumn<Drivers, String> phone_number;

    @FXML
    private TableColumn<Drivers, String> license;

    @FXML
    private TableColumn<Drivers, Integer> vehicle_id;


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
        String query = "SELECT * FROM " + Const.DRIVERS_TABLE;
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
        Drivers drivers;
        try {
            while (rs.next()) {
                int id = rs.getInt(Const.DRIVERS_ID);
                String full_name = rs.getString(Const.DRIVERS_FULL_NAME);
                String phone_number = rs.getString(Const.DRIVERS_PHONE_NUMBER);
                String license = rs.getString(Const.DRIVERS_LICENSE);
                int vehicleId = rs.getInt(Const.DRIVERS_VEHICLE_ID);
                drivers = new Drivers(id, full_name, phone_number, license, vehicleId);
                data.add(drivers);
            }
            st.close();
        } catch (Exception e) {
            System.out.println("There is an Exception.");
            System.out.println(e.getMessage());
        }
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        full_name.setCellValueFactory(new PropertyValueFactory<>("full_name"));
        phone_number.setCellValueFactory(new PropertyValueFactory<>("phone_number"));
        license.setCellValueFactory(new PropertyValueFactory<>("license"));
        vehicle_id.setCellValueFactory(new PropertyValueFactory<>("vehicle_id"));
        table.setItems(data);

        exit.setOnAction(event -> {
            changeScene("/CargoTransportation/MainPage.fxml", event);

        });

        update.setOnAction(event -> {
            changeScene("/CargoTransportation/Drivers/Drivers.fxml", event);
        });

        add.setOnAction(event -> {
            show_display("/CargoTransportation/Drivers/AddDriver.fxml");
            changeScene("/CargoTransportation/Drivers/Drivers.fxml", event);
        });

        delete.setOnAction(event -> {
            show_display("/CargoTransportation/Drivers/DeleteDriver.fxml");
            changeScene("/CargoTransportation/Drivers/Drivers.fxml", event);
        });

    }
}