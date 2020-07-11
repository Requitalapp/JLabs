package CargoTransportation.Vehicles;

public class Vehicles {
    private int id;
    private String license_plate;
    private String model;
    private Float fuel_consumption;
    private Float carrying;
    private Float wagon_volume;

    public Vehicles(int id, String license_plate, String model, Float fuel_consumption, Float carrying, Float wagon_volume) {
        this.id = id;
        this.license_plate = license_plate;
        this.model = model;
        this.fuel_consumption = fuel_consumption;
        this.carrying = carrying;
        this.wagon_volume = wagon_volume;
    }

    public int getId() {
        return id;
    }

    public String getLicense_plate() {
        return license_plate;
    }

    public String getModel() {
        return model;
    }

    public Float getFuel_consumption() {
        return fuel_consumption;
    }

    public Float getCarrying() {
        return carrying;
    }

    public Float getWagon_volume() {
        return wagon_volume;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLicense_plate(String license_plate) {
        this.license_plate = license_plate;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setFuel_consumption(Float fuel_consumption) {
        this.fuel_consumption = fuel_consumption;
    }

    public void setCarrying(Float carrying) {
        this.carrying = carrying;
    }

    public void setWagon_volume(Float wagon_volume) {
        this.wagon_volume = wagon_volume;
    }
}