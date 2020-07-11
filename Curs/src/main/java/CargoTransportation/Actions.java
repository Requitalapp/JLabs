package CargoTransportation;

import java.sql.*;

public class Actions {

    public void AddCargo(String type, String cost, String volume, String weight) throws SQLException {
        String insert = "INSERT INTO " + Const.CARGO_TABLE + " (" + Const.CARGO_TYPE + ", " + Const.CARGO_COST + ", "
                + Const.CARGO_VOLUME + ", " + Const.CARGO_WEIGHT + ") VALUES (?,?,?,?)";
        PreparedStatement prSt = ConnectionToDB.getConnection().prepareStatement(insert);
        prSt.setString(1, type);
        prSt.setString(2, cost);
        prSt.setString(3, volume);
        prSt.setString(4, weight);
        prSt.executeUpdate();

    }

    public void AddClients(String fullName, String phoneNumber, String address) throws SQLException {
        String insert = "INSERT INTO " + Const.CLIENTS_TABLE + " (" + Const.CLIENTS_FULL_NAME + ", " + Const.CLIENTS_PHONE_NUMBER + ", "
                + Const.CLIENTS_ADDRESS + ") VALUES (?,?,?)";
        PreparedStatement prSt = ConnectionToDB.getConnection().prepareStatement(insert);
        prSt.setString(1, fullName);
        prSt.setString(2, phoneNumber);
        prSt.setString(3, address);
        prSt.executeUpdate();
    }

    public void AddManager(String fullName, String phoneNumber) throws SQLException {
        String insert = "INSERT INTO " + Const.MANAGERS_TABLE + " (" + Const.MANAGERS_FULL_NAME + ", " + Const.MANAGERS_PHONE_NUMBER + ") VALUES (?,?)";
        PreparedStatement prSt = ConnectionToDB.getConnection().prepareStatement(insert);
        prSt.setString(1, fullName);
        prSt.setString(2, phoneNumber);
        prSt.executeUpdate();

    }

    public void AddRoute(String startPoint, String endPoint, String distance) throws SQLException {
        String insert = "INSERT INTO " + Const.ROUTES_TABLE + " (" + Const.ROUTES_START_POINT + ", " + Const.ROUTES_END_POINT + ", "
                + Const.ROUTES_DISTANCE + ") VALUES (?,?,?)";
        PreparedStatement prSt = ConnectionToDB.getConnection().prepareStatement(insert);
        prSt.setString(1, startPoint);
        prSt.setString(2, endPoint);
        prSt.setString(3, distance);
        prSt.executeUpdate();

    }

    public void AddVehicle(String licensePlate, String model, String fuelConsumption, String carrying, String wagonVolume) throws SQLException {
        String insert = "INSERT INTO " + Const.VEHICLES_TABLE + " (" + Const.VEHICLES_LICENSE_PLATE + ", " + Const.VEHICLES_MODEL + ", "
                + Const.VEHICLES_FUEL_CONSUMPTION + ", " + Const.VEHICLES_CARRYING + ", " + Const.VEHICLES_WAGON_VOLUME + ") VALUES (?,?,?,?,?)";
        PreparedStatement prSt = ConnectionToDB.getConnection().prepareStatement(insert);
        prSt.setString(1, licensePlate);
        prSt.setString(2, model);
        prSt.setString(3, fuelConsumption);
        prSt.setString(4, carrying);
        prSt.setString(5, wagonVolume);
        prSt.executeUpdate();

    }

    public void AddDriver(String fullName, String license, String phoneNumber, String vehicleId) throws SQLException {
        String insert = "INSERT INTO " + Const.DRIVERS_TABLE + " (" + Const.DRIVERS_FULL_NAME + ", " + Const.DRIVERS_LICENSE + ", "
                + Const.DRIVERS_PHONE_NUMBER + ", " + Const.DRIVERS_VEHICLE_ID + ") VALUES (?,?,?,?)";
        PreparedStatement prSt = ConnectionToDB.getConnection().prepareStatement(insert);
        prSt.setString(1, fullName);
        prSt.setString(2, license);
        prSt.setString(3, phoneNumber);
        prSt.setString(4, vehicleId);
        prSt.executeUpdate();

    }

    public void AddOrder(String managerId, String clientId, String routeId, String driverId, String cargoId, String orderDate, String deliveryDate) throws SQLException {
        String insert = "INSERT INTO " + Const.ORDERS_TABLE + " (" + Const.ORDERS_MANAGER_ID + ", " + Const.ORDERS_CLIENT_ID +", "
                + Const.ORDERS_ROUTE_ID +", " + Const.ORDERS_DRIVER_ID +", "+ Const.ORDERS_CARGO_ID +", "+ Const.ORDERS_ORDER_DATE +", "
                + Const.ORDERS_DELIVERY_DATE +") VALUES (?,?,?,?,?,?,?)";
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
