package conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    public static Connection getConexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/empresa",
                    "root",
                    ""
            );
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}