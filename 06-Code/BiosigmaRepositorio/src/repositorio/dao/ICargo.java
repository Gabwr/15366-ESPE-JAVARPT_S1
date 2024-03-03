package repositorio.dao;

import java.util.List;
import repositorio.modelo.Cargo;

public interface ICargo {
    public List<Cargo> ListarCargos();
    public boolean InsertarCargo(Cargo cargo);
    public boolean ActualizrCargo(Cargo cargo);
    public boolean EliminarCargo(int idCargo);
    public Cargo BuscarCargo(int idCargo);
    public boolean validarCodigo(int idCargo);
}
