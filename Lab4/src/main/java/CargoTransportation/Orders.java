package CargoTransportation;

public class Orders {
    private int id;
    private int manager_id;
    private int client_id;
    private int route_id;
    private int driver_id;
    private int cargo_id;
    private String order_date;
    private String delivery_date;

    public Orders(int id, int manager_id, int client_id, int route_id, int driver_id, int cargo_id, String order_date, String delivery_date) {
        this.id = id;
        this.manager_id = manager_id;
        this.client_id = client_id;
        this.route_id = route_id;
        this.driver_id = driver_id;
        this.cargo_id = cargo_id;
        this.order_date = order_date;
        this.delivery_date = delivery_date;
    }

    public int getId() {
        return id;
    }

    public int getManager_id() {
        return manager_id;
    }

    public int getClient_id() {
        return client_id;
    }

    public int getRoute_id() {
        return route_id;
    }

    public int getDriver_id() {
        return driver_id;
    }

    public int getCargo_id() {
        return cargo_id;
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

    public void setManager_id(int manager_id) {
        this.manager_id = manager_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public void setRoute_id(int route_id) {
        this.route_id = route_id;
    }

    public void setDriver_id(int driver_id) {
        this.driver_id = driver_id;
    }

    public void setCargo_id(int cargo_id) {
        this.cargo_id = cargo_id;
    }

    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }

    public void setDelivery_date(String delivery_date) {
        this.delivery_date = delivery_date;
    }
}
