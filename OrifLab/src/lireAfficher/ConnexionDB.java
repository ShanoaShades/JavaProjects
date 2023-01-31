package lireAfficher;

import java.sql.*;

public class ConnexionDB {

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://hostname:port/database_name", "username", "password");
    }
}

