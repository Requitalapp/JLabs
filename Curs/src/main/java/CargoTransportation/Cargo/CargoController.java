package CargoTransportation.Cargo;

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


public class CargoController implements Initializable {
    ResultSet rs = null;
    Statement st = null;

    @FXML
    private TableView<Cargo> table;

    @FXML
    private TableColumn<Cargo, Integer> id;

    @FXML
    private TableColumn<Cargo, String> type;

    @FXML
    private TableColumn<Cargo, Float> cost;

    @FXML
    private TableColumn<Cargo, Float> volume;

    @FXML
    private TableColumn<Cargo, Float> weight;

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
        String query = "SELECT * FROM " + Const.CARGO_TABLE;
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
        Cargo cargo;
        try {
            while (rs.next()) {
                int id = rs.getInt(Const.CARGO_ID);
                String type = rs.getString(Const.CARGO_TYPE);
                Float cost = rs.getFloat(Const.CARGO_COST);
                Float volume = rs.getFloat(Const.CARGO_VOLUME);
                Float weight = rs.getFloat(Const.CARGO_WEIGHT);
                cargo = new Cargo(id, type, cost, volume, weight);
                data.add(cargo);
            }
            st.close();
        } catch (Exception e) {
            System.out.println("There is an Exception.");
            System.out.println(e.getMessage());
        }
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        type.setCellValueFactory(new PropertyValueFactory<>("type"));
        cost.setCellValueFactory(new PropertyValueFactory<>("cost"));
        volume.setCellValueFactory(new PropertyValueFactory<>("volume"));
        weight.setCellValueFactory(new PropertyValueFactory<>("weight"));
        table.setItems(data);

        exit.setOnAction(event -> {
            changeScene("/CargoTransportation/MainPage.fxml", event);
        });

        update.setOnAction(event -> {
            changeScene("/CargoTransportation/Cargo/Cargo.fxml", event);
        });

        add.setOnAction(event -> {
            show_display("/CargoTransportation/Cargo/AddCargo.fxml");
            changeScene("/CargoTransportation/Cargo/Cargo.fxml", event);
        });

        delete.setOnAction(event -> {
            show_display("/CargoTransportation/Cargo/DeleteCargo.fxml");
            changeScene("/CargoTransportation/Cargo/Cargo.fxml", event);
        });

    }
}