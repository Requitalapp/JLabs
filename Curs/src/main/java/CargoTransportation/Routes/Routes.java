package CargoTransportation.Routes;

public class Routes {
    private int id;
    private String start_point;
    private String end_point;
    private Float distance;

    public Routes(int id, String start_point, String end_point, Float distance) {
        this.id = id;
        this.start_point = start_point;
        this.end_point = end_point;
        this.distance = distance;
    }

    public int getId() {
        return id;
    }

    public String getStart_point() {
        return start_point;
    }

    public String getEnd_point() {
        return end_point;
    }

    public Float getDistance() {
        return distance;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStart_point(String start_point) {
        this.start_point = start_point;
    }

    public void setEnd_point(String end_point) {
        this.end_point = end_point;
    }

    public void setDistance(Float distance) {
        this.distance = distance;
    }
}
