package model;

import java.math.BigDecimal;

public class SupplierProduct {
    private int supplierID;
    private int productID;
    private int deliveryDuration;
    private BigDecimal estimatedPrice;

    public SupplierProduct(int supplierID, int productID, int deliveryDuration, BigDecimal estimatedPrice) {
        this.supplierID = supplierID;
        this.productID = productID;
        this.deliveryDuration = deliveryDuration;
        this.estimatedPrice = estimatedPrice;
    }

    public SupplierProduct() {
    }

    public int getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(int supplierID) {
        this.supplierID = supplierID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getDeliveryDuration() {
        return deliveryDuration;
    }

    public void setDeliveryDuration(int deliveryDuration) {
        this.deliveryDuration = deliveryDuration;
    }

    public BigDecimal getEstimatedPrice() {
        return estimatedPrice;
    }

    public void setEstimatedPrice(BigDecimal estimatedPrice) {
        this.estimatedPrice = estimatedPrice;
    }
}