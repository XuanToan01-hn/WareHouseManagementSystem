package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBContext {
    protected Connection connection;

        public DBContext()
    {
        //@Students: You are allowed to edit user, pass, url variables to fit 
        //your system configuration
        //You can also add more methods for Database Interaction tasks. 
        //But we recommend you to do it in another class
        // For example : StudentDBContext extends DBContext , 
        //where StudentDBContext is located in dal package, 
        try {
            String user = "sa";
            String pass = "123";
//            String url = "jdbc:sqlserver://localhost\\SQLEXPRESS:1433;databaseName=SE1919";
            String url = "jdbc:sqlserver://localhost\\SQLEXPRESS:1433;databaseName=InventoryPro_Full_V3";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Main method to test the database connection.
     * If you are running this in an IDE, ensure you have the SQL Server JDBC driver added to your project's libraries.
     */
    public static void main(String[] args) {
        // Create an instance of DBContext to attempt the connection
        DBContext db = new DBContext();

        System.out.println("--- BẮT ĐẦU KIỂM TRA KẾT NỐI DATABASE ---");

        if (db.connection != null) {
            System.out.println("✅ Kết nối cơ sở dữ liệu 'warehouseDB' thành công!");

            // Close the connection
            try {
                db.connection.close();
                System.out.println("Đã đóng kết nối.");
            } catch (SQLException e) {
                System.out.println("Lỗi khi đóng kết nối: " + e.getMessage());
            }
        } else {
            System.out.println("❌ Kết nối cơ sở dữ liệu thất bại.");
            System.out.println("Kiểm tra lại các yếu tố sau:");
            System.out.println("1. **Driver SQL Server (JDBC)** đã được thêm vào dự án.");
            System.out.println("2. **Thông tin đăng nhập** (sa/123) và **databaseName** (warehouseDB) chính xác.");
            System.out.println("3. **SQL Server** có đang chạy và cho phép kết nối từ xa trên cổng 1433.");
        }
    }
}