package utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class  ConnectionFactory {
    private static Connection connection = null;
    private ConnectionFactory() {
    }

    public static Connection getConnection()  {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if (connection == null) {
            String url = "jdbc:mysql://localhost:3306/demo";
            String username ="root";
            String password ="Ale.zubi99";

            try {
                connection = DriverManager.getConnection(url, username, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

}




// String username = bundle.getString("username");
           // String password = bundle.getString("password");



