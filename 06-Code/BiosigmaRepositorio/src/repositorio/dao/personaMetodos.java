package repositorio.dao;

import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JOptionPane;
import org.apache.commons.codec.binary.Base64;
import org.bson.Document;
import repositorio.modelo.Personas;

public class personaMetodos implements IPersonas {

    Conexion conn = new Conexion();
    MongoDatabase database;
    private MongoCollection<Document> coleccionPersonas;
    private MongoCollection<Document> coleccionPerfiles;
    private MongoCollection<Document> coleccionCargos;

    public personaMetodos() {
        if (conn != null) {
            this.conn = conn.crearConexion();
            this.database = conn.getDataB();
            this.coleccionPersonas = database.getCollection("personas");
            this.coleccionPerfiles = database.getCollection("perfiles");
            this.coleccionCargos = database.getCollection("cargos");

        }
    }

    private void cerrarConexion() {
        try {
            conn.getMONGO().close();
        } catch (MongoException ex) {
            JOptionPane.showMessageDialog(null, "No se ha podido cerrar la conexión, error: " + ex.toString());
        }
    }

    @Override
    public List<Personas> ListarPersonas() {
        FindIterable<Document> documentos = coleccionPersonas.find();
        List<Personas> listapersonas = new ArrayList<>();
        for (Document documento : documentos) {
            int IDPerfil = documento.getInteger("id_Perfil");
            String usuario = documento.getString("usuario");
            String cedula = documento.getString("cedula");
            String correo = documento.getString("correo");
            String nombre = documento.getString("nombre");
            int cargo = 0;
            cargo = documento.getInteger("cargo");
            Date fechanac = documento.getDate("fechaNacimiento");
            if(cargo!=0){
            Personas persona = new Personas(IDPerfil, usuario, cedula, correo, nombre, fechanac,cargo);
            listapersonas.add(persona);
            }else{
            Personas persona = new Personas(IDPerfil, usuario, cedula, correo, nombre, fechanac);
            listapersonas.add(persona);
            }
            
            }
        
        return listapersonas;
    }

    @Override
    public boolean InsertarPersonasTrabajadores(Personas persona) {
        Document documento;
        try {
            documento = new Document("usuario", persona.getUsuario())
                    .append("id_Perfil", persona.getIdPerfil())
                    .append("cedula", persona.getCedula())
                    .append("nombre", persona.getNombre())
                    .append("contrasenia", persona.getContrasenia())
                    .append("cargo", persona.getCargo())
                    .append("fechaNacimiento", persona.getFechaNacimiento())
                    .append("correo", persona.getCorreo());
            coleccionPersonas.insertOne(documento);
            return true;
        } catch (MongoException ex) {
            JOptionPane.showMessageDialog(null, "No se ha podido agregar un proyecto, error: " + ex.toString());
            return false;
        } finally {
            cerrarConexion();
        }
    }

    @Override
    public boolean InsertarPersonasClienteyAdmin(Personas persona) {
        Document documento;
        try {
            documento = new Document("usuario", persona.getUsuario())
                    .append("id_Perfil", persona.getIdPerfil())
                    .append("cedula", persona.getCedula())
                    .append("nombre", persona.getNombre())
                    .append("contrasenia", persona.getContrasenia())
                    .append("fechaNacimiento", persona.getFechaNacimiento())
                    .append("correo", persona.getCorreo());
            coleccionPersonas.insertOne(documento);
            return true;
        } catch (MongoException ex) {
            JOptionPane.showMessageDialog(null, "No se ha podido agregar un proyecto, error: " + ex.toString());
            return false;
        } finally {
            cerrarConexion();
        }
    }

