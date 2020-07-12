package CargoTransportation.Orders;

public class Orders {
    private int id;
    private String manager_name;
    private String client_name;
    private String route_start;
    private String route_end;
    private String driver_name;
    private String vehicle_license_plate;
    private String cargo_type;
    private String order_date;
    private String delivery_date;

    public Orders(int id, String manager_name, String client_name, String route_start, String route_end, String driver_name,
                  String vehicle_license_plate, String cargo_type, String order_date, String delivery_date) {
        this.id = id;
        this.manager_name = manager_name;
        this.client_name = client_name;
        this.route_start = route_start;
        this.route_end = route_end;
        this.driver_name = driver_name;
        this.vehicle_license_plate = vehicle_license_plate;
        this.cargo_type = cargo_type;
        this.order_date = order_date;
        this.delivery_date = delivery_date;
    }

    public int getId() {
        return id;
    }

    public String getManager_name() {
        return manager_name;
    }

    public String getClient_name() {
        return client_name;
    }

    public String getRoute_start() {
        return route_start;
    }

    public String getRoute_end() {
        return route_end;
    }

    public String getDriver_name() {
        return driver_name;
    }

    public String getVehicle_license_plate() {
        return vehicle_license_plate;
    }

    public String getCargo_type() {
        return cargo_type;
    }

    public String getOrder_date() {
        return order_date;
    }

    public String getDelivery_date() {
        return delivery_date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setManager_name(String manager_name) {
        this.manager_name = manager_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public void setRoute_start(String route_start) {
        this.route_start = route_start;
    }

    public void setRoute_end(String route_end) {
        this.route_end = route_end;
    }

    public void setDriver_name(String driver_name) {
        this.driver_name = driver_name;
    }

    public void setVehicle_license_plate(String vehicle_license_plate) {
        this.vehicle_license_plate = vehicle_license_plate;
    }

    public void setCargo_type(String cargo_type) {
        this.cargo_type = cargo_type;
    }

    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }

    public void setDelivery_date(String delivery_date) {
        this.delivery_date = delivery_date;
    }
}
