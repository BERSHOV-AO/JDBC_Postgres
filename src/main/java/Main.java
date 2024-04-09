import java.sql.*;

public class Main {

    private static String dbURL = "jdbc:postgresql://localhost:5432/postgres";
    private static String dbUsername = "postgres";
    private static String dbPassword = "postgres";

    public static void main(String[] args) throws SQLException {


        Connection connection = DriverManager.getConnection(dbURL, dbUsername, dbPassword);

        Statement statement = connection.createStatement();

        // executeInsert(6, "'Sergey'", 27, "'Moscow'", statement);

        ResultSet resultSet = statement.executeQuery("select * from netology.users");

        while (resultSet.next()) {
//            System.out.print(resultSet.getInt(1) + " ");
//            System.out.print(resultSet.getString(2) + " ");
//            System.out.print(resultSet.getInt(3) + " ");
//            System.out.print(resultSet.getString(4) + "\n");

            //-------------------Вариант без нумерации---------------------
            System.out.print(resultSet.getInt("id") + " ");
            System.out.print(resultSet.getString("name") + " ");
            System.out.print(resultSet.getInt("age") + " ");
            System.out.print(resultSet.getString("address") + "\n");
            //-------------------------------------------------------------
        }

        // --------------------- Вызов процедуры удаленно ----------------------

        CallableStatement callableStatement = connection.prepareCall("select gen_random_uuid ()");
        ResultSet resultSet1 = callableStatement.executeQuery();

        while (resultSet1.next()) {
            System.out.println(resultSet1.getString(1));
        }

        statement.close();
        connection.close();

    }

    private static void executeInsert(int id, String name, int age, String address, Statement statement) throws SQLException {

        String sqlQuery = String.format("insert into netology.users (id, name, age, address)" +
                " values(%d, %s, %d, %s)", id, name, age, address);
        System.out.println(sqlQuery); // печатаем для наглядности
        statement.execute(sqlQuery);
    }
}
