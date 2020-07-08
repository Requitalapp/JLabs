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



public class RoutesController implements Initializable {
    Connection conn = null;
    ResultSet rs = null;
    Statement st = null;

    @FXML
    private TableView<Routes> table;

    @FXML
    private TableColumn<Routes, Integer> id;

    @FXML
    private TableColumn<Routes, String> start_point;

    @FXML
    private TableColumn<Routes, String> end_point;

    @FXML
    private TableColumn<Routes, Float> distance;

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
        String query = "SELECT * FROM cargotransportation.routes";
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
        Routes routes;
        try {
            while (rs.next()) {
                int id = rs.getInt("id");
                String start_point = rs.getString("start_point");
                String end_point = rs.getString("end_point");
                Float distance = rs.getFloat("distance");
                routes = new Routes(id, start_point, end_point, distance);
                data.add(routes);
            }
            st.close();
        } catch (Exception e) {
            System.out.println("There is an Exception.");
            System.out.println(e.getMessage());
        }
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        start_point.setCellValueFactory(new PropertyValueFactory<>("start_point"));
        end_point.setCellValueFactory(new PropertyValueFactory<>("end_point"));
        distance.setCellValueFactory(new PropertyValueFactory<>("distance"));
        table.setItems(data);

        exit.setOnAction(event -> {
            Stage stage = (Stage) ((javafx.scene.control.Button) event.getSource()).getScene().getWindow();
            stage.close();
        });

        update.setOnAction(event -> {
            show_display("/CargoTransportation/Routes.fxml");
            update.getScene().getWindow().hide();
        });

        add.setOnAction(event -> {
            show_display("/CargoTransportation/AddRoute.fxml");
        });

        delete.setOnAction(event -> {
            show_display("/CargoTransportation/DeleteRoute.fxml");
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