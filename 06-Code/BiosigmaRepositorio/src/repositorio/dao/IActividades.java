package repositorio.dao;

import java.util.List;
import repositorio.modelo.PlanAmbiental;
import repositorio.modelo.Proyecto;

/**
 *
 * @author hp
 */
public interface IActividades {

    public List<PlanAmbiental> ListarActividades(String idProyecto);

    public boolean InsertarActividad(PlanAmbiental actividad);

    public boolean ActualizarActividad(PlanAmbiental actividad);
    
    public PlanAmbiental BuscarActividad(Object idActividad);

}
