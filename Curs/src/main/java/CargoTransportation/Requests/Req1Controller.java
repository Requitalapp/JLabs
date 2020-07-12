package CargoTransportation.Requests;

import CargoTransportation.ConnectionToDB;
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

public class Req1Controller implements Initializable {
    ResultSet rs = null;
    Statement st = null;

    @FXML
    private TableView<Req1Table> table;

    @FXML
    private TableColumn<Req1Table, String> cargo;

    @FXML
    private TableColumn<Req1Table, String> manager;

    @FXML
    private TableColumn<Req1Table, String> driver;

    @FXML
    private TableColumn<Req1Table, String> start_point;

    @FXML
    private TableColumn<Req1Table, String> end_point;

    @FXML
    private TableColumn<Req1Table, String> order_date;

    @FXML
    private TableColumn<Req1Table, String> delivery_date;


    @FXML
    private Button exit;

    @FXML
    private TextArea message;

    @FXML
    private TextField client;

    @FXML
    private Button find;

    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        find.setOnAction(even -> {
            String client_ = client.getText().trim();

            if (!client_.equals("")) {
                try {
                    st = ConnectionToDB.getConnection().createStatement();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                String existanceCheckQuery = "SELECT id FROM cargotransportation.clients WHERE full_name = '" + client_ + "'";

                String query = "SELECT c.type, m.full_name, d.full_name, r.start_point, r.end_point,  o.order_date, o.delivery_date " +
                        "FROM cargotransportation.cargo as c, cargotransportation.managers as m, cargotransportation.drivers as d, " +
                        "cargotransportation.routes as r, cargotransportation.orders as o, cargotransportation.clients as cl " +
                        "WHERE o.cargo_id = c.id and o.manager_id = m.id and o.driver_id = d.id and o.route_id = r.id and cl.id = o.client_id and cl.full_name = '" + client_ + "'";

                try {
                    rs = st.executeQuery(existanceCheckQuery);
                    if (rs.next() == false) {
                        message.setText("Client not found!");
                        return;
                    }
                    rs = st.executeQuery(query);
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                final ObservableList data = FXCollections.observableArrayList();
                Req1Table req1;
                try {
                    if (rs.next() == false) {
                        message.setText("Client has no orders!");
                        return;
                    } else {
                        message.setText("Found!");
                    }
                    do {
                        String cargo = rs.getString("c.type");
                        String manager = rs.getString("m.full_name");
                        String driver = rs.getString("d.full_name");
                        String start_point = rs.getString("r.start_point");
                        String end_point = rs.getString("r.end_point");
                        String order_date = rs.getString("o.order_date");
                        String delivery_date = rs.getString("o.delivery_date");
                        req1 = new Req1Table(cargo, manager, driver, start_point, end_point, order_date, delivery_date);
                        data.add(req1);
                    } while (rs.next());
                    st.close();
                } catch (Exception e) {
                    System.out.println("Error.");
                    System.out.println(e.getMessage());
                }
                cargo.setCellValueFactory(new PropertyValueFactory<>("cargo"));
                manager.setCellValueFactory(new PropertyValueFactory<>("manager"));
                driver.setCellValueFactory(new PropertyValueFactory<>("driver"));
                start_point.setCellValueFactory(new PropertyValueFactory<>("start_point"));
                end_point.setCellValueFactory(new PropertyValueFactory<>("end_point"));
                order_date.setCellValueFactory(new PropertyValueFactory<>("order_date"));
                delivery_date.setCellValueFactory(new PropertyValueFactory<>("delivery_date"));
                table.setItems(data);
            } else message.setText("Enter another client!");

        });

        exit.setOnAction(event -> {
            changeScene("/CargoTransportation/Requests/Requests.fxml", event);
        });
    }
}