package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.TransferOrder;

public class TransferOrderDAO extends DBContext {

    public List<TransferOrder> getAll() {
        List<TransferOrder> list = new ArrayList<>();
        String sql = "SELECT TransferOrderID, TransferCode, FromLocationID, ToLocationID, TransferDate, Status, Note, CreateBy "
                   + "FROM Transfer_Order";
        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) list.add(map(rs));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public TransferOrder getById(int id) {
        String sql = "SELECT TransferOrderID, TransferCode, FromLocationID, ToLocationID, TransferDate, Status, Note, CreateBy "
                   + "FROM Transfer_Order WHERE TransferOrderID = ?";
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

    public TransferOrder getByCode(String code) {
        String sql = "SELECT TransferOrderID, TransferCode, FromLocationID, ToLocationID, TransferDate, Status, Note, CreateBy "
                   + "FROM Transfer_Order WHERE TransferCode = ?";
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

    public boolean insert(TransferOrder t) {
        String sql = "INSERT INTO Transfer_Order (TransferCode, FromLocationID, ToLocationID, Status, Note, CreateBy) "
                   + "VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, t.getTransferCode());
            ps.setInt(2, t.getFromLocationID());
            ps.setInt(3, t.getToLocationID());
            ps.setInt(4, t.getStatus());
            ps.setString(5, t.getNote());
            ps.setInt(6, t.getCreateBy());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(TransferOrder t) {
        String sql = "UPDATE Transfer_Order SET TransferCode = ?, FromLocationID = ?, ToLocationID = ?, Status = ?, Note = ?, CreateBy = ? "
                   + "WHERE TransferOrderID = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, t.getTransferCode());
            ps.setInt(2, t.getFromLocationID());
            ps.setInt(3, t.getToLocationID());
            ps.setInt(4, t.getStatus());
            ps.setString(5, t.getNote());
            ps.setInt(6, t.getCreateBy());
            ps.setInt(7, t.getTransferOrderID());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM Transfer_Order WHERE TransferOrderID = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private TransferOrder map(ResultSet rs) throws SQLException {
        TransferOrder t = new TransferOrder();
        t.setTransferOrderID(rs.getInt("TransferOrderID"));
        t.setTransferCode(rs.getString("TransferCode"));
        t.setFromLocationID(rs.getInt("FromLocationID"));
        t.setToLocationID(rs.getInt("ToLocationID"));
        t.setTransferDate(rs.getTimestamp("TransferDate"));
        t.setStatus(rs.getInt("Status"));
        t.setNote(rs.getString("Note"));
        t.setCreateBy(rs.getInt("CreateBy"));
        return t;
    }
}

