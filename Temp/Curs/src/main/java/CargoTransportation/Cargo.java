package CargoTransportation;

public class Cargo {
    private int id;
    private String type;
    private Float cost;
    private Float volume;
    private Float weight;


    public Cargo(int id, String type, Float cost, Float volume, Float weight) {
        this.id = id;
        this.type = type;
        this.cost = cost;
        this.volume = volume;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public Float getCost() {
        return cost;
    }

    public Float getVolume() {
        return volume;
    }

    public Float getWeight() {
        return weight;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCost(Float cost) {
        this.cost = cost;
    }

    public void setVolume(Float volume) {
        this.volume = volume;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }
}
