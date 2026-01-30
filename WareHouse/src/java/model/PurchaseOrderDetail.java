package model;

import java.math.BigDecimal;

public class PurchaseOrderDetail {
    private int purchaseOrderDetailID;
    private int purchaseOrderID;
    private int productID;
    private int quantity;
    private BigDecimal price;
    private int taxID;
    private BigDecimal subTotal;

    public PurchaseOrderDetail() {
    }

    public PurchaseOrderDetail(int purchaseOrderDetailID, int purchaseOrderID, int productID, int quantity, BigDecimal price, int taxID, BigDecimal subTotal) {
        this.purchaseOrderDetailID = purchaseOrderDetailID;
        this.purchaseOrderID = purchaseOrderID;
        this.productID = productID;
        this.quantity = quantity;
        this.price = price;
        this.taxID = taxID;
        this.subTotal = subTotal;
    }

    public int getPurchaseOrderDetailID() {
        return purchaseOrderDetailID;
    }

    public void setPurchaseOrderDetailID(int purchaseOrderDetailID) {
        this.purchaseOrderDetailID = purchaseOrderDetailID;
    }

    public int getPurchaseOrderID() {
        return purchaseOrderID;
    }

    public void setPurchaseOrderID(int purchaseOrderID) {
        this.purchaseOrderID = purchaseOrderID;
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

