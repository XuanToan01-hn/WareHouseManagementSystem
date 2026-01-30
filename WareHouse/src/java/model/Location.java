package model;

public class Location {
    private int locationID;
    private String name;
    private String address;
    private String description;
    private Integer parentLocationID; // Nullable
    private String locationType; // ENUM: WAREHOUSE, ZONE, RACK, BIN
    private Integer maxCapacity; // Nullable

    public Location(int locationID, String name, String address, String description, Integer parentLocationID, String locationType, Integer maxCapacity) {
        this.locationID = locationID;
        this.name = name;
        this.address = address;
        this.description = description;
        this.parentLocationID = parentLocationID;
        this.locationType = locationType;
        this.maxCapacity = maxCapacity;
    }

    public Location() {
    }

    public int getLocationID() {
        return locationID;
    }

    public void setLocationID(int locationID) {
        this.locationID = locationID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getParentLocationID() {
        return parentLocationID;
    }

    public void setParentLocationID(Integer parentLocationID) {
        this.parentLocationID = parentLocationID;
    }

    public String getLocationType() {
        return locationType;
    }

    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }

    public Integer getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(Integer maxCapacity) {
        this.maxCapacity = maxCapacity;
    }
}