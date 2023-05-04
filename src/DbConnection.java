import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private static final String url = "jdbc:sqlite:\\C:\\Program Files\\SQLiteStudio\\bank";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(url);
        } catch (ClassNotFoundException e) {
            System.err.println("Could not load JDBC driver");
            throw new RuntimeException(e);
        } catch (SQLException e) {
            System.err.println("Could not connect to database");
            throw new RuntimeException(e);
        }finally {
            try {
                assert connection != null;
                connection.close();
            } catch (SQLException e) {
                System.err.println("Can't able to close Connection");
                throw new RuntimeException(e);
            }
        }
        try {
            return DriverManager.getConnection(url);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
