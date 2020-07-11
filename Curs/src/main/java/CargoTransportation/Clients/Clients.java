package CargoTransportation.Clients;

public class Clients {
    private int id;
    private String full_name;
    private String phone_number;
    private String address;


    public Clients(int id, String full_name, String phone_number, String address) {
        this.id = id;
        this.full_name = full_name;
        this.phone_number = phone_number;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getFull_name() {
        return full_name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public String getAddress() {
        return address;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
