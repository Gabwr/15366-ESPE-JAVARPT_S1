
package repositorio.dao;

import java.util.List;
import repositorio.modelo.PersonaCliente;


public interface ICliente {
    public List<PersonaCliente> ListarCliente();
    public boolean InsertarClientes(PersonaCliente Cliente);
    public boolean ActualizarClientes(PersonaCliente Cliente);
    public boolean EliminarClientes(String idCliente);
    public boolean VerificarCodigoRepetido(String idCliente);  
}
