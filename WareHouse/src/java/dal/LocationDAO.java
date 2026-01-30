package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import model.Location;

public class LocationDAO extends DBContext {

    public List<Location> getAll() {
        List<Location> list = new ArrayList<>();
        String sql = "SELECT LocationID, Name, Address, Description, ParentLocationID, LocationType, MaxCapacity FROM [Location]";
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

    public Location getById(int id) {
        String sql = "SELECT LocationID, Name, Address, Description, ParentLocationID, LocationType, MaxCapacity FROM [Location] WHERE LocationID = ?";
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

    public boolean insert(Location l) {
        String sql = "INSERT INTO [Location] (Name, Address, Description, ParentLocationID, LocationType, MaxCapacity) "
                   + "VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, l.getName());
            ps.setString(2, l.getAddress());
            ps.setString(3, l.getDescription());
            if (l.getParentLocationID() == null) {
                ps.setNull(4, Types.INTEGER);
            } else {
                ps.setInt(4, l.getParentLocationID());
            }
            ps.setString(5, l.getLocationType());
            if (l.getMaxCapacity() == null) {
                ps.setNull(6, Types.INTEGER);
            } else {
                ps.setInt(6, l.getMaxCapacity());
            }
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(Location l) {
        String sql = "UPDATE [Location] "
                   + "SET Name = ?, Address = ?, Description = ?, ParentLocationID = ?, LocationType = ?, MaxCapacity = ? "
                   + "WHERE LocationID = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, l.getName());
            ps.setString(2, l.getAddress());
            ps.setString(3, l.getDescription());
            if (l.getParentLocationID() == null) {
                ps.setNull(4, Types.INTEGER);
            } else {
                ps.setInt(4, l.getParentLocationID());
            }
            ps.setString(5, l.getLocationType());
            if (l.getMaxCapacity() == null) {
                ps.setNull(6, Types.INTEGER);
            } else {
                ps.setInt(6, l.getMaxCapacity());
            }
            ps.setInt(7, l.getLocationID());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM [Location] WHERE LocationID = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private Location map(ResultSet rs) throws SQLException {
        Location l = new Location();
        l.setLocationID(rs.getInt("LocationID"));
        l.setName(rs.getString("Name"));
        l.setAddress(rs.getString("Address"));
        l.setDescription(rs.getString("Description"));
        int parentId = rs.getInt("ParentLocationID");
        l.setParentLocationID(rs.wasNull() ? null : parentId);
        l.setLocationType(rs.getString("LocationType"));
        int cap = rs.getInt("MaxCapacity");
        l.setMaxCapacity(rs.wasNull() ? null : cap);
        return l;
    }
}

