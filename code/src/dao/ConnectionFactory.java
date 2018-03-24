package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

 class ConnectionFactory {

    private static ConnectionFactory instance =new ConnectionFactory();
    private  static final String DBURL="jdbc:mysql://localhost:3306/school?useSSL=false";
    private static final String USER = "root";
    private static final String PASS = "deea1203";

    private ConnectionFactory(){}

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DBURL, USER, PASS);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return connection;

    }

     public static void close(Connection connection) {

         if (connection != null) {
             try {
                 connection.close();
             } catch (SQLException e) {
                 System.out.println(e);
             }
         }
     }

     public static void close(Statement statement) {
         if (statement != null) {
             try {
                 statement.close();
             } catch (SQLException e) {
                 System.out.println(e);
             }
         }
     }

     public static void close(ResultSet resultSet) {
         if (resultSet != null) {
             try {
                 resultSet.close();
             } catch (SQLException e) {
                 System.out.println(e);
             }
         }
     }


}



