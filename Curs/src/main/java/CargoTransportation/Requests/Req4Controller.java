package CargoTransportation.Requests;

import CargoTransportation.ConnectionToDB;
import CargoTransportation.Vehicles.Vehicles;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import static CargoTransportation.FXActions.changeScene;

public class Req4Controller implements Initializable {
    ResultSet rs = null;
    Statement st = null;

    @FXML
    private TableView<Vehicles> table;

    @FXML
    private TableColumn<Vehicles, Integer> id;

    @FXML
    private TableColumn<Vehicles, String> license_plate;

    @FXML
    private TableColumn<Vehicles, String> model;

    @FXML
    private TableColumn<Vehicles, Float> fuel_consumption;

    @FXML
    private TableColumn<Vehicles, Float> carrying;

    @FXML
    private TableColumn<Vehicles, Float> wagon_volume;


    @FXML
    private Button exit;

    @FXML
    private TextArea message;

    @FXML
    private TextField driver;

    @FXML
    private Button find;

    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        find.setOnAction(even -> {
            String driver_ = driver.getText().trim();
            if (!driver_.equals("")) {

                try {
                    st = ConnectionToDB.getConnection().createStatement();
                } catch (SQLException e) {
                    e.printStackTrace();
                }


                String query = "SELECT v.id, v.license_plate, v.model, v.fuel_consumption, v.carrying, v.wagon_volume " +
                        "FROM cargotransportation.vehicles as v, cargotransportation.drivers as d " +
                        "WHERE d.full_name = '" + driver_ + "' and v.id = d.vehicle_id";

                try {
                    rs = st.executeQuery(query);
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                final ObservableList data = FXCollections.observableArrayList();
                Vehicles vehicle;
                try {
                    if (rs.next() == false) {
                        message.setText("Driver not found!");
                        return;
                    } else {
                        message.setText("Found!");
                    }
                    do {
                        Integer id = rs.getInt("id");
                        String license_plate = rs.getString("license_plate");
                        String model = rs.getString("model");
                        Float fuel_consumption = rs.getFloat("fuel_consumption");
                        Float carrying = rs.getFloat("carrying");
                        Float wagon_volume = rs.getFloat("wagon_volume");
                        vehicle = new Vehicles(id, license_plate, model, fuel_consumption, carrying, wagon_volume);
                        data.add(vehicle);
                    } while (rs.next());
                    st.close();
                } catch (Exception e) {
                    System.out.println("Error.");
                    System.out.println(e.getMessage());
                }
                id.setCellValueFactory(new PropertyValueFactory<>("id"));
                license_plate.setCellValueFactory(new PropertyValueFactory<>("license_plate"));
                model.setCellValueFactory(new PropertyValueFactory<>("model"));
                fuel_consumption.setCellValueFactory(new PropertyValueFactory<>("fuel_consumption"));
                carrying.setCellValueFactory(new PropertyValueFactory<>("carrying"));
                wagon_volume.setCellValueFactory(new PropertyValueFactory<>("wagon_volume"));
                table.setItems(data);
            } else message.setText("Enter another manager!");

        });

        exit.setOnAction(event -> {
            changeScene("/CargoTransportation/Requests/Requests.fxml", event);
        });
    }
}