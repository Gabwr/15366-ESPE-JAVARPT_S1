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
import repositorio.modelo.PersonaCliente;
import repositorio.modelo.PersonaTrabajador;

public class ClienteMetodos implements ICliente {

    Conexion conn = new Conexion();
    MongoDatabase database;
    private MongoCollection<Document> coleccion;

    public ClienteMetodos() {
        if (conn != null) {
            this.conn = conn.crearConexion();
            this.database = conn.getDataB();
            this.coleccion = database.getCollection("Clientes");
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
    public List<PersonaCliente> ListarCliente() {
        FindIterable<Document> documentos = coleccion.find();
        List<PersonaCliente> listaClientes = new ArrayList<>();
        for (Document documento : documentos) {
            String usuario = documento.getString("id_Admin");
            String cedula = documento.getString("cedula");
            String correo = documento.getString("correo");
            String nombre = documento.getString("nombre");
            String contrasenia = documento.getString("contrasenia");
            Date fechanac = documento.getDate("fechaNacimiento");
            PersonaCliente cliente = new PersonaCliente(usuario, contrasenia, cedula, correo, nombre, fechanac);
            listaClientes.add(cliente);
        }
        return listaClientes;
    }

    @Override
    public boolean InsertarClientes(PersonaCliente Cliente) {
        Document documento;
        try {
            documento = new Document("id_Cliente", Cliente.getUsuario())
                    .append("cedula", Cliente.getCedula())
                    .append("nombre", Cliente.getNombre())
                    .append("contrasenia", Cliente.getContrasenia())
                    .append("fechaNacimiento", Cliente.getFechaNacimiento())
                    .append("correo", Cliente.getCorreo());
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
    public boolean ActualizarClientes(PersonaCliente Cliente) {
        Document filtro = new Document("id_Cliente", Cliente.getUsuario());
        Document documento = new Document("$set", new Document()
                .append("cedula", Cliente.getCedula())
                .append("nombre", Cliente.getNombre())
                .append("contrasenia", Cliente.getContrasenia())
                .append("fechaNacimiento", Cliente.getFechaNacimiento())
                .append("correo", Cliente.getCorreo()));

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
    public boolean EliminarClientes(String idCliente) {
        Document filtro = new Document("id_Cliente", idCliente);
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
    public boolean VerificarCodigoRepetido(String idCliente) {
        Document filtro = new Document("id_Cliente", idCliente);
        Document resultado = coleccion.find(filtro).first();
        if (resultado != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public PersonaCliente BuscarPorCodigo(String idCliente) {
        Document filtro = new Document("id_Admin", idCliente);
        Document resultado = coleccion.find(filtro).first();
        return new PersonaCliente(idCliente, resultado.getString("contrasenia"),
                resultado.getString("cedula"),
                resultado.getString("correo"),
                resultado.getString("nombre"),
                resultado.getDate("fechaNacimiento"));
    }

}
