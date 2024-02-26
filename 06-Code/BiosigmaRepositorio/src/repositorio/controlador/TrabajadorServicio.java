
package repositorio.controlador;

import java.util.List;
import repositorio.dao.TrabajadorMetodos;
import repositorio.modelo.PersonaTrabajador;


public class TrabajadorServicio {
    public static List<PersonaTrabajador> ListarTrabajadores(){
        return new TrabajadorMetodos().ListarTrabajadores();
    }
    public static boolean InsertarTrabajadores(PersonaTrabajador Trabajador){
        return new TrabajadorMetodos().InsertarTrabajadores(Trabajador);
    }
    public static boolean ActualizarTrabajadores(PersonaTrabajador Trabajador){
        return new TrabajadorMetodos().ActualizarTrabajadores(Trabajador);
    }
    public static boolean EliminarTrabajadores(String idTrabajador){
        return new TrabajadorMetodos().EliminarTrabajadores(idTrabajador);
    }
    public static boolean VerificarCodigoRepetido(String idTrabajador){
        return new TrabajadorMetodos().VerificarCodigoRepetido(idTrabajador);
    } 
}
