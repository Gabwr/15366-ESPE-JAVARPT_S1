package repositorio.dao;

import java.util.List;
import repositorio.modelo.Perfil;

public interface IPerfil {

    public List<Perfil> ListarPerfiles();

    public boolean InsertarPerfil(Perfil perfil);

    public boolean ActualizrPerfil(Perfil perfil);

    public boolean EliminarPerfil(int idPerfil);

    public Perfil BuscarPerfil(int idPerfil);
}
