package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.PurchaseOrder;

public class PurchaseOrderDAO extends DBContext {

    public List<PurchaseOrder> getAll() {
        List<PurchaseOrder> list = new ArrayList<>();
        String sql = "SELECT PurchaseOrderID, OrderCode, SupplierID, Status, CreatedDate, TotalAmount, CreateBy FROM Purchase_Order";
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

    public PurchaseOrder getById(int id) {
        String sql = "SELECT PurchaseOrderID, OrderCode, SupplierID, Status, CreatedDate, TotalAmount, CreateBy "
                   + "FROM Purchase_Order WHERE PurchaseOrderID = ?";
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

    public boolean insert(PurchaseOrder po) {
        String sql = "INSERT INTO Purchase_Order (OrderCode, SupplierID, Status, TotalAmount, CreateBy) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, po.getOrderCode());
            ps.setInt(2, po.getSupplierID());
            ps.setInt(3, po.getStatus());
            ps.setBigDecimal(4, po.getTotalAmount());
            ps.setInt(5, po.getCreateBy());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(PurchaseOrder po) {
        String sql = "UPDATE Purchase_Order SET OrderCode = ?, SupplierID = ?, Status = ?, TotalAmount = ?, CreateBy = ? "
                   + "WHERE PurchaseOrderID = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, po.getOrderCode());
            ps.setInt(2, po.getSupplierID());
            ps.setInt(3, po.getStatus());
            ps.setBigDecimal(4, po.getTotalAmount());
            ps.setInt(5, po.getCreateBy());
            ps.setInt(6, po.getPurchaseOrderID());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM Purchase_Order WHERE PurchaseOrderID = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private PurchaseOrder map(ResultSet rs) throws SQLException {
        PurchaseOrder po = new PurchaseOrder();
        po.setPurchaseOrderID(rs.getInt("PurchaseOrderID"));
        po.setOrderCode(rs.getString("OrderCode"));
        po.setSupplierID(rs.getInt("SupplierID"));
        po.setStatus(rs.getInt("Status"));
        po.setCreatedDate(rs.getTimestamp("CreatedDate"));
        po.setTotalAmount(rs.getBigDecimal("TotalAmount"));
        po.setCreateBy(rs.getInt("CreateBy"));
        return po;
    }
}

