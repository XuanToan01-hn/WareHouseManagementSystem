package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import model.GoodIssue;

public class GoodIssueDAO extends DBContext {

    public List<GoodIssue> getAll() {
        List<GoodIssue> list = new ArrayList<>();
        String sql = "SELECT IssueID, IssueCode, SalesOrderID, LocationID, IssueDate, Status, Note, CreateBy "
                   + "FROM Goods_Issue";
        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) list.add(map(rs));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public GoodIssue getById(int id) {
        String sql = "SELECT IssueID, IssueCode, SalesOrderID, LocationID, IssueDate, Status, Note, CreateBy "
                   + "FROM Goods_Issue WHERE IssueID = ?";
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

    public GoodIssue getByCode(String code) {
        String sql = "SELECT IssueID, IssueCode, SalesOrderID, LocationID, IssueDate, Status, Note, CreateBy "
                   + "FROM Goods_Issue WHERE IssueCode = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, code);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return map(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean insert(GoodIssue gi) {
        String sql = "INSERT INTO Goods_Issue (IssueCode, SalesOrderID, LocationID, Status, Note, CreateBy) "
                   + "VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, gi.getIssueCode());
            if (gi.getSalesOrderID() == null) {
                ps.setNull(2, Types.INTEGER);
            } else {
                ps.setInt(2, gi.getSalesOrderID());
            }
            ps.setInt(3, gi.getLocationID());
            ps.setInt(4, gi.getStatus());
            ps.setString(5, gi.getNote());
            ps.setInt(6, gi.getCreateBy());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(GoodIssue gi) {
        String sql = "UPDATE Goods_Issue SET IssueCode = ?, SalesOrderID = ?, LocationID = ?, Status = ?, Note = ?, CreateBy = ? "
                   + "WHERE IssueID = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, gi.getIssueCode());
            if (gi.getSalesOrderID() == null) {
                ps.setNull(2, Types.INTEGER);
            } else {
                ps.setInt(2, gi.getSalesOrderID());
            }
            ps.setInt(3, gi.getLocationID());
            ps.setInt(4, gi.getStatus());
            ps.setString(5, gi.getNote());
            ps.setInt(6, gi.getCreateBy());
            ps.setInt(7, gi.getIssueID());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM Goods_Issue WHERE IssueID = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private GoodIssue map(ResultSet rs) throws SQLException {
        GoodIssue gi = new GoodIssue();
        gi.setIssueID(rs.getInt("IssueID"));
        gi.setIssueCode(rs.getString("IssueCode"));
        int soId = rs.getInt("SalesOrderID");
        gi.setSalesOrderID(rs.wasNull() ? null : soId);
        gi.setLocationID(rs.getInt("LocationID"));
        gi.setIssueDate(rs.getTimestamp("IssueDate"));
        gi.setStatus(rs.getInt("Status"));
        gi.setNote(rs.getString("Note"));
        gi.setCreateBy(rs.getInt("CreateBy"));
        return gi;
    }
}

