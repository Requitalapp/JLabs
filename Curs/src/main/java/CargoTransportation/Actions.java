package CargoTransportation;

import java.sql.*;

public class Actions {

    public void AddCargo(String type, String cost, String volume, String weight) throws SQLException {
        String insert = "INSERT INTO `CargoTransportation`.`Cargo` (`type`, `cost`, `volume`, `weight`) VALUES (?,?,?,?)";
        PreparedStatement prSt = ConnectionToDB.getConnection().prepareStatement(insert);
        prSt.setString(1, type);
        prSt.setString(2, cost);
        prSt.setString(3, volume);
        prSt.setString(4, weight);
        prSt.executeUpdate();

    }

    public void AddClients(String fullName, String phoneNumber, String address) throws SQLException {
        String insert = "INSERT INTO `CargoTransportation`.`Clients` (`full_name`, `phone_number`, `address`) VALUES (?,?,?)";
        PreparedStatement prSt = ConnectionToDB.getConnection().prepareStatement(insert);
        prSt.setString(1, fullName);
        prSt.setString(2, phoneNumber);
        prSt.setString(3, address);
        prSt.executeUpdate();
    }

    public void AddManager(String fullName, String phoneNumber) throws SQLException {
        String insert = "INSERT INTO `CargoTransportation`.`Managers` (`full_name`, `phone_number`) VALUES (?,?)";
        PreparedStatement prSt = ConnectionToDB.getConnection().prepareStatement(insert);
        prSt.setString(1, fullName);
        prSt.setString(2, phoneNumber);
        prSt.executeUpdate();

    }

    public void AddRoute(String startPoint, String endPoint, String distance) throws SQLException {
        String insert = "INSERT INTO `CargoTransportation`.`Routes` (`start_point`, `end_point`, `distance`) VALUES (?,?,?)";
        PreparedStatement prSt = ConnectionToDB.getConnection().prepareStatement(insert);
        prSt.setString(1, startPoint);
        prSt.setString(2, endPoint);
        prSt.setString(3, distance);
        prSt.executeUpdate();

    }

    public void AddVehicle(String licensePlate, String model, String fuelConsumption, String carrying, String wagonVolume) throws SQLException {
        String insert = "INSERT INTO `CargoTransportation`.`Vehicles` (`license_plate`, `model`, `fuel_consumption`, `carrying`, `wagon_volume`) VALUES (?,?,?,?,?)";
        PreparedStatement prSt = ConnectionToDB.getConnection().prepareStatement(insert);
        prSt.setString(1, licensePlate);
        prSt.setString(2, model);
        prSt.setString(3, fuelConsumption);
        prSt.setString(4, carrying);
        prSt.setString(5, wagonVolume);
        prSt.executeUpdate();

    }

    public void AddDriver(String fullName, String license, String phoneNumber, String vehicleId) throws SQLException {
        String insert = "INSERT INTO `CargoTransportation`.`Drivers` (`full_name`, `license`, `phone_number`, `vehicle_id`) VALUES (?,?,?,?)";
        PreparedStatement prSt = ConnectionToDB.getConnection().prepareStatement(insert);
        prSt.setString(1, fullName);
        prSt.setString(2, license);
        prSt.setString(3, phoneNumber);
        prSt.setString(4, vehicleId);
        prSt.executeUpdate();

    }

    public void AddOrder(String managerId, String clientId, String routeId, String driverId, String cargoId, String orderDate, String deliveryDate) throws SQLException {
        String insert = "INSERT INTO `CargoTransportation`.`Orders` (`manager_id`, `client_id`, `route_id`, `driver_id`, `cargo_id`, `order_date`, `delivery_date`) VALUES (?,?,?,?,?,?,?)";
        PreparedStatement prSt = ConnectionToDB.getConnection().prepareStatement(insert);
        prSt.setString(1, managerId);
        prSt.setString(2, clientId);
        prSt.setString(3, routeId);
        prSt.setString(4, driverId);
        prSt.setString(5, cargoId);
        prSt.setString(6, orderDate);
        prSt.setString(7, deliveryDate);
        prSt.executeUpdate();

    }


    public static void Del(String table, String id) throws SQLException {
        PreparedStatement del = null;
        del = ConnectionToDB.getConnection().prepareStatement("DELETE FROM " + table + " WHERE (id) = ?");
        del.setString(1, id);
        del.execute();
    }
}
