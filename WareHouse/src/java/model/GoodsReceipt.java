package model;

import java.sql.Timestamp;

public class GoodsReceipt {
    private int receiptID;
    private String receiptCode;
    private Integer purchaseOrderID; // nullable
    private int locationID;
    private Timestamp receiptDate;
    private int status;
    private String note;
    private int createBy;

    public GoodsReceipt() {
    }

    public GoodsReceipt(int receiptID, String receiptCode, Integer purchaseOrderID, int locationID, Timestamp receiptDate, int status, String note, int createBy) {
        this.receiptID = receiptID;
        this.receiptCode = receiptCode;
        this.purchaseOrderID = purchaseOrderID;
        this.locationID = locationID;
        this.receiptDate = receiptDate;
        this.status = status;
        this.note = note;
        this.createBy = createBy;
    }

    public int getReceiptID() {
        return receiptID;
    }

    public void setReceiptID(int receiptID) {
        this.receiptID = receiptID;
    }

    public String getReceiptCode() {
        return receiptCode;
    }

    public void setReceiptCode(String receiptCode) {
        this.receiptCode = receiptCode;
    }

    public Integer getPurchaseOrderID() {
        return purchaseOrderID;
    }

    public void setPurchaseOrderID(Integer purchaseOrderID) {
        this.purchaseOrderID = purchaseOrderID;
    }

    public int getLocationID() {
        return locationID;
    }

    public void setLocationID(int locationID) {
        this.locationID = locationID;
    }

    public Timestamp getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(Timestamp receiptDate) {
        this.receiptDate = receiptDate;
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

