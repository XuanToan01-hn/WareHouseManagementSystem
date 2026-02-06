package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.SalesOrderDetail;

public class SalesOrderDetailDAO extends DBContext {

    public List<SalesOrderDetail> getBySalesOrderId(int salesOrderId) {
        List<SalesOrderDetail> list = new ArrayList<>();
        String sql = "SELECT SalesOrderDetailID, SalesOrderID, ProductDetailID, Quantity, Price, TaxID, SubTotal "
                   + "FROM Sales_Order_Detail WHERE SalesOrderID = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, salesOrderId);
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

    public SalesOrderDetail getById(int id) {
        String sql = "SELECT SalesOrderDetailID, SalesOrderID, ProductDetailID, Quantity, Price, TaxID, SubTotal "
                   + "FROM Sales_Order_Detail WHERE SalesOrderDetailID = ?";
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

    public boolean insert(SalesOrderDetail d) {
        String sql = "INSERT INTO Sales_Order_Detail (SalesOrderID, ProductDetailID, Quantity, Price, TaxID, SubTotal) "
                   + "VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, d.getSalesOrderID());
            ps.setInt(2, d.getProductDetailID());
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

    public boolean update(SalesOrderDetail d) {
        String sql = "UPDATE Sales_Order_Detail "
                   + "SET SalesOrderID = ?, ProductDetailID = ?, Quantity = ?, Price = ?, TaxID = ?, SubTotal = ? "
                   + "WHERE SalesOrderDetailID = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, d.getSalesOrderID());
            ps.setInt(2, d.getProductDetailID());
            ps.setInt(3, d.getQuantity());
            ps.setBigDecimal(4, d.getPrice());
            ps.setInt(5, d.getTaxID());
            ps.setBigDecimal(6, d.getSubTotal());
            ps.setInt(7, d.getSalesOrderDetailID());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM Sales_Order_Detail WHERE SalesOrderDetailID = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private SalesOrderDetail map(ResultSet rs) throws SQLException {
        SalesOrderDetail d = new SalesOrderDetail();
        d.setSalesOrderDetailID(rs.getInt("SalesOrderDetailID"));
        d.setSalesOrderID(rs.getInt("SalesOrderID"));
        d.setProductDetailID(rs.getInt("ProductDetailID"));
        d.setQuantity(rs.getInt("Quantity"));
        d.setPrice(rs.getBigDecimal("Price"));
        d.setTaxID(rs.getInt("TaxID"));
        d.setSubTotal(rs.getBigDecimal("SubTotal"));
        return d;
    }
}

