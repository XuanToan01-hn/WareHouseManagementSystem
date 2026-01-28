package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Unit;

public class UnitDAO extends DBContext {

    public List<Unit> getAll() {
        List<Unit> list = new ArrayList<>();
        String sql = "SELECT UnitID, Name, Type FROM Unit";
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

    public Unit getById(int id) {
        String sql = "SELECT UnitID, Name, Type FROM Unit WHERE UnitID = ?";
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

    public boolean insert(Unit u) {
        String sql = "INSERT INTO Unit (Name, Type) VALUES (?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, u.getName());
            ps.setString(2, u.getType());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(Unit u) {
        String sql = "UPDATE Unit SET Name = ?, Type = ? WHERE UnitID = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, u.getName());
            ps.setString(2, u.getType());
            ps.setInt(3, u.getUnitID());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM Unit WHERE UnitID = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private Unit map(ResultSet rs) throws SQLException {
        Unit u = new Unit();
        u.setUnitID(rs.getInt("UnitID"));
        u.setName(rs.getString("Name"));
        u.setType(rs.getString("Type"));
        return u;
    }
}

