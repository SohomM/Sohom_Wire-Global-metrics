import java.sql.*;


public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/smartstudent";
    private static final String USER = "root";
    private static final String PASS = ""; // Update with your password


    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}