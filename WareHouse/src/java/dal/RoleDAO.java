package dal;

import model.Role;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoleDAO extends DBContext{
    public List<Role> getAllRoles() {
        List<Role> list = new ArrayList<>();
        String sql = "SELECT * FROM Role";

        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Role r = new Role();
                r.setRoleID(rs.getInt("roleID"));
                r.setRoleName(rs.getString("roleName"));
                list.add(r);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    // 2. Lấy Role theo ID
    public Role getRoleByID(int id) {
        String sql = "SELECT * FROM Role WHERE roleID = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Role(
                        rs.getInt("roleID"),
                        rs.getString("roleName")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // 3. Thêm Role
    public boolean insertRole(Role r) {
        String sql = "INSERT INTO Role(roleName) VALUES (?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, r.getRoleName());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // 4. Cập nhật Role
    public boolean updateRole(Role r) {
        String sql = "UPDATE Role SET roleName = ? WHERE roleID = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, r.getRoleName());
            ps.setInt(2, r.getRoleID());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // 5. Xoá Role
    public boolean deleteRole(int id) {
        String sql = "DELETE FROM Role WHERE roleID = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {

        RoleDAO dao = new RoleDAO();

//        // 1. Test INSERT
//        System.out.println("=== INSERT ===");
//        Role newRole = new Role( "ADMIN");
//        boolean inserted = dao.insertRole(newRole);
//        System.out.println("Insert success: " + inserted);
//
        // 2. Test SELECT ALL
        System.out.println("\n=== GET ALL ROLES ===");
        List<Role> roles = dao.getAllRoles();
        for (Role r : roles) {
            System.out.println(r.getRoleID() + " - " + r.getRoleName());
        }
//
//        // 3. Test SELECT BY ID
//        System.out.println("\n=== GET ROLE BY ID ===");
//        Role role = dao.getRoleByID(1); // đổi ID theo DB của bạn
//        if (role != null) {
//            System.out.println(role.getRoleID() + " - " + role.getRoleName());
//        } else {
//            System.out.println("Role not found!");
//        }
//
//        // 4. Test UPDATE
//        System.out.println("\n=== UPDATE ROLE ===");
//        Role updateRole = new Role(1, "SUPER_ADMIN"); // ID phải tồn tại
//        boolean updated = dao.updateRole(updateRole);
//        System.out.println("Update success: " + updated);
//
//        // 5. Test DELETE
//        System.out.println("\n=== DELETE ROLE ===");
//        boolean deleted = dao.deleteRole(3); // đổi ID theo DB
//        System.out.println("Delete success: " + deleted);
    }
}
