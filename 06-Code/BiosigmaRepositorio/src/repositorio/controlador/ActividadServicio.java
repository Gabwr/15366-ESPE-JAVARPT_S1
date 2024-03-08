/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositorio.controlador;

import java.util.List;
import repositorio.dao.ActividadMetodos;
import repositorio.modelo.PlanAmbiental;

/**
 *
 * @author hp
 */
public class ActividadServicio {
    
    

    public static List<PlanAmbiental> ListaActividades(String idProyecto) {
        return new ActividadMetodos().ListarActividades(idProyecto);
        
    }
        public static boolean InsertarActividades(PlanAmbiental proyecto){
        return new ActividadMetodos().InsertarActividad(proyecto);
    }
     public static boolean VerificarCodigoRepetido(int codigo){
         return new ActividadMetodos().VerificarCodigoRepetido(codigo);
     }
      public static boolean ActualizarActividad(PlanAmbiental actividad) {
          return new ActividadMetodos().ActualizarActividad(actividad);
          
      }
    
}
