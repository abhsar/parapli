package se.digiport.device;

public class Device {
    private String id;
    private String name;
    private String model;
    private String manufacturer;
    private String type;
    private int powerOutputKw;
    private Location location;

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPowerOutputKw() {
        return powerOutputKw;
    }

    public void setPowerOutputKw(int powerOutputKw) {
        this.powerOutputKw = powerOutputKw;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
