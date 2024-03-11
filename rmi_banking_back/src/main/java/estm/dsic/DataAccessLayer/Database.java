package estm.dsic.DataAccessLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {

                connection = DriverManager.getConnection("jdbc:mysql://192.168.0.145:3306/rmi_banking", "root", "");
                return connection;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}
