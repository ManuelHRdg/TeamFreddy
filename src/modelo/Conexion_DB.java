package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion_DB {
    public String driver = "com.mysql.jdbc.Driver";
    public String database = "proyecto_farmacia";
    public String hostname = "localhost";
    public String port = "3306";
    public String url = "jdbc:mariadb://localhost/proyecto_farmacia" + "?useSSL=false&serverTimezone=UTC&useLegacyDatetimeCode=false";
    public String username = "equipo_metodologia";
    public String password = "desarrollo";

    public Connection conectarMySQL() throws Exception{
        Connection conn = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            throw new Exception("Error en la ConexionDB la causa es: " + e.getCause().toString());
        }
        return conn;
    }
}