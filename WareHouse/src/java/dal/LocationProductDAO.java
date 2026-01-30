package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import model.LocationProduct;

public class LocationProductDAO extends DBContext {

    public List<LocationProduct> getAll() {
        List<LocationProduct> list = new ArrayList<>();
        String sql = "SELECT LocationID, ProductID, ProductDetailID, Quantity, MaxStock FROM Location_Product";
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

    public List<LocationProduct> getByLocation(int locationId) {
        List<LocationProduct> list = new ArrayList<>();
        String sql = "SELECT LocationID, ProductID, ProductDetailID, Quantity, MaxStock "
                   + "FROM Location_Product WHERE LocationID = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, locationId);
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

    public LocationProduct getByKey(int locationId, int productId, int productDetailId) {
        String sql = "SELECT LocationID, ProductID, ProductDetailID, Quantity, MaxStock "
                   + "FROM Location_Product WHERE LocationID = ? AND ProductID = ? AND ProductDetailID = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, locationId);
            ps.setInt(2, productId);
            ps.setInt(3, productDetailId);
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

    public boolean insert(LocationProduct lp) {
        String sql = "INSERT INTO Location_Product (LocationID, ProductID, ProductDetailID, Quantity, MaxStock) "
                   + "VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, lp.getLocationID());
            ps.setInt(2, lp.getProductID());
            ps.setInt(3, lp.getProductDetailID());
            ps.setInt(4, lp.getQuantity());
            if (lp.getMaxStock() == null) {
                ps.setNull(5, Types.INTEGER);
            } else {
                ps.setInt(5, lp.getMaxStock());
            }
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(LocationProduct lp) {
        String sql = "UPDATE Location_Product SET Quantity = ?, MaxStock = ? "
                   + "WHERE LocationID = ? AND ProductID = ? AND ProductDetailID = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, lp.getQuantity());
            if (lp.getMaxStock() == null) {
                ps.setNull(2, Types.INTEGER);
            } else {
                ps.setInt(2, lp.getMaxStock());
            }
            ps.setInt(3, lp.getLocationID());
            ps.setInt(4, lp.getProductID());
            ps.setInt(5, lp.getProductDetailID());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(int locationId, int productId, int productDetailId) {
        String sql = "DELETE FROM Location_Product WHERE LocationID = ? AND ProductID = ? AND ProductDetailID = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, locationId);
            ps.setInt(2, productId);
            ps.setInt(3, productDetailId);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private LocationProduct map(ResultSet rs) throws SQLException {
        LocationProduct lp = new LocationProduct();
        lp.setLocationID(rs.getInt("LocationID"));
        lp.setProductID(rs.getInt("ProductID"));
        lp.setProductDetailID(rs.getInt("ProductDetailID"));
        lp.setQuantity(rs.getInt("Quantity"));
        int max = rs.getInt("MaxStock");
        lp.setMaxStock(rs.wasNull() ? null : max);
        return lp;
    }
}

