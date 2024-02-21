package repositorio.dao;

import java.util.List;
import repositorio.modelo.Proyecto;

public interface IProyecto {
    public List<Proyecto> ListarProyectos();
    public boolean InsertarProyecto(Proyecto proyecto);
    public boolean ActualizarProyecto(Proyecto proyecto);
    public boolean EliminarProyecto(String idProyecto);
    public boolean VerificarCodigoRepetido(String codigo);
    public Proyecto BuscarProyecto(String codigo);
}
