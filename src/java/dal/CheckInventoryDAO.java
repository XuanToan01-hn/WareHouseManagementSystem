package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.CheckInventory;

public class CheckInventoryDAO extends DBContext {

    public List<CheckInventory> getAll() {
        List<CheckInventory> list = new ArrayList<>();
        String sql = "SELECT CheckID, CheckCode, LocationID, CheckDate, Status, CreateBy FROM Check_Inventory";
        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) list.add(map(rs));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public CheckInventory getById(int id) {
        String sql = "SELECT CheckID, CheckCode, LocationID, CheckDate, Status, CreateBy FROM Check_Inventory WHERE CheckID = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return map(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean insert(CheckInventory c) {
        String sql = "INSERT INTO Check_Inventory (CheckCode, LocationID, CheckDate, Status, CreateBy) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, c.getCheckCode());
            ps.setInt(2, c.getLocationID());
            ps.setDate(3, c.getCheckDate());
            ps.setString(4, c.getStatus());
            ps.setInt(5, c.getCreateBy());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(CheckInventory c) {
        String sql = "UPDATE Check_Inventory SET CheckCode = ?, LocationID = ?, CheckDate = ?, Status = ?, CreateBy = ? WHERE CheckID = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, c.getCheckCode());
            ps.setInt(2, c.getLocationID());
            ps.setDate(3, c.getCheckDate());
            ps.setString(4, c.getStatus());
            ps.setInt(5, c.getCreateBy());
            ps.setInt(6, c.getCheckID());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM Check_Inventory WHERE CheckID = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private CheckInventory map(ResultSet rs) throws SQLException {
        CheckInventory c = new CheckInventory();
        c.setCheckID(rs.getInt("CheckID"));
        c.setCheckCode(rs.getString("CheckCode"));
        c.setLocationID(rs.getInt("LocationID"));
        c.setCheckDate(rs.getDate("CheckDate"));
        c.setStatus(rs.getString("Status"));
        c.setCreateBy(rs.getInt("CreateBy"));
        return c;
    }
}

