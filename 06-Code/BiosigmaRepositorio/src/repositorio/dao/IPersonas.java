
package repositorio.dao;

import java.util.List;
import repositorio.modelo.Personas;

public interface IPersonas {
    public List<Personas> ListarPersonas();
    public boolean InsertarPersonasTrabajadores(Personas persona);
    public boolean InsertarPersonasClienteyAdmin(Personas persona);
    public boolean ActualizarPersonasClientesAdmin(Personas persona);
    public boolean ActualizarPersonasTrabajador(Personas persona);
    public boolean EliminarPersonas(String idpersona);
    public boolean VerificarCodigoRepetido(String idpersona);
    public Personas BuscarPorCodigoTrabajadores(String idpersona);
    public Personas BuscarPorCodigoClienteyAdmin(String idpersona);
    public String encriptar(String contrasenia);
    public String desencriptar(String contrasenia);
}
