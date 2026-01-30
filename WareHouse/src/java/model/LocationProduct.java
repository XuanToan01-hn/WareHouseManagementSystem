package model;

public class LocationProduct {
    private int locationID;
    private int productID;
    private int productDetailID;
    private int quantity;
    private Integer maxStock; // Nullable

    public LocationProduct(int locationID, int productID, int productDetailID, int quantity, Integer maxStock) {
        this.locationID = locationID;
        this.productID = productID;
        this.productDetailID = productDetailID;
        this.quantity = quantity;
        this.maxStock = maxStock;
    }

    public LocationProduct() {
    }

    public int getLocationID() {
        return locationID;
    }

    public void setLocationID(int locationID) {
        this.locationID = locationID;
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

    public Integer getMaxStock() {
        return maxStock;
    }

    public void setMaxStock(Integer maxStock) {
        this.maxStock = maxStock;
    }
}