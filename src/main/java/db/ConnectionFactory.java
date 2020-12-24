package db;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
    public static Connection getConnection() {
        Connection connection = null;
        Properties connectionProperties = new Properties();
        InputStream fileInputStream = null;
        try {
            fileInputStream = ConnectionFactory.class.getClassLoader().getResourceAsStream("db.properties");
            connectionProperties.load(fileInputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(
                    (String) connectionProperties.get("url"),
                    connectionProperties);
            /*connection = DriverManager.getConnection(
                    (String)connectionProperties.get("url"),
                    (String)connectionProperties.get("user"),
                    (String)connectionProperties.get("password"));


*/
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }
}
