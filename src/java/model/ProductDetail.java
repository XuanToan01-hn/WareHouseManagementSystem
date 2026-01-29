package model;

import java.sql.Date;

public class ProductDetail {
    private int productDetailID;
    private int productID;
    private String lotNumber;
    private String serialNumber;
    private String color;
    private Date manufactureDate;

    public ProductDetail() {
    }

    public ProductDetail(int productDetailID, int productID, String lotNumber, String serialNumber, String color, Date manufactureDate) {
        this.productDetailID = productDetailID;
        this.productID = productID;
        this.lotNumber = lotNumber;
        this.serialNumber = serialNumber;
        this.color = color;
        this.manufactureDate = manufactureDate;
    }

    public int getProductDetailID() {
        return productDetailID;
    }

    public void setProductDetailID(int productDetailID) {
        this.productDetailID = productDetailID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getLotNumber() {
        return lotNumber;
    }

    public void setLotNumber(String lotNumber) {
        this.lotNumber = lotNumber;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Date getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(Date manufactureDate) {
        this.manufactureDate = manufactureDate;
    }
}