package CargoTransportation.Vehicles;

import CargoTransportation.ConnectionToDB;
import CargoTransportation.Const;
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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;



public class VehiclesController implements Initializable {
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
        String query = "SELECT * FROM " + Const.VEHICLES_TABLE;
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
        Vehicles vehicles;
        try {
            while (rs.next()) {
                int id = rs.getInt(Const.VEHICLES_ID);
                String license_plate = rs.getString(Const.VEHICLES_LICENSE_PLATE);
                String model = rs.getString(Const.VEHICLES_MODEL);
                Float fuel_consumption = rs.getFloat(Const.VEHICLES_FUEL_CONSUMPTION);
                Float carrying = rs.getFloat(Const.VEHICLES_CARRYING);
                Float wagon_volume = rs.getFloat(Const.VEHICLES_WAGON_VOLUME);
                vehicles = new Vehicles(id, license_plate, model, fuel_consumption, carrying, wagon_volume);
                data.add(vehicles);
            }
            st.close();
        } catch (Exception e) {
            System.out.println("There is an Exception.");
            System.out.println(e.getMessage());
        }
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        license_plate.setCellValueFactory(new PropertyValueFactory<>("license_plate"));
        model.setCellValueFactory(new PropertyValueFactory<>("model"));
        fuel_consumption.setCellValueFactory(new PropertyValueFactory<>("fuel_consumption"));
        carrying.setCellValueFactory(new PropertyValueFactory<>("carrying"));
        wagon_volume.setCellValueFactory(new PropertyValueFactory<>("wagon_volume"));
        table.setItems(data);

        exit.setOnAction(event -> {
            Stage stage = (Stage) ((javafx.scene.control.Button) event.getSource()).getScene().getWindow();
            stage.close();
        });

        update.setOnAction(event -> {
            show_display("/CargoTransportation/Vehicles/Vehicles.fxml");
            update.getScene().getWindow().hide();
        });

        add.setOnAction(event -> {
            show_display("/CargoTransportation/Vehicles/AddVehicle.fxml");
        });

        delete.setOnAction(event -> {
            show_display("/CargoTransportation/Vehicles/DeleteVehicle.fxml");
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