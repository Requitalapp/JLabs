package CargoTransportation;

public class Const {
    //Cargo table
    public static final String CARGO_TABLE = "cargo";
    public static final String CARGO_ID = "id";
    public static final String CARGO_TYPE = "type";
    public static final String CARGO_COST = "cost";
    public static final String CARGO_VOLUME = "volume";
    public static final String CARGO_WEIGHT = "weight";

    //Drivers Table
    public static final String CLIENTS_TABLE = "clients";
    public static final String CLIENTS_ID = "id";
    public static final String CLIENTS_FULL_NAME = "full_name";
    public static final String CLIENTS_PHONE_NUMBER = "phone_number";
    public static final String CLIENTS_ADDRESS = "address";

    //Drivers table
    public static final String DRIVERS_TABLE = "drivers";
    public static final String DRIVERS_ID = "id";
    public static final String DRIVERS_FULL_NAME = "full_name";
    public static final String DRIVERS_LICENSE = "license";
    public static final String DRIVERS_PHONE_NUMBER = "phone_number";
    public static final String DRIVERS_VEHICLE_ID = "vehicle_id";

    //Managers table
    public static final String MANAGERS_TABLE = "managers";
    public static final String MANAGERS_ID = "id";
    public static final String MANAGERS_FULL_NAME = "full_name";
    public static final String MANAGERS_PHONE_NUMBER = "phone_number";

    //Orders table
    public static final String ORDERS_TABLE = "orders";
    public static final String ORDERS_ID = "id";
    public static final String ORDERS_MANAGER_ID = "manager_id";
    public static final String ORDERS_CLIENT_ID = "client_id";
    public static final String ORDERS_ROUTE_ID = "route_id";
    public static final String ORDERS_DRIVER_ID = "driver_id";
    public static final String ORDERS_CARGO_ID = "cargo_id";
    public static final String ORDERS_ORDER_DATE = "order_date";
    public static final String ORDERS_DELIVERY_DATE = "delivery_date";

    //Routes table
    public static final String ROUTES_TABLE = "routes";
    public static final String ROUTES_ID = "id";
    public static final String ROUTES_START_POINT = "start_point";
    public static final String ROUTES_END_POINT = "end_point";
    public static final String ROUTES_DISTANCE = "distance";

    //Vehicles table
    public static final String VEHICLES_TABLE = "vehicles";
    public static final String VEHICLES_ID = "id";
    public static final String VEHICLES_LICENSE_PLATE = "license_plate";
    public static final String VEHICLES_MODEL = "model";
    public static final String VEHICLES_FUEL_CONSUMPTION = "fuel_consumption";
    public static final String VEHICLES_CARRYING = "carrying";
    public static final String VEHICLES_WAGON_VOLUME = "wagon_volume";


}
