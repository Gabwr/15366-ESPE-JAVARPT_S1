package repositorio.dao;

import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
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
            this.coleccionPerfiles = database.getCollection("perfil");
            this.coleccionCargos = database.getCollection("cargo");

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

            Date fechanac = documento.getDate("fechaNacimiento");
            if (documento.getInteger("cargo") != null) {
                int cargo = documento.getInteger("cargo");
                Personas persona = new Personas(IDPerfil, usuario, cedula, correo, nombre, fechanac, cargo);
                listapersonas.add(persona);
            } else {
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
            JOptionPane.showMessageDialog(null, "No se ha podido agregar la persona, error: " + ex.toString());
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
            JOptionPane.showMessageDialog(null, "No se ha podido agregar la persona, error: " + ex.toString());
            return false;
        } finally {
            cerrarConexion();
        }
    }

    @Override
    public boolean ActualizarPersonasClientesAdmin(Personas persona) {
        Document filtro = new Document("cedula", persona.getCedula());
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
    public boolean ActualizarPersonasTrabajador(Personas persona) {
        Document filtro = new Document("cedula", persona.getCedula());
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

        Document filtroPersona = null,filtrocargo = null, resultado = null, cargo = null, perfil = null;
        try {
            filtroPersona = new Document("cedula", idpersona);
            resultado = coleccionPersonas.find(filtroPersona).first();
            filtrocargo = new Document("id_Cargo",resultado.getInteger("cargo"));
            cargo = coleccionCargos.find(filtrocargo).first();
            if (resultado != null) {
                perfil = (Document) coleccionPerfiles.find(eq("id_Perfil", 
                            resultado.getInteger("id_Perfil"))).first();
                
                return new Personas(perfil.getInteger("id_Perfil"),
                        resultado.getString("usuario"),
                        resultado.getString("contrasenia"),
                        idpersona,
                        resultado.getString("correo"),
                        resultado.getString("nombre"),
                        cargo.getInteger("id_Cargo"),
                        resultado.getDate("fechaNacimiento"))
                        ;
            }
        } catch (MongoException ex) {
            JOptionPane.showMessageDialog(null, "No se ha podido encontrar la persona, error: " + ex.toString());
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
                perfil = (Document) coleccionPerfiles.find(eq("id_Perfil",
                        resultado.getInteger("id_Perfil"))).first();
                return new Personas(perfil.getInteger("id_Perfil"),
                        resultado.getString("usuario"),
                        resultado.getString("contrasenia"),
                        idpersona,
                        resultado.getString("correo"),
                        resultado.getString("nombre"),
                        resultado.getDate("fechaNacimiento"));
            }
        } catch (MongoException ex) {
            JOptionPane.showMessageDialog(null, "No se ha podido encontrar la persona, error: " + ex.toString());
        }
        return null;
    }

    @Override
    public String encriptar(String contrasenia) {
        String Encriptado = "";
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
        }
        return Encriptado;
    }

    @Override
    public String desencriptar(String contraseniaEncriptada, String contrasenia) {
        String desEncriptado = "";
        try {
            byte[] mensaje = Base64.decodeBase64(contraseniaEncriptada.getBytes("utf-8"));
            MessageDigest digestor = MessageDigest.getInstance("MD5");
            byte[] gestionado = digestor.digest(contrasenia.getBytes("utf-8"));
            byte[] llaveenBytes = Arrays.copyOf(gestionado, 24);
            SecretKey llave = new SecretKeySpec(llaveenBytes, "DESede");
            Cipher descifrado = Cipher.getInstance("DESede");
            descifrado.init(Cipher.DECRYPT_MODE, llave);
            byte[] textoPlano = descifrado.doFinal(mensaje);
            desEncriptado = new String(textoPlano, "UTF-8");
        }catch  (NoSuchAlgorithmException | UnsupportedEncodingException | InvalidKeyException |
        NoSuchPaddingException | BadPaddingException | IllegalBlockSizeException e) {
        e.printStackTrace(); 
        }catch (Exception e) {
        }
        return desEncriptado;
    }

    @Override
    public Personas desencriptaryAutentificar(String usuario, String Contrasenia) {
        Personas suPersona = new Personas();
        Document filtro = null, resultado = null,perfil = null;
        try {
            filtro = new Document("usuario", usuario);
            resultado = (Document) coleccionPersonas.find(filtro).first();
            if (resultado != null) {
                    perfil =  coleccionPerfiles.find(eq("id_Perfil", 
                            resultado.getInteger("id_Perfil"))).first();
                suPersona.setCedula(resultado.getString("cedula"));
                suPersona.setIdPerfil(perfil.getInteger("id_Perfil"));
                suPersona.setUsuario(usuario);
                suPersona.setContrasenia(Contrasenia);
            }else{
                return null;
            }
        } catch (MongoException ex) {
            JOptionPane.showMessageDialog(null, "No se ha podido encontrar el usuario, error: " + ex.toString());
            return null;
        }
        return suPersona;
    }

    @Override
    public boolean ActualizarContrasenia(String contrasenia, Personas perosonactualizar) {
         Document filtro, actualizar;
        UpdateResult resultado;
        boolean actualizo = false;
        try {
            filtro = new Document("cedula", perosonactualizar.getCedula());
            actualizar = new Document("$set", new Document("contrasenia", contrasenia));
            resultado = coleccionPersonas.updateOne(filtro, actualizar);
            if (resultado.getModifiedCount() > 0) {
                actualizo = true;
            }
        } catch (MongoException ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar la clave" + ex.toString());
        }
        return actualizo;}

}
