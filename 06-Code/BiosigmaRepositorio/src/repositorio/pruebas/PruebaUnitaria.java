package repositorio.pruebas;

import repositorio.controlador.ProyectoServicio;
import static repositorio.controlador.ProyectoServicio.InsertarProyecto;
import repositorio.modelo.Proyecto;

public class PruebaUnitaria {
    public static void main(String[] args) {
        agregarProyectoTest();
        
    }
    
    public static void agregarProyectoTest(){
        Proyecto proyecto = new Proyecto();
        proyecto.setIdProyecto("Hola como estas");
        ProyectoServicio.InsertarProyecto(proyecto);
    }
}
