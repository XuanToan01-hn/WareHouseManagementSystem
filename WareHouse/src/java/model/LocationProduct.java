package model;

public class LocationProduct {
    private int locationID;
    private int productID;
    private int productDetailID;
    private int quantity;
    private int minStock;
    private Integer maxStock; // Nullable

    public LocationProduct(int locationID, int productID, int productDetailID, int quantity, int minStock, Integer maxStock) {
        this.locationID = locationID;
        this.productID = productID;
        this.productDetailID = productDetailID;
        this.quantity = quantity;
        this.minStock = minStock;
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

    public int getMinStock() {
        return minStock;
    }

    public void setMinStock(int minStock) {
        this.minStock = minStock;
    }

    public Integer getMaxStock() {
        return maxStock;
    }

    public void setMaxStock(Integer maxStock) {
        this.maxStock = maxStock;
    }
}