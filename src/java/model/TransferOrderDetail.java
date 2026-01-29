package model;

public class TransferOrderDetail {
    private int transferDetailID;
    private int transferOrderID;
    private int productID;
    private int productDetailID;
    private int quantity;

    public TransferOrderDetail() {
    }

    public TransferOrderDetail(int transferDetailID, int transferOrderID, int productID, int productDetailID, int quantity) {
        this.transferDetailID = transferDetailID;
        this.transferOrderID = transferOrderID;
        this.productID = productID;
        this.productDetailID = productDetailID;
        this.quantity = quantity;
    }

    public int getTransferDetailID() {
        return transferDetailID;
    }

    public void setTransferDetailID(int transferDetailID) {
        this.transferDetailID = transferDetailID;
    }

    public int getTransferOrderID() {
        return transferOrderID;
    }

    public void setTransferOrderID(int transferOrderID) {
        this.transferOrderID = transferOrderID;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

