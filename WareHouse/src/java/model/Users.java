package model;

import java.sql.Date;

public class Users {
    private int userID;
    private String userCode;
    private String fullName;
    private String username;
    private String password;
    private String email;
    private String phone;
    private String image;
    private boolean male; // SQL BIT maps to boolean
    private Date dateOfBirth;
    private Role role;
    private int locationID;



    public Users() {
    }

    public Users(String userCode, String fullName, String username, String password, String email, String phone, String image, boolean male, Date dateOfBirth, Role roleID, int locationID) {
        this.userCode = userCode;
        this.fullName = fullName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.image = image;
        this.male = male;
        this.dateOfBirth = dateOfBirth;
        this.role = roleID;
        this.locationID = locationID;
    }

    public Users(int userID, String userCode, String fullName, String username, String password, String email, String phone, String image, boolean male, Date dateOfBirth, Role roleID, int locationID) {
        this.userID = userID;
        this.userCode = userCode;
        this.fullName = fullName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.image = image;
        this.male = male;
        this.dateOfBirth = dateOfBirth;
        this.role = roleID;
        this.locationID = locationID;
    }
    
    
    
    

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isMale() {
        return male;
    }

    public void setMale(boolean male) {
        this.male = male;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }




    public int getLocationID() {
        return locationID;
    }

    public void setLocationID(int locationID) {
        this.locationID = locationID;
    }
}