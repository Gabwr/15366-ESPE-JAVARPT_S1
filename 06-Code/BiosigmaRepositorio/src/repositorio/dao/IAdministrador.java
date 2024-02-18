/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repositorio.dao;

import java.util.List;
import repositorio.modelo.PersonaAdmin;


public interface IAdministrador {
    public List<PersonaAdmin> ListarAdmins();
    public boolean InsertarAdmins(PersonaAdmin Admin);
    public boolean ActualizarAdmins(PersonaAdmin Admin);
    public boolean EliminarAdmins(String idAdmin);
    public boolean VerificarCodigoRepetido(String idAdmin);    
}
