package repositorio.ejecutable;

import java.util.*;

/**
 * @author Alejandro Obando
 * @author Mateo Medranda
 * @author Gabriel Lopez
 * @author Joselyn Morocho
 */
public class Ejecucion {
    
    static int mostrarMenu(){
        int opcion;
        Scanner sc = new Scanner (System.in);
        
        System.out.println("==== BIENVENIDO ====");
        
        opcion = sc.nextInt();
                
        return opcion;
    }
    
    public static void main(String[] args) {
        
    }
}
