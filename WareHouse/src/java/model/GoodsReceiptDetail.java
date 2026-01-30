package model;

public class GoodsReceiptDetail {
    private int receiptDetailID;
    private int receiptID;
    private int productID;
    private int productDetailID;
    private int quantityExpected;
    private int quantityActual;
    private String lotNumber;

    public GoodsReceiptDetail() {
    }

    public GoodsReceiptDetail(int receiptDetailID, int receiptID, int productID, int productDetailID, int quantityExpected, int quantityActual, String lotNumber) {
        this.receiptDetailID = receiptDetailID;
        this.receiptID = receiptID;
        this.productID = productID;
        this.productDetailID = productDetailID;
        this.quantityExpected = quantityExpected;
        this.quantityActual = quantityActual;
        this.lotNumber = lotNumber;
    }

    public int getReceiptDetailID() {
        return receiptDetailID;
    }

    public void setReceiptDetailID(int receiptDetailID) {
        this.receiptDetailID = receiptDetailID;
    }

    public int getReceiptID() {
        return receiptID;
    }

    public void setReceiptID(int receiptID) {
        this.receiptID = receiptID;
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

    public int getQuantityExpected() {
        return quantityExpected;
    }

    public void setQuantityExpected(int quantityExpected) {
        this.quantityExpected = quantityExpected;
    }

    public int getQuantityActual() {
        return quantityActual;
    }

    public void setQuantityActual(int quantityActual) {
        this.quantityActual = quantityActual;
    }

    public String getLotNumber() {
        return lotNumber;
    }

    public void setLotNumber(String lotNumber) {
        this.lotNumber = lotNumber;
    }
}

