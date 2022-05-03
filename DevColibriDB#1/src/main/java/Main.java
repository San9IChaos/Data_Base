import java.sql.*;

public class Main {
    private static final String URL = "jdbc:mysql://localhost:3306/mydbtest";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "04012003Ss";
    public static Statement statement;
    public static Connection connection;

    static{
        try {
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static{
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws SQLException {
        //statement.execute("INSERT INTO users1 (name,age,email) values ('John',54,'john@gmail.com')");
        //statement.executeUpdate("UPDATE users1 SET age = 53 WHERE id = 5");
        //ResultSet resultSet = statement.executeQuery("SELECT * FROM users1");
        //statement.addBatch("INSERT INTO users1 (name,age,email) values ('Elon',50,'Elon@gmail.com')");
        //statement.addBatch("INSERT INTO users1 (name,age,email) values ('Mari',27,'Mari@gmail.com')");
        //statement.addBatch("INSERT INTO users1 (name,age,email) values ('Kris',18,'Kris@gmail.com')");
        //statement.executeBatch();

        //statement.clearBatch();

        //statement.getConnection();

        //statement.close();
    }
}
