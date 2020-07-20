package Datos;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    private String driver;
    private String dbName;
    private String connectionURL;
    private String username;
    private String password;

    public Conexion() {
        driver = "com.mysql.jdbc.Driver";
        connectionURL = "jdbc:mysql://localhost/";
        dbName = "oficina";
        username = "root";
        password = "root";
    }
    
    public Connection obtenerConexion() throws Exception{
        Class.forName(driver);
        Connection conexion = DriverManager.getConnection(connectionURL+dbName+"?useSSL=false", username, password);
        return conexion;
    }
    
    /*public static void main(String[] args) {
        Conexion db = new Conexion();
        try {
            Connection con = db.obtenerConexion();
            System.out.println("Sí se pudo");
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
}
