package model;

import java.sql.Date;

public class ProductDetail {
    private int productDetailID;
    private int productID;
    private String lotNumber;
    private String serialNumber;
    private Date manufactureDate;
    private Date expiryDate;
    private String quality;

    public ProductDetail() {
    }

    public ProductDetail(int productDetailID, int productID, String lotNumber, String serialNumber, Date manufactureDate, Date expiryDate, String quality) {
        this.productDetailID = productDetailID;
        this.productID = productID;
        this.lotNumber = lotNumber;
        this.serialNumber = serialNumber;
        this.manufactureDate = manufactureDate;
        this.expiryDate = expiryDate;
        this.quality = quality;
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

    public Date getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(Date manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }
}