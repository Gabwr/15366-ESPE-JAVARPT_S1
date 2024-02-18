
package repositorio.controlador;

import java.util.List;
import repositorio.dao.AdministradorMetodos;
import repositorio.modelo.PersonaAdmin;


public class AdminServicio {
    public List<PersonaAdmin> ListarAdmins(){
        return new AdministradorMetodos().ListarAdmins();
    }
    public boolean InsertarAdmins(PersonaAdmin Admin){
        return new AdministradorMetodos().InsertarAdmins(Admin);
    }
    public boolean ActualizarAdmins(PersonaAdmin Admin){
        return new AdministradorMetodos().ActualizarAdmins(Admin);
    }
    public boolean EliminarAdmins(String idAdmin){
        return new AdministradorMetodos().EliminarAdmins(idAdmin);
    }
    public boolean VerificarCodigoRepetido(String idAdmin){
        return new AdministradorMetodos().VerificarCodigoRepetido(idAdmin);
    }
}
