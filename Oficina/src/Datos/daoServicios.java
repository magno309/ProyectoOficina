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
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luis_
 */
public class daoServicios implements EntidadesDB<Servicio>{

    
    Conexion db;
    
    public daoServicios() throws SQLException{
        db = new Conexion();
        /*try {
            db.obtenerConexion();
        } catch (Exception ex) {
            throw new SQLException("No se ha podido conectar a la base de datos");
        }*/
        
    }

    public Conexion getDb() {
        return db;
    }

    public void setDb(Conexion db) {
        this.db = db;
    }
    
    @Override
    public void Agregar(Servicio Nuevo) {
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

        }finally {
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
    public void Modificar(Servicio Actual) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = db.obtenerConexion();
            String query = "update Servicios set Fecha = ?, Descripcion = ? where Id_Servicio = ?";
            ps = conn.prepareCall(query);
            ps.setDate(1, java.sql.Date.valueOf(Actual.getFecha()));
            ps.setString(2, Actual.getDescripcion());
            ps.setInt(3, Actual.getId());
            ps.execute();
        } catch (Exception e) {

        }
        finally {
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
    public ResultSet ObtenerTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Servicio ObtenerUno(int Clave) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public ResultSet ObtenerTodosPorCliente(int Clave) {
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
