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
import java.sql.Statement;
import java.time.LocalDate;

/**
 *
 * @author luis_
 */
public class daoServicios implements EntidadesDB<Servicio>{

    @Override
    public void Agregar(Servicio Nuevo) {
        Conexion db = new Conexion();
        try {
            Connection conn = db.obtenerConexion();
            String query = "call agregarServicio(?,?,?)";
            PreparedStatement ps = conn.prepareCall(query);
            ps.setInt(1, Nuevo.getId_Cliente());
            ps.setString(2, Nuevo.getDescripcion());
            ps.setDate(3, java.sql.Date.valueOf(Nuevo.getFecha()));
            ps.execute();
        } catch (Exception e) {

        }
    }

    @Override
    public void Modificar(Servicio Actual) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
