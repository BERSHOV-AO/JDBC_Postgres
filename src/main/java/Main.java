import java.sql.*;

public class Main {

    private static String dbURL = "jdbc:postgresql://localhost:5432/postgres";
    private static String dbUsername = "postgres";
    private static String dbPassword = "postgres";

    public static void main(String[] args) throws SQLException {


        Connection connection = DriverManager.getConnection(dbURL, dbUsername, dbPassword);

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("select * from netology.users");

        while (resultSet.next()) {
            System.out.println(resultSet.getInt(1) + " ");
            System.out.println(resultSet.getString(2) + " ");
            System.out.println(resultSet.getInt(3) + " ");
            System.out.println(resultSet.getString(4) + " ");
        }
    }
}
