package repositorio.controlador;

import java.util.List;
import repositorio.dao.CargoMetodos;
import repositorio.modelo.Cargo;

public class CargoServicio {

    public static List<Cargo> ListarCargos() {
        return new CargoMetodos().ListarCargos();
    }

    public static boolean InsertarCargo(Cargo cargo) {
        return new CargoMetodos().InsertarCargo(cargo);
    }

    public static boolean ActualizrCargo(Cargo cargo) {
        return new CargoMetodos().ActualizrCargo(cargo);
    }

    public static boolean EliminarCargo(int idCargo) {
        return new CargoMetodos().EliminarCargo(idCargo);
    }

    public static Cargo BuscarCargo(int idCargo) {
        return new CargoMetodos().BuscarCargo(idCargo);
    }

    public static boolean ValidarCodigo(int idCargo) {
        return new CargoMetodos().validarCodigo(idCargo);
    }
}
