package model;

import java.math.BigDecimal;

public class Product {
    private int productID;
    private String code;
    private String name;
    private BigDecimal price;
    private String description;
    private String image;
    private int unitID;
    private int categoryID;
    private int minStock;
    private Category category;
    private Unit unit;

    public Product(int productID, String code, String name, BigDecimal price, String description, String image, int unitID, int categoryID, int minStock) {
        this.productID = productID;
        this.code = code;
        this.name = name;
        this.price = price;
        this.description = description;
        this.image = image;
        this.unitID = unitID;
        this.categoryID = categoryID;
        this.minStock = minStock;
    }



    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public Product() {
    }



    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getUnitID() {
        return unitID;
    }

    public void setUnitID(int unitID) {
        this.unitID = unitID;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public int getMinStock() {
        return minStock;
    }

    public void setMinStock(int minStock) {
        this.minStock = minStock;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productID=" + productID +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", unitID=" + unitID +
                ", categoryID=" + categoryID +
                ", minStock=" + minStock +
                '}';
    }
}