package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Category;
import model.Product;
import model.Unit;

public class ProductDAO extends DBContext {

    public List<Product> getAllProducts() {
        List<Product> list = new ArrayList<>();
        CategoryDAO categoryDAO = new CategoryDAO();
        String sql = "SELECT ProductID, Code, Name, Price, Description, Image, UnitID, CategoryID, MinStock FROM Product";
        Category c = new Category();
        try (PreparedStatement st = connection.prepareStatement(sql); ResultSet rs = st.executeQuery()) {
        UnitDAO unitDAO = new UnitDAO();
        Unit u = new Unit();
            while (rs.next()) {
                Product p = new Product();
                p.setProductID(rs.getInt("ProductID"));
                p.setCode(rs.getString("Code"));
                p.setName(rs.getString("Name"));
                p.setPrice(rs.getBigDecimal("Price")); // Dùng BigDecimal cho tiền tệ
                p.setDescription(rs.getString("Description"));
                p.setImage(rs.getString("Image"));
                p.setUnitID(rs.getInt("UnitID"));
                p.setCategoryID(rs.getInt("CategoryID"));
                u = unitDAO.getById(rs.getInt("UnitID"));
                p.setUnitID(u.getUnitID());
                p.setMinStock(rs.getInt("MinStock"));
                list.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Product getProductByID(int id) {
        String sql = "SELECT ProductID, Code, Name, Price, Description, Image, UnitID, CategoryID, MinStock FROM Product WHERE ProductID = ?";

        try (PreparedStatement st = connection.prepareStatement(sql)) {
            st.setInt(1, id);
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    Product p = new Product();
                    p.setProductID(rs.getInt("ProductID"));
                    p.setCode(rs.getString("Code"));
                    p.setName(rs.getString("Name"));
                    p.setPrice(rs.getBigDecimal("Price"));
                    p.setDescription(rs.getString("Description"));
                    p.setImage(rs.getString("Image"));
                    p.setUnitID(rs.getInt("UnitID"));
                    p.setCategoryID(rs.getInt("CategoryID"));
                    p.setMinStock(rs.getInt("MinStock"));
                    return p;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void insertProduct(Product p) {
        String sql = "INSERT INTO Product (Code, Name, Price, Description, Image, UnitID, CategoryID, MinStock) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement st = connection.prepareStatement(sql)) {
            st.setString(1, p.getCode());
            st.setString(2, p.getName());
            st.setBigDecimal(3, p.getPrice());
            st.setString(4, p.getDescription());
            st.setString(5, p.getImage());

            st.setInt(6, p.getUnitID());
            st.setInt(7, p.getCategoryID());
            st.setInt(8, p.getMinStock());

            st.executeUpdate();
            System.out.println("Insert thành công product: " + p.getCode());
        } catch (SQLException e) {
            System.out.println("Lỗi insert: " + e.getMessage());
        }
    }

    // ===========================
    // 3. UPDATE (Cập nhật)
    // ===========================
    public void updateProduct(Product p) {
        String sql = "UPDATE Product SET Code=?, Name=?, Price=?, Description=?, Image=?, UnitID=?, CategoryID=?, MinStock=? WHERE ProductID=?";

        try (PreparedStatement st = connection.prepareStatement(sql)) {
            st.setString(1, p.getCode());
            st.setString(2, p.getName());
            st.setBigDecimal(3, p.getPrice());
            st.setString(4, p.getDescription());
            st.setString(5, p.getImage());
            st.setInt(6, p.getUnitID());
            st.setInt(7, p.getCategoryID());
            st.setInt(8, p.getMinStock());
            st.setInt(9, p.getProductID()); // Điều kiện WHERE

            st.executeUpdate();
            System.out.println("Update thành công product ID: " + p.getProductID());
        } catch (SQLException e) {
            System.out.println("Lỗi update: " + e.getMessage());
        }
    }

    // ===========================
    // 4. DELETE (Xóa)
    // ===========================
    public void deleteProduct(int id) {

        String sql = "DELETE FROM Product WHERE ProductID = ?";

        try (PreparedStatement st = connection.prepareStatement(sql)) {
            st.setInt(1, id);
            st.executeUpdate();
            System.out.println("Delete thành công product ID: " + id);
        } catch (SQLException e) {
            System.out.println("Lỗi delete: " + e.getMessage());
        }
    }

    public List<Product> getFilteredProducts(String search, String sortPrice, String categoryId, String unitId, int page, int pageSize) {
        List<Product> list = new ArrayList<>();

        StringBuilder sql = new StringBuilder("SELECT * FROM Product WHERE 1=1");
        List<Object> params = new ArrayList<>();

        // Search
        if (search != null && !search.trim().isEmpty()) {
            sql.append(" AND (Name LIKE ? OR Code LIKE ?)");
            params.add("%" + search + "%");
            params.add("%" + search + "%");
        }

        // Category
        if (categoryId != null && !categoryId.isEmpty()) {
            sql.append(" AND CategoryID = ?");
            params.add(Integer.parseInt(categoryId));
        }

        // Unit
        if (unitId != null && !unitId.isEmpty()) {
            sql.append(" AND UnitID = ?");
            params.add(Integer.parseInt(unitId));
        }

        // Sort
        sql.append(" ORDER BY ");
        if (sortPrice != null && !sortPrice.isEmpty()) {
            sql.append("Price ").append(sortPrice.equalsIgnoreCase("asc") ? "ASC" : "DESC");
        } else {
            sql.append("ProductID ASC");
        }

        // Pagination (SQL Server)
        sql.append(" OFFSET ? ROWS FETCH NEXT ? ROWS ONLY");
        params.add((page - 1) * pageSize);
        params.add(pageSize);

        try (PreparedStatement ps = connection.prepareStatement(sql.toString())) {
            for (int i = 0; i < params.size(); i++) {
                ps.setObject(i + 1, params.get(i));
            }

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product p = new Product(
                        rs.getInt("ProductID"),
                        rs.getString("Code"),
                        rs.getString("Name"),
                        rs.getBigDecimal("Price"),
                        rs.getString("Description"),
                        rs.getString("Image"),
                        rs.getInt("UnitID"),
                        rs.getInt("CategoryID"),
                        rs.getInt("MinStock")
                );
                list.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public int getTotalFilteredProducts(String search, String categoryId, String unitId) {
        StringBuilder sql = new StringBuilder("SELECT COUNT(*) FROM Product WHERE 1=1");
        List<Object> params = new ArrayList<>();

        if (search != null && !search.trim().isEmpty()) {
            sql.append(" AND (Name LIKE ? OR Code LIKE ?)");
            params.add("%" + search + "%");
            params.add("%" + search + "%");
        }

        if (categoryId != null && !categoryId.isEmpty()) {
            sql.append(" AND CategoryID = ?");
            params.add(Integer.parseInt(categoryId));
        }

        if (unitId != null && !unitId.isEmpty()) {
            sql.append(" AND UnitID = ?");
            params.add(Integer.parseInt(unitId));
        }

        try (PreparedStatement ps = connection.prepareStatement(sql.toString())) {
            for (int i = 0; i < params.size(); i++) {
                ps.setObject(i + 1, params.get(i));
            }

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    public static void main(String[] args) {
        ProductDAO dao = new ProductDAO();

        // 1. Test Read All
        System.out.println("--- LIST ALL PRODUCTS ---");
        List<Product> list = dao.getAllProducts();
        for (Product p : list) {

            System.out.println(p.toString());
        }

        // 2. Test Insert
        
        System.out.println("--- TEST INSERT ---");
        Product newP = new Product();
        newP.setCode("P0099");
        newP.setName("Laptop Gaming Test");
        newP.setPrice(new java.math.BigDecimal("1500.00"));
        newP.setUnitID(1); // Giả sử UnitID 1 đã tồn tại
        newP.setCategoryID(1); // Giả sử CategoryID 1 đã tồn tại
        newP.setMinStock(10);
        dao.insertProduct(newP);
         
        // 3. Test Update
        /*
        System.out.println("--- TEST UPDATE ---");
        Product pToUpdate = dao.getProductByID(1); // Lấy sp có ID = 1
        if(pToUpdate != null) {
            pToUpdate.setName("Updated Name");
            dao.updateProduct(pToUpdate);
        }
         */
        // 4. Test Delete
        /*
        System.out.println("--- TEST DELETE ---");
        dao.deleteProduct(99); // ID giả định
         */
    }

}
