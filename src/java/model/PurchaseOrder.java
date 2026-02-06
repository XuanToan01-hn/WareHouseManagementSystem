package model;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class PurchaseOrder {
    private int purchaseOrderID;
    private String orderCode;
    private int supplierID;
    private int status;
    private Timestamp createdDate;
    private BigDecimal totalAmount;
    private int createBy;

    public PurchaseOrder() {
    }

    public PurchaseOrder(int purchaseOrderID, String orderCode, int supplierID, int status, Timestamp createdDate, BigDecimal totalAmount, int createBy) {
        this.purchaseOrderID = purchaseOrderID;
        this.orderCode = orderCode;
        this.supplierID = supplierID;
        this.status = status;
        this.createdDate = createdDate;
        this.totalAmount = totalAmount;
        this.createBy = createBy;
    }

    public int getPurchaseOrderID() {
        return purchaseOrderID;
    }

    public void setPurchaseOrderID(int purchaseOrderID) {
        this.purchaseOrderID = purchaseOrderID;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public int getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(int supplierID) {
        this.supplierID = supplierID;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getCreateBy() {
        return createBy;
    }

    public void setCreateBy(int createBy) {
        this.createBy = createBy;
    }

    @Override
    public String toString() {
        return "PurchaseOrder{" +
                "purchaseOrderID=" + purchaseOrderID +
                ", orderCode='" + orderCode + '\'' +
                ", supplierID=" + supplierID +
                ", status=" + status +
                ", createdDate=" + createdDate +
                ", totalAmount=" + totalAmount +
                ", createBy=" + createBy +
                '}';
    }
}

