package CargoTransportation.Cargo;

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
            Stage stage = (Stage) ((javafx.scene.control.Button) event.getSource()).getScene().getWindow();
            stage.close();
        });

        update.setOnAction(event -> {
            show_display("/CargoTransportation/Cargo/Cargo.fxml");
            update.getScene().getWindow().hide();
        });

        add.setOnAction(event -> {
            show_display("/CargoTransportation/Cargo/AddCargo.fxml");
        });

        delete.setOnAction(event -> {
            show_display("/CargoTransportation/Cargo/DeleteCargo.fxml");
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