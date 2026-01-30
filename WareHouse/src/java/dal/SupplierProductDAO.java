package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.SupplierProduct;

public class SupplierProductDAO extends DBContext {

    public List<SupplierProduct> getAll() {
        List<SupplierProduct> list = new ArrayList<>();
        String sql = "SELECT SupplierID, ProductID, DeliveryDuration, EstimatedPrice FROM Supplier_Product";
        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(map(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<SupplierProduct> getBySupplierId(int supplierId) {
        List<SupplierProduct> list = new ArrayList<>();
        String sql = "SELECT SupplierID, ProductID, DeliveryDuration, EstimatedPrice "
                   + "FROM Supplier_Product WHERE SupplierID = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, supplierId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(map(rs));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public SupplierProduct getByKey(int supplierId, int productId) {
        String sql = "SELECT SupplierID, ProductID, DeliveryDuration, EstimatedPrice "
                   + "FROM Supplier_Product WHERE SupplierID = ? AND ProductID = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, supplierId);
            ps.setInt(2, productId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return map(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean insert(SupplierProduct sp) {
        String sql = "INSERT INTO Supplier_Product (SupplierID, ProductID, DeliveryDuration, EstimatedPrice) "
                   + "VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, sp.getSupplierID());
            ps.setInt(2, sp.getProductID());
            ps.setInt(3, sp.getDeliveryDuration());
            ps.setBigDecimal(4, sp.getEstimatedPrice());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(SupplierProduct sp) {
        String sql = "UPDATE Supplier_Product SET DeliveryDuration = ?, EstimatedPrice = ? "
                   + "WHERE SupplierID = ? AND ProductID = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, sp.getDeliveryDuration());
            ps.setBigDecimal(2, sp.getEstimatedPrice());
            ps.setInt(3, sp.getSupplierID());
            ps.setInt(4, sp.getProductID());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(int supplierId, int productId) {
        String sql = "DELETE FROM Supplier_Product WHERE SupplierID = ? AND ProductID = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, supplierId);
            ps.setInt(2, productId);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private SupplierProduct map(ResultSet rs) throws SQLException {
        SupplierProduct sp = new SupplierProduct();
        sp.setSupplierID(rs.getInt("SupplierID"));
        sp.setProductID(rs.getInt("ProductID"));
        sp.setDeliveryDuration(rs.getInt("DeliveryDuration"));
        sp.setEstimatedPrice(rs.getBigDecimal("EstimatedPrice"));
        return sp;
    }
}

