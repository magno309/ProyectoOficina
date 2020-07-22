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
    public void Modificar(Cliente Nuevo) {
        Conexion db = new Conexion();
        try {
            Connection conn = db.obtenerConexion();
            String query = "update Clientes"
                    + " set Nombre = ?, Direccion = ?, Telefono = ?, Celular = ?"
                    + " where Id_Cliente = ?";
            PreparedStatement ps = conn.prepareCall(query);
            ps.setString(1, Nuevo.getNombre());
            ps.setString(2, Nuevo.getDireccion());
            ps.setString(3, Nuevo.getTelefono());
            ps.setString(4, Nuevo.getCelular());
            ps.setInt(5, Nuevo.getId());
            ps.execute();
        } catch (Exception e) {

        }
    }

    @Override
    public ResultSet ObtenerTodos() {
        Conexion db = new Conexion();
        try {
            Connection conn = db.obtenerConexion();
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery("select * from Clientes;");
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
            return new Cliente((int) rs.getObject(1), rs.getObject(2).toString(), rs.getObject(3).toString(), rs.getObject(4).toString(), rs.getObject(5).toString());
        } catch (Exception e) {
            return null;
        }
    }

    public ResultSet BuscarPorNombre(String Nombre) {
        Conexion db = new Conexion();
        try {
            Connection conn = db.obtenerConexion();
            Nombre += "%";
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
