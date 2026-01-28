package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.SalesOrder;

public class SalesOrderDAO extends DBContext {

    public List<SalesOrder> getAll() {
        List<SalesOrder> list = new ArrayList<>();
        String sql = "SELECT SalesOrderID, OrderCode, CustomerID, CreatedDate, Status, TotalAmount, Note, CreateBy "
                   + "FROM Sales_Order";
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

    public SalesOrder getById(int id) {
        String sql = "SELECT SalesOrderID, OrderCode, CustomerID, CreatedDate, Status, TotalAmount, Note, CreateBy "
                   + "FROM Sales_Order WHERE SalesOrderID = ?";
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

    public boolean insert(SalesOrder so) {
        String sql = "INSERT INTO Sales_Order (OrderCode, CustomerID, Status, TotalAmount, Note, CreateBy) "
                   + "VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, so.getOrderCode());
            ps.setInt(2, so.getCustomerID());
            ps.setInt(3, so.getStatus());
            ps.setBigDecimal(4, so.getTotalAmount());
            ps.setString(5, so.getNote());
            ps.setInt(6, so.getCreateBy());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(SalesOrder so) {
        String sql = "UPDATE Sales_Order SET OrderCode = ?, CustomerID = ?, Status = ?, TotalAmount = ?, Note = ?, CreateBy = ? "
                   + "WHERE SalesOrderID = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, so.getOrderCode());
            ps.setInt(2, so.getCustomerID());
            ps.setInt(3, so.getStatus());
            ps.setBigDecimal(4, so.getTotalAmount());
            ps.setString(5, so.getNote());
            ps.setInt(6, so.getCreateBy());
            ps.setInt(7, so.getSalesOrderID());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM Sales_Order WHERE SalesOrderID = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private SalesOrder map(ResultSet rs) throws SQLException {
        SalesOrder so = new SalesOrder();
        so.setSalesOrderID(rs.getInt("SalesOrderID"));
        so.setOrderCode(rs.getString("OrderCode"));
        so.setCustomerID(rs.getInt("CustomerID"));
        so.setCreatedDate(rs.getTimestamp("CreatedDate"));
        so.setStatus(rs.getInt("Status"));
        so.setTotalAmount(rs.getBigDecimal("TotalAmount"));
        so.setNote(rs.getString("Note"));
        so.setCreateBy(rs.getInt("CreateBy"));
        return so;
    }
}

