module Curs {
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.fxml;
    requires java.sql;

    opens CargoTransportation;
    opens CargoTransportation.Cargo;
    opens CargoTransportation.Clients;
    opens CargoTransportation.Drivers;
    opens CargoTransportation.Managers;
    opens CargoTransportation.Orders;
    opens CargoTransportation.Routes;
    opens CargoTransportation.Vehicles;
    opens CargoTransportation.Requests;

}