package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import model.GoodsReceipt;

public class GoodsReceiptDAO extends DBContext {

    public List<GoodsReceipt> getAll() {
        List<GoodsReceipt> list = new ArrayList<>();
        String sql = "SELECT ReceiptID, ReceiptCode, PurchaseOrderID, LocationID, ReceiptDate, Status, Note, CreateBy "
                   + "FROM Goods_Receipt";
        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) list.add(map(rs));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public GoodsReceipt getById(int id) {
        String sql = "SELECT ReceiptID, ReceiptCode, PurchaseOrderID, LocationID, ReceiptDate, Status, Note, CreateBy "
                   + "FROM Goods_Receipt WHERE ReceiptID = ?";
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

    public GoodsReceipt getByCode(String code) {
        String sql = "SELECT ReceiptID, ReceiptCode, PurchaseOrderID, LocationID, ReceiptDate, Status, Note, CreateBy "
                   + "FROM Goods_Receipt WHERE ReceiptCode = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, code);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return map(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean insert(GoodsReceipt r) {
        String sql = "INSERT INTO Goods_Receipt (ReceiptCode, PurchaseOrderID, LocationID, Status, Note, CreateBy) "
                   + "VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, r.getReceiptCode());
            if (r.getPurchaseOrderID() == null) {
                ps.setNull(2, Types.INTEGER);
            } else {
                ps.setInt(2, r.getPurchaseOrderID());
            }
            ps.setInt(3, r.getLocationID());
            ps.setInt(4, r.getStatus());
            ps.setString(5, r.getNote());
            ps.setInt(6, r.getCreateBy());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(GoodsReceipt r) {
        String sql = "UPDATE Goods_Receipt SET ReceiptCode = ?, PurchaseOrderID = ?, LocationID = ?, Status = ?, Note = ?, CreateBy = ? "
                   + "WHERE ReceiptID = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, r.getReceiptCode());
            if (r.getPurchaseOrderID() == null) {
                ps.setNull(2, Types.INTEGER);
            } else {
                ps.setInt(2, r.getPurchaseOrderID());
            }
            ps.setInt(3, r.getLocationID());
            ps.setInt(4, r.getStatus());
            ps.setString(5, r.getNote());
            ps.setInt(6, r.getCreateBy());
            ps.setInt(7, r.getReceiptID());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM Goods_Receipt WHERE ReceiptID = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private GoodsReceipt map(ResultSet rs) throws SQLException {
        GoodsReceipt r = new GoodsReceipt();
        r.setReceiptID(rs.getInt("ReceiptID"));
        r.setReceiptCode(rs.getString("ReceiptCode"));
        int poId = rs.getInt("PurchaseOrderID");
        r.setPurchaseOrderID(rs.wasNull() ? null : poId);
        r.setLocationID(rs.getInt("LocationID"));
        r.setReceiptDate(rs.getTimestamp("ReceiptDate"));
        r.setStatus(rs.getInt("Status"));
        r.setNote(rs.getString("Note"));
        r.setCreateBy(rs.getInt("CreateBy"));
        return r;
    }
}

