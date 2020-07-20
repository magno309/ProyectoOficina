package Datos;

import Modelo.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class daoClientes implements EntidadesDB<Cliente> {

    @Override
    public void Agregar(Cliente nuevoCliente) {
        Conexion db = new Conexion();
        try {
            Connection conn = db.obtenerConexion();
            String query = "call agregarCliente(?,?,?,?)";
            PreparedStatement ps = conn.prepareCall(query);
            ps.setString(1, nuevoCliente.getNombre());
            ps.setString(2, nuevoCliente.getDireccion());
            ps.setString(3, nuevoCliente.getTelefono());
            ps.setString(4, nuevoCliente.getCelular());
            ps.execute();
        } catch (Exception e) {

        }
    }

    @Override
    public void Modificar(Cliente actual) {

    }

    @Override
    public ResultSet ObtenerTodos() {
        Conexion db = new Conexion();
        try {
            Connection conn = db.obtenerConexion();
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery("select * from Clientes;");
            //s.close();
            return rs;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Cliente ObtenerUno(int Clave) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ResultSet BuscarPorNombre(String Nombre) {
        Conexion db = new Conexion();
        try {
            Connection conn = db.obtenerConexion();
            Nombre+="%";
            String query = "select * from Clientes where Nombre like ?";
            PreparedStatement ps = conn.prepareCall(query);
            ps.setString(1, Nombre);
            ResultSet rs = ps.executeQuery();
            //ps.close();
            return rs;
        } catch (Exception e) {
            return null;
        }
    }

}
