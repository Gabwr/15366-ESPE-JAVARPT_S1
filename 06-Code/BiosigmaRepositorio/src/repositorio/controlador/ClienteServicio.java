
package repositorio.controlador;

import java.util.List;
import repositorio.dao.ClienteMetodos;
import repositorio.modelo.PersonaCliente;


public class ClienteServicio {
     public static List<PersonaCliente> ListarCliente(){
         return new ClienteMetodos().ListarCliente();
     }
    public static boolean InsertarClientes(PersonaCliente Cliente){
         return new ClienteMetodos().InsertarClientes(Cliente);
     }
    public static boolean ActualizarClientes(PersonaCliente Cliente){
         return new ClienteMetodos().ActualizarClientes(Cliente);
     }
    public static boolean EliminarClientes(String idCliente){
         return new ClienteMetodos().EliminarClientes(idCliente);
     }
    public static boolean VerificarCodigoRepetido(String idCliente){
         return new ClienteMetodos().VerificarCodigoRepetido(idCliente);
     } 
}
