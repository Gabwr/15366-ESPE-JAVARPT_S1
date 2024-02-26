
package repositorio.controlador;

import java.util.List;
import repositorio.dao.AdministradorMetodos;
import repositorio.modelo.PersonaAdmin;


public class AdminServicio {
    public static List<PersonaAdmin> ListarAdmins(){
        return new AdministradorMetodos().ListarAdmins();
    }
    public static boolean InsertarAdmins(PersonaAdmin Admin){
        return new AdministradorMetodos().InsertarAdmins(Admin);
    }
    public static boolean ActualizarAdmins(PersonaAdmin Admin){
        return new AdministradorMetodos().ActualizarAdmins(Admin);
    }
    public static boolean EliminarAdmins(String idAdmin){
        return new AdministradorMetodos().EliminarAdmins(idAdmin);
    }
    public static boolean VerificarCodigoRepetido(String idAdmin){
        return new AdministradorMetodos().VerificarCodigoRepetido(idAdmin);
    }
}
