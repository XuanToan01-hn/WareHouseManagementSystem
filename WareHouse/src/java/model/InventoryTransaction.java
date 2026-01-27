package model;

import java.sql.Timestamp;

public class InventoryTransaction {
    private int transactionID;
    private int productID;
    private int productDetailID;
    private int locationID;
    private String transactionType; // RECEIPT, ISSUE, TRANSFER_IN, etc.
    private int quantity;
    private String referenceCode;
    private Timestamp transactionDate;

    public InventoryTransaction() {
    }

    public InventoryTransaction(int transactionID, int productID, int productDetailID, int locationID, String transactionType, int quantity, String referenceCode, Timestamp transactionDate) {
        this.transactionID = transactionID;
        this.productID = productID;
        this.productDetailID = productDetailID;
        this.locationID = locationID;
        this.transactionType = transactionType;
        this.quantity = quantity;
        this.referenceCode = referenceCode;
        this.transactionDate = transactionDate;
    }

    public int getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getProductDetailID() {
        return productDetailID;
    }

    public void setProductDetailID(int productDetailID) {
        this.productDetailID = productDetailID;
    }

    public int getLocationID() {
        return locationID;
    }

    public void setLocationID(int locationID) {
        this.locationID = locationID;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getReferenceCode() {
        return referenceCode;
    }

    public void setReferenceCode(String referenceCode) {
        this.referenceCode = referenceCode;
    }

    public Timestamp getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Timestamp transactionDate) {
        this.transactionDate = transactionDate;
    }
}