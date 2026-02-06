package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.PurchaseOrder;

import javax.xml.transform.Result;

public class PurchaseOrderDAO extends DBContext {

    public List<PurchaseOrder> getAll() {
        List<PurchaseOrder> list = new ArrayList<>();
        String sql = "SELECT PurchaseOrderID, OrderCode, SupplierID, Status, CreatedDate, TotalAmount, CreateBy FROM Purchase_Order";
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

    public PurchaseOrder getById(int id) {
        String sql = "SELECT PurchaseOrderID, OrderCode, SupplierID, Status, CreatedDate, TotalAmount, CreateBy "
                   + "FROM Purchase_Order WHERE PurchaseOrderID = ?";
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

    public boolean insert(PurchaseOrder po) {
        String sql = "INSERT INTO Purchase_Order (OrderCode, SupplierID, Status, TotalAmount, CreateBy) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, po.getOrderCode());
            ps.setInt(2, po.getSupplierID());
            ps.setInt(3, po.getStatus());
            ps.setBigDecimal(4, po.getTotalAmount());
            ps.setInt(5, po.getCreateBy());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(PurchaseOrder po) {
        String sql = "UPDATE Purchase_Order SET OrderCode = ?, SupplierID = ?, Status = ?, TotalAmount = ?, CreateBy = ? "
                   + "WHERE PurchaseOrderID = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, po.getOrderCode());
            ps.setInt(2, po.getSupplierID());
            ps.setInt(3, po.getStatus());
            ps.setBigDecimal(4, po.getTotalAmount());
            ps.setInt(5, po.getCreateBy());
            ps.setInt(6, po.getPurchaseOrderID());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM Purchase_Order WHERE PurchaseOrderID = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private PurchaseOrder map(ResultSet rs) throws SQLException {
        PurchaseOrder po = new PurchaseOrder();
        po.setPurchaseOrderID(rs.getInt("PurchaseOrderID"));
        po.setOrderCode(rs.getString("OrderCode"));
        po.setSupplierID(rs.getInt("SupplierID"));
        po.setStatus(rs.getInt("Status"));
        po.setCreatedDate(rs.getTimestamp("CreatedDate"));
        po.setTotalAmount(rs.getBigDecimal("TotalAmount"));
        po.setCreateBy(rs.getInt("CreateBy"));
        return po;
    }
    public int getLatestPurchaseOrderID() {
        String sql = "SELECT TOP 1 PurchaseOrderID FROM [dbo].[Purchase_Order] ORDER BY PurchaseOrderID DESC";
        int lastId = 1;

        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                lastId = rs.getInt("PurchaseOrderID");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lastId;
    }
//    public String generatePOID(){
//        String sql= "select top 1 PurchaseOrderID from [InventoryPro_Full_V3].[dbo].[Purchase_Order]\n" +
//                      "ORDER BY PurchaseOrderID DESC\n";
//        String prefix= "PO";
//        String newID="PO001";
//        try(PreparedStatement ps = connection.prepareStatement(sql);) {
//            ResultSet rs = ps.executeQuery();
//            if(rs.next()){
//                String id= rs.getString("PurchaseOrderID");
//                if(id!=null && id.startsWith(prefix)){
//                    int num= Integer.parseInt(id.substring(prefix.length()));
//                    num++;
//                    newID=String.format("%s%03d",prefix,num);
//                }
//            }
//
//        } catch (SQLException e){
//            e.printStackTrace();
//        }
//        return newID;
//    }
    public static void main(String[] args) {
        PurchaseOrderDAO a = new PurchaseOrderDAO();

    }
}

