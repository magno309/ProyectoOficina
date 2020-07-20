package Modelo;

import java.util.Date;

public class Servicio {
    private int Id;
    private int Id_Cliente;
    private String Descripcion;
    private Date Fecha;

    public Servicio(int Id, int Id_Cliente, String Descripcion, Date Fecha) {
        this.Id = Id;
        this.Id_Cliente = Id_Cliente;
        this.Descripcion = Descripcion;
        this.Fecha = Fecha;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getId_Cliente() {
        return Id_Cliente;
    }

    public void setId_Cliente(int Id_Cliente) {
        this.Id_Cliente = Id_Cliente;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }
    
    
}
