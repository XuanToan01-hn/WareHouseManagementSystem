package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Role;
import model.Users;

public class UserDAO extends DBContext {

    // 1. Get all users
    public List<Users> getAllUsers() {
        List<Users> list = new ArrayList<>();
        String sql = "SELECT * FROM Users";
        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(mapResultSetToUser(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // 2. Login method (Check username and password)
    public Users login(String user, String pass) {
        String sql = "SELECT * FROM Users WHERE username = ? AND password = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, user);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return mapResultSetToUser(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean insertUser(Users u) {
    String sql = "INSERT INTO Users (userCode, fullName, username, password, email, phone, image, male, dateOfBirth, roleID, locationID) "
               + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    try (PreparedStatement ps = connection.prepareStatement(sql)) {
        ps.setString(1, u.getUserCode());
        ps.setString(2, u.getFullName());
        ps.setString(3, u.getUsername());
        ps.setString(4, u.getPassword());
        ps.setString(5, u.getEmail());
        ps.setString(6, u.getPhone());
        ps.setString(7, u.getImage());
        ps.setBoolean(8, u.isMale());
        ps.setDate(9, u.getDateOfBirth());
        // Lấy ID từ đối tượng Role
        ps.setInt(10, u.getRoleID().getRoleID()); 
        ps.setInt(11, u.getLocationID());
        return ps.executeUpdate() > 0;
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false;
}

    // 4. Update User
    public boolean updateUser(Users u) {
        String sql = "UPDATE Users SET fullName=?, email=?, phone=?, image=?, male=?, dateOfBirth=?, roleID=?, locationID=? "
                   + "WHERE userID=?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, u.getFullName());
            ps.setString(2, u.getEmail());
            ps.setString(3, u.getPhone());
            ps.setString(4, u.getImage());
            ps.setBoolean(5, u.isMale());
            ps.setDate(6, u.getDateOfBirth());
            ps.setInt(7, u.getRoleID().getRoleID()
            );
            ps.setInt(8, u.getLocationID());
            ps.setInt(9, u.getUserID());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // 5. Delete User
    public boolean deleteUser(int id) {
        String sql = "DELETE FROM Users WHERE userID = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Helper method to reduce code duplication
    private Users mapResultSetToUser(ResultSet rs) throws SQLException {
        Role role = new Role();
    role.setRoleID(rs.getInt("roleID"));
        return new Users(
            rs.getInt("userID"),
            rs.getString("userCode"),
            rs.getString("fullName"),
            rs.getString("username"),
            rs.getString("password"),
            rs.getString("email"),
            rs.getString("phone"),
            rs.getString("image"),
            rs.getBoolean("male"),
            rs.getDate("dateOfBirth"),
            role,
            rs.getInt("locationID")
        );
    }
    
 public static void main(String[] args) {
    UserDAO userOr = new UserDAO();
    RoleDAO roleDao = new RoleDAO();

    // 1. Lấy đối tượng Role từ Database (giả sử ID của Admin là 1)
    Role adminRole = roleDao.getRoleByID(1);

    if (adminRole != null) {
        // 2. Truyền đối tượng adminRole (kiểu Role) vào constructor
        Users admin = new Users(
            "ADM001", "System Admin", "admin", "123", 
            "admin@gmail.com", "0912345678", "avatar.png", 
            true, java.sql.Date.valueOf("2000-01-01"), 
            adminRole, 1
        );

        // 3. Thực hiện insert qua UserDAO
        if (userOr.insertUser(admin)) {
            System.out.println("Insert Admin thành công!");
        } else {
            System.out.println("Insert thất bại!");
        }
    } else {
        System.out.println("Không tìm thấy Role với ID = 1 trong DB!");
    }
}
}