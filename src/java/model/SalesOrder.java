package model;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class SalesOrder {
    private int salesOrderID;
    private String orderCode;
    private int customerID;
    private Timestamp createdDate;
    private int status;
    private BigDecimal totalAmount;
    private String note;
    private int createBy;

    public SalesOrder() {
    }

    public SalesOrder(int salesOrderID, String orderCode, int customerID, Timestamp createdDate, int status, BigDecimal totalAmount, String note, int createBy) {
        this.salesOrderID = salesOrderID;
        this.orderCode = orderCode;
        this.customerID = customerID;
        this.createdDate = createdDate;
        this.status = status;
        this.totalAmount = totalAmount;
        this.note = note;
        this.createBy = createBy;
    }

    public int getSalesOrderID() {
        return salesOrderID;
    }

    public void setSalesOrderID(int salesOrderID) {
        this.salesOrderID = salesOrderID;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
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