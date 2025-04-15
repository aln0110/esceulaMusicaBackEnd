package Data;
import java.sql.Connection;
import java.sql.DriverManager;
public class DataBase {
    private static Connection conn;
    private static final String URL = "jdbc:mysql://localhost:3306/bdescuelamusica";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() {
        String Driver = "com.mysql.cj.jdbc.Driver";
        try {
            Class.forName(Driver);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to the db");
        } catch (Exception e) {
            System.out.println("Faild to connect the db: " + e.getMessage());
        }
        return conn;
    }

    public static void closeConnection() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("Connection closed");
            }
        } catch (Exception e) {
            System.out.println("Failed to close the connection: " + e.getMessage());
        }
    }
}
