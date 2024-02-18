
package repositorio.controlador;

import java.util.List;
import repositorio.dao.ClienteMetodos;
import repositorio.modelo.PersonaCliente;


public class ClienteServicio {
     public List<PersonaCliente> ListarCliente(){
         return new ClienteMetodos().ListarCliente();
     }
    public boolean InsertarClientes(PersonaCliente Cliente){
         return new ClienteMetodos().InsertarClientes(Cliente);
     }
    public boolean ActualizarClientes(PersonaCliente Cliente){
         return new ClienteMetodos().ActualizarClientes(Cliente);
     }
    public boolean EliminarClientes(String idCliente){
         return new ClienteMetodos().EliminarClientes(idCliente);
     }
    public boolean VerificarCodigoRepetido(String idCliente){
         return new ClienteMetodos().VerificarCodigoRepetido(idCliente);
     } 
}
