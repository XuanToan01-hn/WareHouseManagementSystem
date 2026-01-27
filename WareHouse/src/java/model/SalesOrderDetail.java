package model;

import java.math.BigDecimal;

public class SalesOrderDetail {
    private int salesOrderDetailID;
    private int salesOrderID;
    private int productID;
    private int quantity;
    private BigDecimal price;
    private int taxID;
    private BigDecimal subTotal;

    public SalesOrderDetail() {
    }

    public SalesOrderDetail(int salesOrderDetailID, int salesOrderID, int productID, int quantity, BigDecimal price, int taxID, BigDecimal subTotal) {
        this.salesOrderDetailID = salesOrderDetailID;
        this.salesOrderID = salesOrderID;
        this.productID = productID;
        this.quantity = quantity;
        this.price = price;
        this.taxID = taxID;
        this.subTotal = subTotal;
    }

    public int getSalesOrderDetailID() {
        return salesOrderDetailID;
    }

    public void setSalesOrderDetailID(int salesOrderDetailID) {
        this.salesOrderDetailID = salesOrderDetailID;
    }

    public int getSalesOrderID() {
        return salesOrderID;
    }

    public void setSalesOrderID(int salesOrderID) {
        this.salesOrderID = salesOrderID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getTaxID() {
        return taxID;
    }

    public void setTaxID(int taxID) {
        this.taxID = taxID;
    }

    public BigDecimal getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }
}