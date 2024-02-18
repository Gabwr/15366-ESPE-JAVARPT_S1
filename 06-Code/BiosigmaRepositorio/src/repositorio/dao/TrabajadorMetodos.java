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
import repositorio.modelo.PersonaTrabajador;

public class TrabajadorMetodos implements ITrabajador {

    Conexion conn = new Conexion();
    MongoDatabase database;
    private MongoCollection<Document> coleccion;

    public TrabajadorMetodos() {
        if (conn != null) {
            this.conn = conn.crearConexion();
            this.database = conn.getDataB();
            this.coleccion = database.getCollection("Trabajadores");
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
    public List<PersonaTrabajador> ListarTrabajadores() {
        FindIterable<Document> documentos = coleccion.find();
        List<PersonaTrabajador> listatrabajadores = new ArrayList<>();
        for (Document documento : documentos) {
            String usuario = documento.getString("id_Admin");
            String cedula = documento.getString("cedula");
            String correo = documento.getString("correo");
            String nombre = documento.getString("nombre");
            String contrasenia = documento.getString("contraseña");
            String cargo = documento.getString("cargo");
            Date fechanac = documento.getDate("fechaNacimiento");

            PersonaTrabajador trabajador = new PersonaTrabajador(usuario, contrasenia, cedula, correo, nombre, cargo, fechanac);
            listatrabajadores.add(trabajador);
        }
        return listatrabajadores;
    }

    @Override
    public boolean InsertarTrabajadores(PersonaTrabajador Trabajador) {
        Document documento;
        try {
            documento = new Document("id_Admin", Trabajador.getUsuario())
                    .append("cedula", Trabajador.getCedula())
                    .append("nombre", Trabajador.getNombre())
                    .append("contrasenia", Trabajador.getContrasenia())
                    .append("cargo", Trabajador.getCargo())
                    .append("fechaNacimiento", Trabajador.getFechaNacimiento())
                    .append("correo", Trabajador.getCorreo());
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
    public boolean ActualizarTrabajadores(PersonaTrabajador Trabajador) {
        Document filtro = new Document("id_Admin", Trabajador.getUsuario());
        Document documento = new Document("$set", new Document()
                .append("cedula", Trabajador.getCedula())
                .append("nombre", Trabajador.getNombre())
                .append("contrasenia", Trabajador.getContrasenia())
                .append("cargo", Trabajador.getCargo())
                .append("fechaNacimiento", Trabajador.getFechaNacimiento())
                .append("correo", Trabajador.getCorreo()));

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
    public boolean EliminarTrabajadores(String idTrabajador) {
        Document filtro = new Document("id_Admin", idTrabajador);
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
    public boolean VerificarCodigoRepetido(String idTrabajador) {
    Document filtro = new Document("id_Admin", idTrabajador);
        Document resultado = coleccion.find(filtro).first();
        if (resultado != null) {
            return true;
        } else {
            return false;
        }    
    
    }

}
