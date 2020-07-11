package CargoTransportation.Requests;

public class Req2Table {
    private String cargo;
    private String client;
    private String driver;
    private String start_point;
    private String end_point;
    private String order_date;
    private String delivery_date;

    public Req2Table(String cargo, String client, String driver, String start_point, String end_point, String order_date, String delivery_date) {
        this.cargo = cargo;
        this.client = client;
        this.driver = driver;
        this.start_point = start_point;
        this.end_point = end_point;
        this.order_date = order_date;
        this.delivery_date = delivery_date;
    }

    public String getCargo() {
        return cargo;
    }

    public String getClient() {
        return client;
    }

    public String getDriver() {
        return driver;
    }

    public String getStart_point() {
        return start_point;
    }

    public String getEnd_point() {
        return end_point;
    }

    public String getOrder_date() {
        return order_date;
    }

    public String getDelivery_date() {
        return delivery_date;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public void setStart_point(String start_point) {
        this.start_point = start_point;
    }

    public void setEnd_point(String end_point) {
        this.end_point = end_point;
    }

    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }

    public void setDelivery_date(String delivery_date) {
        this.delivery_date = delivery_date;
    }
}
