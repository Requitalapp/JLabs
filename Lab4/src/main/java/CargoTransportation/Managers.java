package CargoTransportation;

public class Managers {
    private int id;
    private String full_name;
    private String phone_number;

    public Managers(int id, String full_name, String phone_number) {
        this.id = id;
        this.full_name = full_name;
        this.phone_number = phone_number;
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

    public void setId(int id) {
        this.id = id;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }
}
