package lireAfficher;

import java.sql.*;

public class ConnexionDB {

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/lire_afficher","root","");
    }
}

