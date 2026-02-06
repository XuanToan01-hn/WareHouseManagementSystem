package model;

import java.sql.Date;

public class CheckInventory {
    private int checkID;
    private String checkCode;
    private int locationID;
    private Date checkDate;
    private String status;
    private int createBy;

    public CheckInventory() {
    }

    public CheckInventory(int checkID, String checkCode, int locationID, Date checkDate, String status, int createBy) {
        this.checkID = checkID;
        this.checkCode = checkCode;
        this.locationID = locationID;
        this.checkDate = checkDate;
        this.status = status;
        this.createBy = createBy;
    }

    public int getCheckID() {
        return checkID;
    }

    public void setCheckID(int checkID) {
        this.checkID = checkID;
    }

    public String getCheckCode() {
        return checkCode;
    }

    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode;
    }

    public int getLocationID() {
        return locationID;
    }

    public void setLocationID(int locationID) {
        this.locationID = locationID;
    }

    public Date getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(Date checkDate) {
        this.checkDate = checkDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCreateBy() {
        return createBy;
    }

    public void setCreateBy(int createBy) {
        this.createBy = createBy;
    }
}

