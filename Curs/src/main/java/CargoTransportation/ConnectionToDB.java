package CargoTransportation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionToDB {

    static private Connection connection = null;

    public static Connection ConnectToDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/CargoTransportation?useUnicode=true&serverTimezone=UTC", "root", "root");
            System.out.println("Connection established!");
            return connection;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public static void closeConnection(){
        try {
            connection.close();
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("Connection closed!");
        }
    }

    public static Connection getConnection() {
        return connection;
    }

    public static void setConnection(Connection connection) {
        ConnectionToDB.connection = connection;
    }
}
