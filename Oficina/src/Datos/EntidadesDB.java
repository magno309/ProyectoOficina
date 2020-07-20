package Datos;

import java.sql.ResultSet;

public interface EntidadesDB <T> {
    public void Agregar(T Nuevo);
    public void Modificar(T Actual);
    public ResultSet ObtenerTodos();
    public T ObtenerUno(int Clave);
}
