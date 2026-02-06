package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.GoodIssueDetail;

public class GoodIssueDetailDAO extends DBContext {

    public List<GoodIssueDetail> getByIssueId(int issueId) {
        List<GoodIssueDetail> list = new ArrayList<>();
        String sql = "SELECT IssueDetailID, IssueID, ProductDetailID, Quantity_Expected, Quantity_Actual "
                   + "FROM Goods_Issue_Detail WHERE IssueID = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, issueId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) list.add(map(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public GoodIssueDetail getById(int id) {
        String sql = "SELECT IssueDetailID, IssueID, ProductDetailID, Quantity_Expected, Quantity_Actual "
                   + "FROM Goods_Issue_Detail WHERE IssueDetailID = ?";
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

    public boolean insert(GoodIssueDetail d) {
        String sql = "INSERT INTO Goods_Issue_Detail (IssueID, ProductDetailID, Quantity_Expected, Quantity_Actual) "
                   + "VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, d.getIssueID());
            ps.setInt(2, d.getProductDetailID());
            ps.setInt(3, d.getQuantityExpected());
            ps.setInt(4, d.getQuantityActual());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(GoodIssueDetail d) {
        String sql = "UPDATE Goods_Issue_Detail SET IssueID = ?, ProductDetailID = ?, Quantity_Expected = ?, Quantity_Actual = ? "
                   + "WHERE IssueDetailID = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, d.getIssueID());
            ps.setInt(2, d.getProductDetailID());
            ps.setInt(3, d.getQuantityExpected());
            ps.setInt(4, d.getQuantityActual());
            ps.setInt(5, d.getIssueDetailID());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM Goods_Issue_Detail WHERE IssueDetailID = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private GoodIssueDetail map(ResultSet rs) throws SQLException {
        GoodIssueDetail d = new GoodIssueDetail();
        d.setIssueDetailID(rs.getInt("IssueDetailID"));
        d.setIssueID(rs.getInt("IssueID"));
        d.setProductDetailID(rs.getInt("ProductDetailID"));
        d.setQuantityExpected(rs.getInt("Quantity_Expected"));
        d.setQuantityActual(rs.getInt("Quantity_Actual"));
        return d;
    }
}

