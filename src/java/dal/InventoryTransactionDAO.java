package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.InventoryTransaction;

public class InventoryTransactionDAO extends DBContext {

    public List<InventoryTransaction> getAll() {
        List<InventoryTransaction> list = new ArrayList<>();
        String sql = "SELECT TransactionID, ProductID, ProductDetailID, LocationID, TransactionType, Quantity, ReferenceCode, TransactionDate "
                   + "FROM Inventory_Transaction";
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

    public InventoryTransaction getById(int id) {
        String sql = "SELECT TransactionID, ProductID, ProductDetailID, LocationID, TransactionType, Quantity, ReferenceCode, TransactionDate "
                   + "FROM Inventory_Transaction WHERE TransactionID = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
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

    public List<InventoryTransaction> getByReferenceCode(String ref) {
        List<InventoryTransaction> list = new ArrayList<>();
        String sql = "SELECT TransactionID, ProductID, ProductDetailID, LocationID, TransactionType, Quantity, ReferenceCode, TransactionDate "
                   + "FROM Inventory_Transaction WHERE ReferenceCode = ? ORDER BY TransactionDate DESC";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, ref);
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

    public boolean insert(InventoryTransaction it) {
        String sql = "INSERT INTO Inventory_Transaction (ProductID, ProductDetailID, LocationID, TransactionType, Quantity, ReferenceCode) "
                   + "VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, it.getProductID());
            ps.setInt(2, it.getProductDetailID());
            ps.setInt(3, it.getLocationID());
            ps.setString(4, it.getTransactionType());
            ps.setInt(5, it.getQuantity());
            ps.setString(6, it.getReferenceCode());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM Inventory_Transaction WHERE TransactionID = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private InventoryTransaction map(ResultSet rs) throws SQLException {
        InventoryTransaction it = new InventoryTransaction();
        it.setTransactionID(rs.getInt("TransactionID"));
        it.setProductID(rs.getInt("ProductID"));
        it.setProductDetailID(rs.getInt("ProductDetailID"));
        it.setLocationID(rs.getInt("LocationID"));
        it.setTransactionType(rs.getString("TransactionType"));
        it.setQuantity(rs.getInt("Quantity"));
        it.setReferenceCode(rs.getString("ReferenceCode"));
        it.setTransactionDate(rs.getTimestamp("TransactionDate"));
        return it;
    }
}