    @Override
    public boolean ActualizarPersonasClientesAdmin(Personas persona) {
        Document filtro = new Document("cedula", persona.getUsuario());
        Document documento = new Document("$set", new Document()
                .append("id_Perfil", persona.getIdPerfil())
                .append("nombre", persona.getNombre())
                .append("usuario", persona.getUsuario())
                .append("fechaNacimiento", persona.getFechaNacimiento())
                .append("correo", persona.getCorreo()));

        UpdateResult resultado = coleccionPersonas.updateOne(filtro, documento);
        if (resultado.getModifiedCount() > 0) {
            JOptionPane.showMessageDialog(null, "Se ha actualizado correctamente el registro");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "No se ha podido actualizar el registro");
            return false;

        }
    }
    @Override
    public boolean ActualizarPersonasTrabajador(Personas persona){
        Document filtro = new Document("cedula", persona.getUsuario());
        Document documento = new Document("$set", new Document()
                .append("id_Perfil", persona.getIdPerfil())
                .append("nombre", persona.getNombre())
                .append("usuario", persona.getUsuario())
                .append("cargo", persona.getCargo())
                .append("fechaNacimiento", persona.getFechaNacimiento())
                .append("correo", persona.getCorreo()));

        UpdateResult resultado = coleccionPersonas.updateOne(filtro, documento);
        if (resultado.getModifiedCount() > 0) {
            JOptionPane.showMessageDialog(null, "Se ha actualizado correctamente el registro");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "No se ha podido actualizar el registro");
            return false;

        }
    }
    @Override
    public boolean EliminarPersonas(String idpersona) {
        Document filtro = new Document("cedula", idpersona);
        DeleteResult resultado = coleccionPersonas.deleteOne(filtro);
        if (resultado.getDeletedCount() > 0) {
            JOptionPane.showMessageDialog(null, "El registro se ha eliminado correctamente");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo eliminar el registro");
            return false;
        }
    }

    @Override
    public boolean VerificarCodigoRepetido(String idpersona) {
        Document filtro = new Document("cedula", idpersona);
        Document resultado = coleccionPersonas.find(filtro).first();
        if (resultado != null) {
            return true;
        } else {
            return false;
        }

    }

    @Override
    public Personas BuscarPorCodigoTrabajadores(String idpersona) {

        Document filtro = null, resultado = null, cargo = null, perfil = null;
        try {
            filtro = new Document("cedula", idpersona);
            resultado = coleccionPersonas.find(filtro).first();
            cargo = coleccionCargos.find(filtro).first();
            if (resultado != null) {
                perfil = (Document) coleccionPerfiles.find(eq("id_perfil",
                        resultado.getString("id_Perfil")));
                return new Personas(perfil.getInteger("id_Perfil"),
                        resultado.getString("usuario"),
                        idpersona,
                        resultado.getString("correo"),
                        resultado.getString("nombre"),
                        resultado.getDate("fechaNacimiento"),
                        cargo.getInteger("cargo"));
            }
        } catch (MongoException ex) {
            JOptionPane.showMessageDialog(null, "No se ha podido agregar un proyecto, error: " + ex.toString());
        }
        return null;
    }

    @Override
    public Personas BuscarPorCodigoClienteyAdmin(String idpersona) {

        Document filtro = null, resultado = null, perfil = null;
        try {
            filtro = new Document("cedula", idpersona);
            resultado = coleccionPersonas.find(filtro).first();
            if (resultado != null) {
                perfil = (Document) coleccionPerfiles.find(eq("id_perfil",
                        resultado.getString("id_Perfil")));
                return new Personas(perfil.getInteger("id_Perfil"),
                        resultado.getString("usuario"),
                        idpersona,
                        resultado.getString("correo"),
                        resultado.getString("nombre"),
                        resultado.getDate("fechaNacimiento"));
            }
        } catch (MongoException ex) {
            JOptionPane.showMessageDialog(null, "No se ha podido agregar un proyecto, error: " + ex.toString());
        }
        return null;
    }

    @Override
      public String encriptar(String contrasenia){
        String Encriptado = "";
        String Cadena = "Encriptados";
        try {
            MessageDigest gestor = MessageDigest.getInstance("MD5");
            byte[] llaveClave = gestor.digest(contrasenia.getBytes("utf-8"));
            byte[] clavebyte = Arrays.copyOf(llaveClave, 24);
            SecretKey llave = new SecretKeySpec(clavebyte,"DESede");
            Cipher cifrado  = Cipher.getInstance("DESede");
            cifrado.init(Cipher.ENCRYPT_MODE, llave);
            
            byte[] textoPlano = Cadena.getBytes("utf-8");
            byte[] buffer = cifrado.doFinal(textoPlano);
            byte[] base64 = Base64.encodeBase64(buffer);
            Encriptado = new String(base64);
        } catch (Exception e) {
        }
        return Encriptado;
    }

    @Override
    public String desencriptar(String contrasenia) {
            String desEncriptado = "";
        String Cadena = "Encriptados";
        try {
            byte[] mensaje = Base64.decodeBase64(contrasenia.getBytes());
            MessageDigest digestor = MessageDigest.getInstance("MD5");
            byte[] gestionado = digestor.digest(Cadena.getBytes());
            byte[] llaveenBytes = Arrays.copyOf(gestionado, 24);
            SecretKey llave = new SecretKeySpec(llaveenBytes, "DESede");
            Cipher descifrado  = Cipher.getInstance("DESede");
            descifrado.init(Cipher.DECRYPT_MODE, llave);
            byte[] textoPlano = descifrado.doFinal(mensaje);
            desEncriptado = new String(textoPlano,"UTF-8");
        } catch (Exception e) {
        }
        return desEncriptado;}

}
