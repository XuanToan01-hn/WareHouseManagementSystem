package model;

public class CheckInventoryDetail {
    private int checkDetailID;
    private int checkID;
    private int productID;
    private int productDetailID;
    private int quantitySystem;
    private int quantityActual;
    private int difference;
    private String note;

    public CheckInventoryDetail() {
    }

    public CheckInventoryDetail(int checkDetailID, int checkID, int productID, int productDetailID, int quantitySystem, int quantityActual, int difference, String note) {
        this.checkDetailID = checkDetailID;
        this.checkID = checkID;
        this.productID = productID;
        this.productDetailID = productDetailID;
        this.quantitySystem = quantitySystem;
        this.quantityActual = quantityActual;
        this.difference = difference;
        this.note = note;
    }

    public int getCheckDetailID() {
        return checkDetailID;
    }

    public void setCheckDetailID(int checkDetailID) {
        this.checkDetailID = checkDetailID;
    }

    public int getCheckID() {
        return checkID;
    }

    public void setCheckID(int checkID) {
        this.checkID = checkID;
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

    public int getQuantitySystem() {
        return quantitySystem;
    }

    public void setQuantitySystem(int quantitySystem) {
        this.quantitySystem = quantitySystem;
    }

    public int getQuantityActual() {
        return quantityActual;
    }

    public void setQuantityActual(int quantityActual) {
        this.quantityActual = quantityActual;
    }

    public int getDifference() {
        return difference;
    }

    public void setDifference(int difference) {
        this.difference = difference;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}

