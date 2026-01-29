package model;

import java.sql.Timestamp;

public class TransferOrder {
    private int transferOrderID;
    private String transferCode;
    private int fromLocationID;
    private int toLocationID;
    private Timestamp transferDate;
    private int status;
    private String note;
    private int createBy;

    public TransferOrder() {
    }

    public TransferOrder(int transferOrderID, String transferCode, int fromLocationID, int toLocationID, Timestamp transferDate, int status, String note, int createBy) {
        this.transferOrderID = transferOrderID;
        this.transferCode = transferCode;
        this.fromLocationID = fromLocationID;
        this.toLocationID = toLocationID;
        this.transferDate = transferDate;
        this.status = status;
        this.note = note;
        this.createBy = createBy;
    }

    public int getTransferOrderID() {
        return transferOrderID;
    }

    public void setTransferOrderID(int transferOrderID) {
        this.transferOrderID = transferOrderID;
    }

    public String getTransferCode() {
        return transferCode;
    }

    public void setTransferCode(String transferCode) {
        this.transferCode = transferCode;
    }

    public int getFromLocationID() {
        return fromLocationID;
    }

    public void setFromLocationID(int fromLocationID) {
        this.fromLocationID = fromLocationID;
    }

    public int getToLocationID() {
        return toLocationID;
    }

    public void setToLocationID(int toLocationID) {
        this.toLocationID = toLocationID;
    }

    public Timestamp getTransferDate() {
        return transferDate;
    }

    public void setTransferDate(Timestamp transferDate) {
        this.transferDate = transferDate;
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

