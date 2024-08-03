package StreamEx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	    private static final String URL = "jdbc:mysql://localhost:3306/employees";
	    private static final String USER = "root";
	    private static final String PASSWORD = "12345";

	    static {
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	        } catch (ClassNotFoundException e) {
	            throw new RuntimeException("Failed to load MySQL driver", e);
	        }
	    }

	    public static Connection getConnection() throws SQLException {
	        return DriverManager.getConnection(URL, USER, PASSWORD);
	    }
}
