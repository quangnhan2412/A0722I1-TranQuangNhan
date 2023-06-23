package bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "12345";
    private static final String HOST = "localhost";
    private static final String DATABASE = "toa_nha_TComplex";
    private static final String PORT = "3308";

    private static Connection connection;

    public static Connection getConnection () {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); //nap driver
            connection = DriverManager.getConnection("jdbc:mysql://"+HOST+":"+PORT+"/"+DATABASE, USER_NAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    public static void close(){
        try {
            if(connection != null){
                connection.close();
            }
        } catch (SQLException throwAbles) {
            throwAbles.printStackTrace();
        }
    }
}
