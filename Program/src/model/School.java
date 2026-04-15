package model;

public class School {
    private int id;
    private String name;
    private String address;

    public School() {}

    public School(int id, String name, String address) {
        setId(id);
        setName(name);
        setAddress(address);
    }
    public void setName(String name) {
        if(name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name of school can`t be null or empty");
        }
        this.name = name;
    }
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

}
