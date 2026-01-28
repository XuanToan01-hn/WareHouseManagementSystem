package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.TransferOrderDetail;

public class TransferOrderDetailDAO extends DBContext {

    public List<TransferOrderDetail> getByTransferOrderId(int transferOrderId) {
        List<TransferOrderDetail> list = new ArrayList<>();
        String sql = "SELECT TransferDetailID, TransferOrderID, ProductID, ProductDetailID, Quantity "
                   + "FROM Transfer_Order_Detail WHERE TransferOrderID = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, transferOrderId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) list.add(map(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public TransferOrderDetail getById(int id) {
        String sql = "SELECT TransferDetailID, TransferOrderID, ProductID, ProductDetailID, Quantity "
                   + "FROM Transfer_Order_Detail WHERE TransferDetailID = ?";
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

    public boolean insert(TransferOrderDetail d) {
        String sql = "INSERT INTO Transfer_Order_Detail (TransferOrderID, ProductID, ProductDetailID, Quantity) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, d.getTransferOrderID());
            ps.setInt(2, d.getProductID());
            ps.setInt(3, d.getProductDetailID());
            ps.setInt(4, d.getQuantity());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(TransferOrderDetail d) {
        String sql = "UPDATE Transfer_Order_Detail SET TransferOrderID = ?, ProductID = ?, ProductDetailID = ?, Quantity = ? "
                   + "WHERE TransferDetailID = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, d.getTransferOrderID());
            ps.setInt(2, d.getProductID());
            ps.setInt(3, d.getProductDetailID());
            ps.setInt(4, d.getQuantity());
            ps.setInt(5, d.getTransferDetailID());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM Transfer_Order_Detail WHERE TransferDetailID = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private TransferOrderDetail map(ResultSet rs) throws SQLException {
        TransferOrderDetail d = new TransferOrderDetail();
        d.setTransferDetailID(rs.getInt("TransferDetailID"));
        d.setTransferOrderID(rs.getInt("TransferOrderID"));
        d.setProductID(rs.getInt("ProductID"));
        d.setProductDetailID(rs.getInt("ProductDetailID"));
        d.setQuantity(rs.getInt("Quantity"));
        return d;
    }
}

