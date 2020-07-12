package CargoTransportation.Routes;

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


public class RoutesController implements Initializable {
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
        final ObservableList data = FXCollections.observableArrayList();
        String query = "SELECT * FROM " + Const.ROUTES_TABLE;
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
        Routes routes;
        try {
            while (rs.next()) {
                int id = rs.getInt(Const.ROUTES_ID);
                String start_point = rs.getString(Const.ROUTES_START_POINT);
                String end_point = rs.getString(Const.ROUTES_END_POINT);
                Float distance = rs.getFloat(Const.ROUTES_DISTANCE);
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
            changeScene("/CargoTransportation/MainPage.fxml", event);
        });

        update.setOnAction(event -> {
            changeScene("/CargoTransportation/Routes/Routes.fxml", event);
        });

        add.setOnAction(event -> {
            show_display("/CargoTransportation/Routes/AddRoute.fxml");
            changeScene("/CargoTransportation/Routes/Routes.fxml", event);
        });

        delete.setOnAction(event -> {
            show_display("/CargoTransportation/Routes/DeleteRoute.fxml");
            changeScene("/CargoTransportation/Routes/Routes.fxml", event);
        });
    }
}