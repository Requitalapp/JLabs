package CargoTransportation;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import static CargoTransportation.AddCargoController.isNumeric;
import static CargoTransportation.Configs.ConnectDB;

public class Req3Controller implements Initializable {
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
    private TableColumn<Routes, Integer> distance;


    @FXML
    private Button exit;

    @FXML
    private TextArea message;

    @FXML
    private TextField start_point_t;

    @FXML
    private Button find;

    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        Configs dbHandler = new Configs();
        find.setOnAction(even -> {
            String start_point_ = start_point_t.getText().trim();
            if (!start_point_.equals("")) {
                message.setText("Found!");

                final ObservableList data = FXCollections.observableArrayList();
                String query = "SELECT id, start_point, end_point, distance FROM   cargotransportation.routes WHERE start_point = '" + start_point_ + "'";
                Statement st = null;
                try {
                    st = ConnectDB().createStatement();
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
                        Integer id = rs.getInt("id");
                        String start_point = rs.getString("start_point");
                        String end_point = rs.getString("end_point");
                        Float distance = rs.getFloat("distance");
                        routes = new Routes(id, start_point, end_point, distance);
                        data.add(routes);
                    }
                    st.close();
                } catch (Exception e) {
                    System.out.println("Error.");
                    System.out.println(e.getMessage());
                }
                id.setCellValueFactory(new PropertyValueFactory<>("id"));
                start_point.setCellValueFactory(new PropertyValueFactory<>("start_point"));
                end_point.setCellValueFactory(new PropertyValueFactory<>("end_point"));
                distance.setCellValueFactory(new PropertyValueFactory<>("distance"));

                table.setItems(data);
            } else message.setText("Enter another start_point!");

        });

        exit.setOnAction(event -> {
            Stage stage = (Stage) ((javafx.scene.control.Button) event.getSource()).getScene().getWindow();
            stage.close();
        });
    }
}