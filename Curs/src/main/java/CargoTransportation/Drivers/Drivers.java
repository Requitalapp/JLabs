package CargoTransportation.Drivers;

public class Drivers {
    private int id;
    private String full_name;
    private String license;
    private String phone_number;
    private int vehicle_id;

    public Drivers(int id, String full_name, String license, String phone_number, int vehicle_id) {
        this.id = id;
        this.full_name = full_name;
        this.license = license;
        this.phone_number = phone_number;
        this.vehicle_id = vehicle_id;
    }

    public int getId() {
        return id;
    }

    public String getFull_name() {
        return full_name;
    }

    public String getLicense() {
        return license;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public int getVehicle_id() {
        return vehicle_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public void setVehicle_id(int vehicle_id) {
        this.vehicle_id = vehicle_id;
    }
}
