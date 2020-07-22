package Datos;

import java.sql.ResultSet;

public interface EntidadesDB <T> {
    public void Agregar(T Nuevo);
    public void Modificar(T Nuevo);
    public ResultSet ObtenerTodos();
    public T ObtenerUno(int Clave);
}
