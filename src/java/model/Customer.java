package model;

public class Customer {
    private int customerID;
    private String customerCode;
    private String name;
    private String phone;
    private String email;
    private String address;

    public Customer(int customerID, String customerCode, String name, String phone, String email, String address) {
        this.customerID = customerID;
        this.customerCode = customerCode;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public Customer() {
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}