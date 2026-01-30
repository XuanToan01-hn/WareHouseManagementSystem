package model;

public class Unit {
    private int unitID;
    private String name;
    private String type;

    public Unit(int unitID, String name, String type) {
        this.unitID = unitID;
        this.name = name;
        this.type = type;
    }

    public Unit() {
    }

    public int getUnitID() {
        return unitID;
    }

    public void setUnitID(int unitID) {
        this.unitID = unitID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}