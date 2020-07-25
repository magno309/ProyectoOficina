package Modelo;

import java.time.LocalDate;

public class Servicio {
    private int Id;
    private int Id_Cliente;
    private String Descripcion;
    private LocalDate Fecha;

    public Servicio(){}
    
    public Servicio(int Id, int Id_Cliente, String Descripcion, LocalDate Fecha) {
        this.Id = Id;
        this.Id_Cliente = Id_Cliente;
        this.Descripcion = Descripcion;
        this.Fecha = Fecha;
    }

    public int getId() {
        return Id;
    }

    public int getId_Cliente() {
        return Id_Cliente;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public LocalDate getFecha() {
        return Fecha;
    }

    public void setFecha(LocalDate Fecha) {
        this.Fecha = Fecha;
    }
    
    
}
