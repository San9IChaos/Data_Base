import java.sql.*;

public class Main {
    public static String URL = "jdbc:mysql://localhost:3306/mydbtest";
    public static String USERNAME = "root";
    public static String PASSWORD = "04012003Ss";

    private static final String INSERT_NEW = "INSERT INTO dish VALUES (?,?,?,?)";
    private static final String GET_ALL = "SELECT * FROM dish";
    private static final String DELETE = "DELETE FROM dish WHERE id=?";

    public static void main(String[] args) {
        Connection connection;
        PreparedStatement preparedStatement;

        try {
              connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
//            preparedStatement = connection.prepareStatement(INSERT_NEW);
//            preparedStatement.setInt(1,3);
//            preparedStatement.setString(2,"Test");
//            preparedStatement.setString(3,"Test");
//            preparedStatement.setFloat(4, 0.5f);
//
//            preparedStatement.execute();
//
//            preparedStatement = connection.prepareStatement(DELETE);
//            preparedStatement.setInt(1,2);
//            preparedStatement.executeUpdate();

            preparedStatement = connection.prepareStatement(GET_ALL);

            ResultSet res = preparedStatement.executeQuery();

            while (res.next()){
                int id = res.getInt("id");
                String title = res.getString("title");
                String desc = res.getString("description");
                Float rating = res.getFloat("rating");

                System.out.println("id: " + id + ", title: " + title + ", description: " + desc + ", rating: " + rating);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
