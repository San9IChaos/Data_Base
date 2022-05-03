import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBWorker {

    private final String URL = "jdbc:mysql://localhost:3306/mydbtest";
    private final String USERNAME = "root";
    private final String PASSWORD = "04012003Ss";

    private Connection connection;

    public DBWorker() throws SQLException {

        connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);

    }

    public Connection getConnection() {
        return connection;
    }
}
