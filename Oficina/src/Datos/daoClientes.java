package Datos;

import Modelo.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class daoClientes implements EntidadesDB<Cliente> {

    @Override
    public void Agregar(Cliente nuevoCliente) {
        Conexion db = new Conexion();
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = db.obtenerConexion();
            String query = "call agregarCliente(?,?,?,?,?)";
            ps = conn.prepareCall(query);
            ps.setString(1, nuevoCliente.getNombre());
            ps.setString(2, nuevoCliente.getDireccion());
            ps.setString(3, nuevoCliente.getCiudad());
            ps.setString(4, nuevoCliente.getTelefono());
            ps.setString(5, nuevoCliente.getCelular());
            ps.execute();
        } catch (Exception e) {

        } finally {
            try {
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(daoClientes.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(daoClientes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void Modificar(Cliente Nuevo) {
        Conexion db = new Conexion();
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = db.obtenerConexion();
            String query = "update Clientes"
                    + " set Nombre = ?, Direccion = ?, Ciudad = ?, Telefono = ?, Celular = ?"
                    + " where Id_Cliente = ?";
            ps = conn.prepareCall(query);
            ps.setString(1, Nuevo.getNombre());
            ps.setString(2, Nuevo.getDireccion());
            ps.setString(3, Nuevo.getCiudad());
            ps.setString(4, Nuevo.getTelefono());
            ps.setString(5, Nuevo.getCelular());
            ps.setInt(6, Nuevo.getId());
            ps.execute();
        } catch (Exception e) {

        }
    }

    @Override
    public ResultSet ObtenerTodos() {
        Conexion db = new Conexion();
        Connection conn = null;
        Statement s = null;
        ResultSet rs = null;
        try {
            conn = db.obtenerConexion();
            s = conn.createStatement();
            rs = s.executeQuery("select * from Clientes order by nombre asc;");
            return rs;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Cliente ObtenerUno(int Clave) {
        Conexion db = new Conexion();
        try {
            Connection conn = db.obtenerConexion();
            String query = "select * from Clientes where Id_Cliente = ?";
            PreparedStatement ps = conn.prepareCall(query);
            ps.setInt(1, Clave);
            ResultSet rs = ps.executeQuery();
            //ps.close();
            return new Cliente((int) rs.getObject(1), rs.getObject(2).toString(), rs.getObject(3).toString(), rs.getObject(4).toString(), rs.getObject(5).toString(), rs.getObject(6).toString());
        } catch (Exception e) {
            return null;
        }
    }

    public ResultSet BuscarPorNombre(String Nombre) {
        Conexion db = new Conexion();
        try {
            Connection conn = db.obtenerConexion();
            Nombre += "%";
            String query = "select * from Clientes where Nombre like ? order by nombre asc";
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
