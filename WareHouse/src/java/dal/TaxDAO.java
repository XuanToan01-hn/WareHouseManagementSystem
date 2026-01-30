package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Tax;

public class TaxDAO extends DBContext {

    public List<Tax> getAll() {
        List<Tax> list = new ArrayList<>();
        String sql = "SELECT TaxID, TaxName, TaxRate, EffectiveFrom, ExpiredDate FROM Tax";
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

    public Tax getById(int id) {
        String sql = "SELECT TaxID, TaxName, TaxRate, EffectiveFrom, ExpiredDate FROM Tax WHERE TaxID = ?";
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

    public boolean insert(Tax t) {
        String sql = "INSERT INTO Tax (TaxName, TaxRate, EffectiveFrom, ExpiredDate) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, t.getTaxName());
            ps.setBigDecimal(2, t.getTaxRate());
            ps.setDate(3, t.getEffectiveFrom());
            ps.setDate(4, t.getExpiredDate());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(Tax t) {
        String sql = "UPDATE Tax SET TaxName = ?, TaxRate = ?, EffectiveFrom = ?, ExpiredDate = ? WHERE TaxID = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, t.getTaxName());
            ps.setBigDecimal(2, t.getTaxRate());
            ps.setDate(3, t.getEffectiveFrom());
            ps.setDate(4, t.getExpiredDate());
            ps.setInt(5, t.getTaxID());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM Tax WHERE TaxID = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private Tax map(ResultSet rs) throws SQLException {
        Tax t = new Tax();
        t.setTaxID(rs.getInt("TaxID"));
        t.setTaxName(rs.getString("TaxName"));
        t.setTaxRate(rs.getBigDecimal("TaxRate"));
        t.setEffectiveFrom(rs.getDate("EffectiveFrom"));
        t.setExpiredDate(rs.getDate("ExpiredDate"));
        return t;
    }
}

