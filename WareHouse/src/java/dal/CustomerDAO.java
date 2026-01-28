package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Customer;

public class CustomerDAO extends DBContext {

    public List<Customer> getAll() {
        List<Customer> list = new ArrayList<>();
        String sql = "SELECT CustomerID, CustomerCode, Name, Phone, Email, Address FROM Customer";
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

    public Customer getById(int id) {
        String sql = "SELECT CustomerID, CustomerCode, Name, Phone, Email, Address FROM Customer WHERE CustomerID = ?";
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

    public boolean insert(Customer c) {
        String sql = "INSERT INTO Customer (CustomerCode, Name, Phone, Email, Address) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, c.getCustomerCode());
            ps.setString(2, c.getName());
            ps.setString(3, c.getPhone());
            ps.setString(4, c.getEmail());
            ps.setString(5, c.getAddress());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(Customer c) {
        String sql = "UPDATE Customer SET CustomerCode = ?, Name = ?, Phone = ?, Email = ?, Address = ? WHERE CustomerID = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, c.getCustomerCode());
            ps.setString(2, c.getName());
            ps.setString(3, c.getPhone());
            ps.setString(4, c.getEmail());
            ps.setString(5, c.getAddress());
            ps.setInt(6, c.getCustomerID());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM Customer WHERE CustomerID = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private Customer map(ResultSet rs) throws SQLException {
        Customer c = new Customer();
        c.setCustomerID(rs.getInt("CustomerID"));
        c.setCustomerCode(rs.getString("CustomerCode"));
        c.setName(rs.getString("Name"));
        c.setPhone(rs.getString("Phone"));
        c.setEmail(rs.getString("Email"));
        c.setAddress(rs.getString("Address"));
        return c;
    }
}

