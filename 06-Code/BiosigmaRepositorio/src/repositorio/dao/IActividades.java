/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repositorio.dao;

import java.util.List;
import repositorio.modelo.PlanAmbiental;
import repositorio.modelo.Proyecto;

/**
 *
 * @author hp
 */
public interface IActividades {

    public List<PlanAmbiental> ListarActividades(String idProyecto);

    public boolean InsertarActividad(PlanAmbiental actividad);

    public boolean ActualizarActividad(PlanAmbiental actividad);
    
    public boolean VerificarCodigoRepetido(int codigo);

}
