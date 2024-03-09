package repositorio.controlador;

import java.util.List;
import repositorio.dao.ActividadMetodos;
import repositorio.dao.ProyectoMetodos;
import repositorio.modelo.PlanAmbiental;

/**
 *
 * @author hp
 */
public class ActividadServicio {

    public static List<PlanAmbiental> ListaActividades(String idProyecto) {
        return new ActividadMetodos().ListarActividades(idProyecto);

    }
        public static boolean EliminarActividad(Object idProyecto){
        return new ActividadMetodos().EliminarActividad(idProyecto);
    }

    public static boolean InsertarActividades(PlanAmbiental proyecto) {
        return new ActividadMetodos().InsertarActividad(proyecto);
    }

    public static boolean ActualizarActividad(PlanAmbiental actividad) {
        return new ActividadMetodos().ActualizarActividad(actividad);

    }
    
    public static PlanAmbiental BuscarActividad(Object idActividad){
        return new ActividadMetodos().BuscarActividad(idActividad);
    }

}
