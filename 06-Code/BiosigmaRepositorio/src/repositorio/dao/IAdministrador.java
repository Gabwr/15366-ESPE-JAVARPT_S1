
package repositorio.dao;

import java.util.List;
import repositorio.modelo.PersonaAdmin;
import repositorio.modelo.PersonaCliente;


public interface IAdministrador {
    public List<PersonaAdmin> ListarAdmins();
    public boolean InsertarAdmins(PersonaAdmin Admin);
    public boolean ActualizarAdmins(PersonaAdmin Admin);
    public boolean EliminarAdmins(String idAdmin);
    public boolean VerificarCodigoRepetido(String idAdmin); 
    public PersonaAdmin BuscarPorCodigo(String idCliente);
}
