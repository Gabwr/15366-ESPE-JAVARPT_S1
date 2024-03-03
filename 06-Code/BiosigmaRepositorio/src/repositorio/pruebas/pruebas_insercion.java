
package repositorio.pruebas;

import javax.swing.JOptionPane;
import repositorio.vista.admin.InterfazAdminInsertarUsuario;

public class pruebas_insercion {
    public static void main(String[] args) {
        String nombre = "Juanita";
        String Cedula = "0986641327";
                String usuario = "";
        char pasador;
       for (int inicio = 0; inicio <= 3; inicio++) {
            pasador = nombre.trim().charAt(inicio);
            usuario += pasador;
        }
        for (int inicio = 0; inicio <= 3; inicio++) {
            pasador = Cedula.trim().charAt(inicio);
            usuario += pasador;
        }
        JOptionPane.showMessageDialog(null, usuario);
    }
}
