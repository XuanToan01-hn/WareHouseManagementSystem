package model;

import java.sql.Timestamp;

public class GoodIssue {
    private int issueID;
    private String issueCode;
    private Integer salesOrderID; // nullable
    private int locationID;
    private Timestamp issueDate;
    private int status;
    private String note;
    private int createBy;

    public GoodIssue() {
    }

    public GoodIssue(int issueID, String issueCode, Integer salesOrderID, int locationID, Timestamp issueDate, int status, String note, int createBy) {
        this.issueID = issueID;
        this.issueCode = issueCode;
        this.salesOrderID = salesOrderID;
        this.locationID = locationID;
        this.issueDate = issueDate;
        this.status = status;
        this.note = note;
        this.createBy = createBy;
    }

    public int getIssueID() {
        return issueID;
    }

    public void setIssueID(int issueID) {
        this.issueID = issueID;
    }

    public String getIssueCode() {
        return issueCode;
    }

    public void setIssueCode(String issueCode) {
        this.issueCode = issueCode;
    }

    public Integer getSalesOrderID() {
        return salesOrderID;
    }

    public void setSalesOrderID(Integer salesOrderID) {
        this.salesOrderID = salesOrderID;
    }

    public int getLocationID() {
        return locationID;
    }

    public void setLocationID(int locationID) {
        this.locationID = locationID;
    }

    public Timestamp getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Timestamp issueDate) {
        this.issueDate = issueDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getCreateBy() {
        return createBy;
    }

    public void setCreateBy(int createBy) {
        this.createBy = createBy;
    }
}
