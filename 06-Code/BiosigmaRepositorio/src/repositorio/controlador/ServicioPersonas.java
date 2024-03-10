package repositorio.controlador;

import java.util.List;
import repositorio.dao.personaMetodos;
import repositorio.modelo.Personas;

public class ServicioPersonas {

    public static List<Personas> ListarPersonas() {
        return new personaMetodos().ListarPersonas();
    }

    public static boolean InsertarPersonasTrabajadores(Personas persona) {
        return new personaMetodos().InsertarPersonasTrabajadores(persona);
    }

    public static boolean InsertarPersonasClienteyAdmin(Personas persona) {
        return new personaMetodos().InsertarPersonasClienteyAdmin(persona);
    }

    public static boolean ActualizarPersonasClientesAdmin(Personas persona) {

        return new personaMetodos().ActualizarPersonasClientesAdmin(persona);
    }

    public static boolean ActualizarPersonasTrabajador(Personas persona) {
        return new personaMetodos().ActualizarPersonasTrabajador(persona);
    }

    public static boolean EliminarPersonas(String idpersona) {
        return new personaMetodos().EliminarPersonas(idpersona);
    }

    public static boolean VerificarCodigoRepetido(String idpersona) {
        return new personaMetodos().VerificarCodigoRepetido(idpersona);
    }

    public static Personas BuscarPorCodigoTrabajadores(String idpersona) {
        return new personaMetodos().BuscarPorCodigoTrabajadores(idpersona);
    }

    public static Personas BuscarPorCodigoClienteyAdmin(String idpersona) {
        return new personaMetodos().BuscarPorCodigoClienteyAdmin(idpersona);
    }

    public static String encriptar(String contrasenia) {
        return new personaMetodos().encriptar(contrasenia);
    }

    public static String desencriptar(String contrasenia,String contraseniallevada) {
        return new personaMetodos().desencriptar(contrasenia,contraseniallevada);
    }

    public static Personas desencrpitaryAutentificar(String usuario, String Contrasenia){
        return new personaMetodos().desencriptaryAutentificar(usuario, Contrasenia);
    }
}
