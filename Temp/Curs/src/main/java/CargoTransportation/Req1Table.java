package CargoTransportation;

public class Req1Table {
    private String cargo;
    private String manager;
    private String driver;
    private String start_point;
    private String end_point;
    private String order_date;
    private String delivery_date;

    public Req1Table(String cargo, String manager, String driver, String start_point, String end_point, String order_date, String delivery_date) {
        this.cargo = cargo;
        this.manager = manager;
        this.driver = driver;
        this.start_point = start_point;
        this.end_point = end_point;
        this.order_date = order_date;
        this.delivery_date = delivery_date;
    }

    public String getCargo() {
        return cargo;
    }

    public String getManager() {
        return manager;
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

    public void setManager(String manager) {
        this.manager = manager;
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
