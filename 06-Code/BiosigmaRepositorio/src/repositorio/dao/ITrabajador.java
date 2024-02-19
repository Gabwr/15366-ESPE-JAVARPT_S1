
package repositorio.dao;

import java.util.List;
import repositorio.modelo.PersonaTrabajador;

public interface ITrabajador {
    public List<PersonaTrabajador> ListarTrabajadores();
    public boolean InsertarTrabajadores(PersonaTrabajador Trabajador);
    public boolean ActualizarTrabajadores(PersonaTrabajador Trabajador);
    public boolean EliminarTrabajadores(String idTrabajador);
    public boolean VerificarCodigoRepetido(String idTrabajador);
    public PersonaTrabajador BuscarPorCodigo(String idTrabajador);
}
