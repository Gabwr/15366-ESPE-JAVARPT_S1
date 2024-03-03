
package repositorio.pruebas;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JOptionPane;
import org.apache.commons.codec.binary.Base64;

public class pruebaencriptar_desencriptar {
    public static void main(String[] args) {
        String Encriptado = "";
        String contrasenia = "1234";

        try {
            MessageDigest gestor = MessageDigest.getInstance("MD5");
            byte[] llaveClave = gestor.digest(contrasenia.getBytes("utf-8"));
            byte[] clavebyte = Arrays.copyOf(llaveClave, 24);
            SecretKey llave = new SecretKeySpec(clavebyte, "DESede");
            Cipher cifrado = Cipher.getInstance("DESede");
            cifrado.init(Cipher.ENCRYPT_MODE, llave);

            byte[] textoPlano = contrasenia.getBytes("utf-8");
            byte[] buffer = cifrado.doFinal(textoPlano);
            byte[] base64 = Base64.encodeBase64(buffer);
            Encriptado = new String(base64);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String desEncriptado = "";
        try {
            byte[] mensaje = Base64.decodeBase64(Encriptado.getBytes());
            MessageDigest digestor = MessageDigest.getInstance("MD5");
            byte[] gestionado = digestor.digest(contrasenia.getBytes("utf-8"));
            byte[] llaveenBytes = Arrays.copyOf(gestionado, 24);
            SecretKey llave = new SecretKeySpec(llaveenBytes, "DESede");
            Cipher descifrado = Cipher.getInstance("DESede");
            descifrado.init(Cipher.DECRYPT_MODE, llave);
            byte[] textoPlano = descifrado.doFinal(mensaje);
            desEncriptado = new String(textoPlano, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }

        JOptionPane.showMessageDialog(null, "Texto Encriptado:\n" + Encriptado + "\n\nTexto Desencriptado:\n" + desEncriptado);
    }
}
    

