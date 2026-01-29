package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.CheckInventoryDetail;

public class CheckInventoryDetailDAO extends DBContext {

    public List<CheckInventoryDetail> getByCheckId(int checkId) {
        List<CheckInventoryDetail> list = new ArrayList<>();
        String sql = "SELECT CheckDetailID, CheckID, ProductID, ProductDetailID, Quantity_System, Quantity_Actual, Difference, Note "
                   + "FROM Check_Inventory_Detail WHERE CheckID = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, checkId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) list.add(map(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public CheckInventoryDetail getById(int id) {
        String sql = "SELECT CheckDetailID, CheckID, ProductID, ProductDetailID, Quantity_System, Quantity_Actual, Difference, Note "
                   + "FROM Check_Inventory_Detail WHERE CheckDetailID = ?";
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

    public boolean insert(CheckInventoryDetail d) {
        String sql = "INSERT INTO Check_Inventory_Detail (CheckID, ProductID, ProductDetailID, Quantity_System, Quantity_Actual, Difference, Note) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, d.getCheckID());
            ps.setInt(2, d.getProductID());
            ps.setInt(3, d.getProductDetailID());
            ps.setInt(4, d.getQuantitySystem());
            ps.setInt(5, d.getQuantityActual());
            ps.setInt(6, d.getDifference());
            ps.setString(7, d.getNote());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(CheckInventoryDetail d) {
        String sql = "UPDATE Check_Inventory_Detail SET CheckID = ?, ProductID = ?, ProductDetailID = ?, "
                   + "Quantity_System = ?, Quantity_Actual = ?, Difference = ?, Note = ? "
                   + "WHERE CheckDetailID = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, d.getCheckID());
            ps.setInt(2, d.getProductID());
            ps.setInt(3, d.getProductDetailID());
            ps.setInt(4, d.getQuantitySystem());
            ps.setInt(5, d.getQuantityActual());
            ps.setInt(6, d.getDifference());
            ps.setString(7, d.getNote());
            ps.setInt(8, d.getCheckDetailID());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM Check_Inventory_Detail WHERE CheckDetailID = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private CheckInventoryDetail map(ResultSet rs) throws SQLException {
        CheckInventoryDetail d = new CheckInventoryDetail();
        d.setCheckDetailID(rs.getInt("CheckDetailID"));
        d.setCheckID(rs.getInt("CheckID"));
        d.setProductID(rs.getInt("ProductID"));
        d.setProductDetailID(rs.getInt("ProductDetailID"));
        d.setQuantitySystem(rs.getInt("Quantity_System"));
        d.setQuantityActual(rs.getInt("Quantity_Actual"));
        d.setDifference(rs.getInt("Difference"));
        d.setNote(rs.getString("Note"));
        return d;
    }
}

