package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.ProductDetail;

public class ProductDetailDAO extends DBContext {

    public List<ProductDetail> getAll() {
        List<ProductDetail> list = new ArrayList<>();
        String sql = "SELECT ProductDetailID, ProductID, LotNumber, SerialNumber, Color, ManufactureDate "
                   + "FROM Product_Detail";
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

    public ProductDetail getById(int id) {
        String sql = "SELECT ProductDetailID, ProductID, LotNumber, SerialNumber, Color, ManufactureDate "
                   + "FROM Product_Detail WHERE ProductDetailID = ?";
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

    public List<ProductDetail> getByProductId(int productId) {
        List<ProductDetail> list = new ArrayList<>();
        String sql = "SELECT ProductDetailID, ProductID, LotNumber, SerialNumber, Color, ManufactureDate "
                   + "FROM Product_Detail WHERE ProductID = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, productId);
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

    public boolean insert(ProductDetail pd) {
        String sql = "INSERT INTO Product_Detail (ProductID, LotNumber, SerialNumber, Color, ManufactureDate) "
                   + "VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, pd.getProductID());
            ps.setString(2, pd.getLotNumber());
            ps.setString(3, pd.getSerialNumber());
            ps.setString(4, pd.getColor());
            ps.setDate(5, pd.getManufactureDate());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(ProductDetail pd) {
        String sql = "UPDATE Product_Detail "
                   + "SET ProductID = ?, LotNumber = ?, SerialNumber = ?, Color = ?, ManufactureDate = ? "
                   + "WHERE ProductDetailID = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, pd.getProductID());
            ps.setString(2, pd.getLotNumber());
            ps.setString(3, pd.getSerialNumber());
            ps.setString(4, pd.getColor());
            ps.setDate(5, pd.getManufactureDate());
            ps.setInt(6, pd.getProductDetailID());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM Product_Detail WHERE ProductDetailID = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private ProductDetail map(ResultSet rs) throws SQLException {
        ProductDetail pd = new ProductDetail();
        pd.setProductDetailID(rs.getInt("ProductDetailID"));
        pd.setProductID(rs.getInt("ProductID"));
        pd.setLotNumber(rs.getString("LotNumber"));
        pd.setSerialNumber(rs.getString("SerialNumber"));
        pd.setColor(rs.getString("Color"));
        pd.setManufactureDate(rs.getDate("ManufactureDate"));
        return pd;
    }
}

