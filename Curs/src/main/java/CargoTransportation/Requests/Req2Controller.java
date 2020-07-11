package CargoTransportation.Requests;

import CargoTransportation.ConnectionToDB;
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

public class Req2Controller implements Initializable {
    ResultSet rs = null;
    Statement st = null;

    @FXML
    private TableView<Req2Table> table;

    @FXML
    private TableColumn<Req2Table, String> cargo;

    @FXML
    private TableColumn<Req2Table, String> client;

    @FXML
    private TableColumn<Req2Table, String> driver;

    @FXML
    private TableColumn<Req2Table, String> start_point;

    @FXML
    private TableColumn<Req2Table, String> end_point;

    @FXML
    private TableColumn<Req2Table, String> order_date;

    @FXML
    private TableColumn<Req2Table, String> delivery_date;


    @FXML
    private Button exit;

    @FXML
    private TextArea message;

    @FXML
    private TextField manager;

    @FXML
    private Button find;

    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        find.setOnAction(even -> {
            String manager_ = manager.getText().trim();
            if (!manager_.equals("")) {

                try {
                    st = ConnectionToDB.getConnection().createStatement();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                String existanceCheckQuery = "SELECT id FROM cargotransportation.managers WHERE full_name = '" + manager_ + "'";

                String query = "SELECT c.type, cl.full_name, d.full_name, r.start_point, r.end_point,  o.order_date, o.delivery_date " +
                        "FROM cargotransportation.cargo as c, cargotransportation.clients as cl, cargotransportation.drivers as d, " +
                        "cargotransportation.routes as r, cargotransportation.orders as o, cargotransportation.managers as m " +
                        "WHERE  o.cargo_id = c.id and m.full_name = '" + manager_ + "' and o.driver_id = d.id and o.route_id = r.id " +
                        "and o.client_id = cl.id and m.id = o.manager_id";

                try {
                    rs = st.executeQuery(existanceCheckQuery);
                    if (rs.next() == false){
                        message.setText("Manager not found!");
                        return;
                    }
                    rs = st.executeQuery(query);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                final ObservableList data = FXCollections.observableArrayList();

                Req2Table req2;
                try {
                    if (rs.next() == false){
                        message.setText("Manager has no served orders!");
                        return;
                    }else{
                        message.setText("Found!");
                    }
                    do {
                        String cargo = rs.getString("c.type");
                        String client = rs.getString("cl.full_name");
                        String driver = rs.getString("d.full_name");
                        String start_point = rs.getString("r.start_point");
                        String end_point = rs.getString("r.end_point");
                        String order_date = rs.getString("o.order_date");
                        String delivery_date = rs.getString("o.delivery_date");
                        req2 = new Req2Table(cargo, client, driver, start_point, end_point, order_date, delivery_date);
                        data.add(req2);
                    }while (rs.next());
                    st.close();
                } catch (Exception e) {
                    System.out.println("Error.");
                    System.out.println(e.getMessage());
                }
                cargo.setCellValueFactory(new PropertyValueFactory<>("cargo"));
                client.setCellValueFactory(new PropertyValueFactory<>("client"));
                driver.setCellValueFactory(new PropertyValueFactory<>("driver"));
                start_point.setCellValueFactory(new PropertyValueFactory<>("start_point"));
                end_point.setCellValueFactory(new PropertyValueFactory<>("end_point"));
                order_date.setCellValueFactory(new PropertyValueFactory<>("order_date"));
                delivery_date.setCellValueFactory(new PropertyValueFactory<>("delivery_date"));
                table.setItems(data);
            } else message.setText("Enter manager's name!");

        });

        exit.setOnAction(event -> {
            Stage stage = (Stage) ((javafx.scene.control.Button) event.getSource()).getScene().getWindow();
            stage.close();
        });
    }
}