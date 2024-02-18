
package repositorio.controlador;

import java.util.List;
import repositorio.dao.TrabajadorMetodos;
import repositorio.modelo.PersonaTrabajador;


public class TrabajadorServicio {
    public List<PersonaTrabajador> ListarTrabajadores(){
        return new TrabajadorMetodos().ListarTrabajadores();
    }
    public boolean InsertarTrabajadores(PersonaTrabajador Trabajador){
        return new TrabajadorMetodos().InsertarTrabajadores(Trabajador);
    }
    public boolean ActualizarTrabajadores(PersonaTrabajador Trabajador){
        return new TrabajadorMetodos().ActualizarTrabajadores(Trabajador);
    }
    public boolean EliminarTrabajadores(String idTrabajador){
        return new TrabajadorMetodos().EliminarTrabajadores(idTrabajador);
    }
    public boolean VerificarCodigoRepetido(String idTrabajador){
        return new TrabajadorMetodos().VerificarCodigoRepetido(idTrabajador);
    } 
}
