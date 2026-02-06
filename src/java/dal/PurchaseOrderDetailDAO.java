package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.PurchaseOrderDetail;

public class PurchaseOrderDetailDAO extends DBContext {

    public List<PurchaseOrderDetail> getByPurchaseOrderId(int purchaseOrderId) {
        List<PurchaseOrderDetail> list = new ArrayList<>();
        String sql = "SELECT PurchaseOrderDetailID, PurchaseOrderID, ProductID, Quantity, Price, TaxID, SubTotal "
                   + "FROM Purchase_Order_Detail WHERE PurchaseOrderID = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, purchaseOrderId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) list.add(map(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public PurchaseOrderDetail getById(int id) {
        String sql = "SELECT PurchaseOrderDetailID, PurchaseOrderID, ProductID, Quantity, Price, TaxID, SubTotal "
                   + "FROM Purchase_Order_Detail WHERE PurchaseOrderDetailID = ?";
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



    public boolean insert(PurchaseOrderDetail d) {
        String sql = "INSERT INTO Purchase_Order_Detail (PurchaseOrderID, ProductID, Quantity, Price, TaxID, SubTotal) "
                   + "VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, d.getPurchaseOrderID());
            ps.setInt(2, d.getProductID());
            ps.setInt(3, d.getQuantity());
            ps.setBigDecimal(4, d.getPrice());
            ps.setInt(5, d.getTaxID());
            ps.setBigDecimal(6, d.getSubTotal());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(PurchaseOrderDetail d) {
        String sql = "UPDATE Purchase_Order_Detail SET PurchaseOrderID = ?, ProductID = ?, Quantity = ?, Price = ?, TaxID = ?, SubTotal = ? "
                   + "WHERE PurchaseOrderDetailID = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, d.getPurchaseOrderID());
            ps.setInt(2, d.getProductID());
            ps.setInt(3, d.getQuantity());
            ps.setBigDecimal(4, d.getPrice());
            ps.setInt(5, d.getTaxID());
            ps.setBigDecimal(6, d.getSubTotal());
            ps.setInt(7, d.getPurchaseOrderDetailID());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM Purchase_Order_Detail WHERE PurchaseOrderDetailID = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private PurchaseOrderDetail map(ResultSet rs) throws SQLException {
        PurchaseOrderDetail d = new PurchaseOrderDetail();
        d.setPurchaseOrderDetailID(rs.getInt("PurchaseOrderDetailID"));
        d.setPurchaseOrderID(rs.getInt("PurchaseOrderID"));
        d.setProductID(rs.getInt("ProductID"));
        d.setQuantity(rs.getInt("Quantity"));
        d.setPrice(rs.getBigDecimal("Price"));
        d.setTaxID(rs.getInt("TaxID"));
        d.setSubTotal(rs.getBigDecimal("SubTotal"));
        return d;
    }

}

