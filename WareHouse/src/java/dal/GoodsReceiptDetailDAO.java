package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.GoodsReceiptDetail;

public class GoodsReceiptDetailDAO extends DBContext {

    public List<GoodsReceiptDetail> getByReceiptId(int receiptId) {
        List<GoodsReceiptDetail> list = new ArrayList<>();
        String sql = "SELECT ReceiptDetailID, ReceiptID, ProductID, ProductDetailID, Quantity_Expected, Quantity_Actual, LotNumber "
                   + "FROM Goods_Receipt_Detail WHERE ReceiptID = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, receiptId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) list.add(map(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public GoodsReceiptDetail getById(int id) {
        String sql = "SELECT ReceiptDetailID, ReceiptID, ProductID, ProductDetailID, Quantity_Expected, Quantity_Actual, LotNumber "
                   + "FROM Goods_Receipt_Detail WHERE ReceiptDetailID = ?";
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

    public boolean insert(GoodsReceiptDetail d) {
        String sql = "INSERT INTO Goods_Receipt_Detail (ReceiptID, ProductID, ProductDetailID, Quantity_Expected, Quantity_Actual, LotNumber) "
                   + "VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, d.getReceiptID());
            ps.setInt(2, d.getProductID());
            ps.setInt(3, d.getProductDetailID());
            ps.setInt(4, d.getQuantityExpected());
            ps.setInt(5, d.getQuantityActual());
            ps.setString(6, d.getLotNumber());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(GoodsReceiptDetail d) {
        String sql = "UPDATE Goods_Receipt_Detail SET ReceiptID = ?, ProductID = ?, ProductDetailID = ?, "
                   + "Quantity_Expected = ?, Quantity_Actual = ?, LotNumber = ? "
                   + "WHERE ReceiptDetailID = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, d.getReceiptID());
            ps.setInt(2, d.getProductID());
            ps.setInt(3, d.getProductDetailID());
            ps.setInt(4, d.getQuantityExpected());
            ps.setInt(5, d.getQuantityActual());
            ps.setString(6, d.getLotNumber());
            ps.setInt(7, d.getReceiptDetailID());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM Goods_Receipt_Detail WHERE ReceiptDetailID = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private GoodsReceiptDetail map(ResultSet rs) throws SQLException {
        GoodsReceiptDetail d = new GoodsReceiptDetail();
        d.setReceiptDetailID(rs.getInt("ReceiptDetailID"));
        d.setReceiptID(rs.getInt("ReceiptID"));
        d.setProductID(rs.getInt("ProductID"));
        d.setProductDetailID(rs.getInt("ProductDetailID"));
        d.setQuantityExpected(rs.getInt("Quantity_Expected"));
        d.setQuantityActual(rs.getInt("Quantity_Actual"));
        d.setLotNumber(rs.getString("LotNumber"));
        return d;
    }
}

