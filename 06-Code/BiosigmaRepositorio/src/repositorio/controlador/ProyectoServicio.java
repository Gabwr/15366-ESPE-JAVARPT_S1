package repositorio.controlador;

import java.util.List;
import repositorio.dao.ProyectoMetodos;
import repositorio.modelo.Proyecto;

public class ProyectoServicio {
    
    public static List<Proyecto> listaProyectos(){
        return new ProyectoMetodos().ListarProyectos();
    }
    
    public static boolean InsertarProyecto(Proyecto proyecto){
        return new ProyectoMetodos().InsertarProyecto(proyecto);
    }
    
    public static boolean ActualizarProyecto(Proyecto proyecto){
        return new ProyectoMetodos().ActualizarProyecto(proyecto);
    }
    
    public static boolean EliminarProyecto(String idProyecto){
        return new ProyectoMetodos().EliminarProyecto(idProyecto);
    }
    
    public static boolean VerificarCodigoRepetido(String codigo){
        return new ProyectoMetodos().VerificarCodigoRepetido(codigo);
    }
}
