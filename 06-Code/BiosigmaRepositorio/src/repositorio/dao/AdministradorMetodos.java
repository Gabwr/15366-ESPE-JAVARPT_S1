package repositorio.dao;

import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import org.bson.Document;
import repositorio.modelo.PersonaAdmin;

public class AdministradorMetodos implements IAdministrador {

    Conexion conn = new Conexion();
    MongoDatabase database;
    private MongoCollection<Document> coleccion;

    public AdministradorMetodos() {
        if (conn != null) {
            this.conn = conn.crearConexion();
            this.database = conn.getDataB();
            this.coleccion = database.getCollection("Administradores");
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
    public List<PersonaAdmin> ListarAdmins() {
        FindIterable<Document> documentos = coleccion.find();
        List<PersonaAdmin> listaadministradores = new ArrayList<>();
        for (Document documento : documentos) {
            String usuario = documento.getString("id_Admin");
            String cedula = documento.getString("cedula");
            String correo = documento.getString("correo");
            String nombre = documento.getString("nombre");
            String contrasenia = documento.getString("contrasenia");
            Date fechanac = documento.getDate("fechaNacimiento");

            PersonaAdmin admin = new PersonaAdmin(usuario, contrasenia, cedula, correo, nombre, fechanac);
            listaadministradores.add(admin);
        }
        return listaadministradores;
    }

    @Override
    public boolean InsertarAdmins(PersonaAdmin Admin) {
        Document documento;
        try {
            documento = new Document("id_Admin", Admin.getUsuario())
                    .append("cedula", Admin.getCedula())
                    .append("nombre", Admin.getNombre())
                    .append("contrasenia", Admin.getContrasenia())
                    .append("fechaNacimiento", Admin.getFechaNacimiento())
                    .append("correo", Admin.getCorreo());
            coleccion.insertOne(documento);
            return true;
        } catch (MongoException ex) {
            JOptionPane.showMessageDialog(null, "No se ha podido agregar un proyecto, error: " + ex.toString());
            return false;
        } finally {
            cerrarConexion();
        }
    }

    @Override
    public boolean ActualizarAdmins(PersonaAdmin Admin) {
        Document filtro = new Document("id_Admin", Admin.getUsuario());
        Document documento = new Document("$set", new Document()
                .append("cedula", Admin.getCedula())
                .append("nombre", Admin.getNombre())
                .append("contrasenia", Admin.getContrasenia())
                .append("fechaNacimiento", Admin.getFechaNacimiento())
                .append("correo", Admin.getCorreo()));

        UpdateResult resultado = coleccion.updateOne(filtro, documento);
        if (resultado.getModifiedCount() > 0) {
            JOptionPane.showMessageDialog(null, "Se ha actualizado correctamente el registro");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "No se ha podido actualizar el registro");
            return false;

        }
    }

    @Override
    public boolean EliminarAdmins(String idAdmin) {
        Document filtro = new Document("id_Admin", idAdmin);
        DeleteResult resultado = coleccion.deleteOne(filtro);
        if (resultado.getDeletedCount() > 0) {
            JOptionPane.showMessageDialog(null, "El registro se ha eliminado correctamente");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo eliminar el registro");
            return false;
        }
    }

    @Override
    public boolean VerificarCodigoRepetido(String idAdmin) {
        Document filtro = new Document("id_Admin", idAdmin);
        Document resultado = coleccion.find(filtro).first();
        if (resultado != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public PersonaAdmin BuscarPorCodigo(String idAdmin) {
        Document filtro = new Document("id_Admin", idAdmin);
        Document resultado = coleccion.find(filtro).first();
    return new PersonaAdmin(idAdmin, resultado.getString("contrasenia"),
            resultado.getString("cedula"),
            resultado.getString("correo"),
            resultado.getString("nombre"), 
            resultado.getDate("fechaNacimiento"));
    }
}
