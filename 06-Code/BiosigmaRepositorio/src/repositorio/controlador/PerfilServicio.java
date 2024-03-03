
package repositorio.controlador;

import java.util.List;
import repositorio.dao.PerfilMetodos;
import repositorio.modelo.Perfil;


public class PerfilServicio {
     public static List<Perfil> ListarPerfiles(){
         return new PerfilMetodos().ListarPerfiles();
     }
    public static boolean InsertarPerfil(Perfil perfil){
        return new PerfilMetodos().InsertarPerfil(perfil);
    }
    public static boolean ActualizrPerfil(Perfil perfil){
        return new PerfilMetodos().ActualizrPerfil(perfil);
    }
    public static boolean EliminarPerfil(int idPerfil){
        return new PerfilMetodos().EliminarPerfil(idPerfil);
    }
    public static Perfil BuscarPerfil(int idPerfil){
        return new PerfilMetodos().BuscarPerfil(idPerfil);
    }
    public static boolean ValidarCodigo(int idPerfil){
        return new PerfilMetodos().validarCodigo(idPerfil);
    }
}
