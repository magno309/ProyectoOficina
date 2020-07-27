/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Modelo.Servicio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author luis_
 */
public class daoServicios implements EntidadesDB<Servicio>{

    @Override
    public void Agregar(Servicio Nuevo) {
        Conexion db = new Conexion();
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = db.obtenerConexion();
            String query = "call agregarServicio(?,?,?)";
            ps = conn.prepareCall(query);
            ps.setInt(1, Nuevo.getId_Cliente());
            ps.setString(2, Nuevo.getDescripcion());
            ps.setDate(3, java.sql.Date.valueOf(Nuevo.getFecha()));
            ps.execute();
        } catch (Exception e) {

        }
    }

    @Override
    public void Modificar(Servicio Actual) {
        Conexion db = new Conexion();
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = db.obtenerConexion();
            String query = "update Servicios Fecha = ?, Descripcion = ? where Id_Servicio = ?";
            ps = conn.prepareCall(query);
            ps.setDate(1, java.sql.Date.valueOf(Actual.getFecha()));
            ps.setString(2, Actual.getDescripcion());
            ps.setInt(3, Actual.getId());
            ps.execute();
        } catch (Exception e) {

        }
    }

    @Override
    public ResultSet ObtenerTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Servicio ObtenerUno(int Clave) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public ResultSet ObtenerTodosPorCliente(int Clave) {
        Conexion db = new Conexion();
        try {
            Connection conn = db.obtenerConexion();
            String query = "select * from Servicios where Id_Cliente = ? order by fecha asc;";
            PreparedStatement ps = conn.prepareCall(query);
            ps.setInt(1, Clave);
            return ps.executeQuery();
        } catch (Exception e) {
            return null;
        }
    }
    
}
