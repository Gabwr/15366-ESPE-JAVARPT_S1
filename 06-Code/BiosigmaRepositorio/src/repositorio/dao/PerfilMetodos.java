package repositorio.dao;

import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.bson.Document;
import repositorio.modelo.Perfil;

public class PerfilMetodos implements IPerfil {

    Conexion conn = new Conexion();
    MongoDatabase database;
    private MongoCollection<Document> coleccion;

    public PerfilMetodos() {
        if (conn != null) {
            this.conn = conn.crearConexion();
            this.database = conn.getDataB();
            this.coleccion = database.getCollection("perfil");
        }
    }

    private void cierreConexion() {
        try {
            conn.getMONGO().close();
        } catch (MongoException ex) {
            JOptionPane.showMessageDialog(null, "No se ha podido cerrar la conexión " + ex.toString());
        }

    }

    @Override
    public List<Perfil> ListarPerfiles() {
        FindIterable<Document> documentos = coleccion.find();
        List<Perfil> listaPerfil = new ArrayList<>();

        try {
            for (Document documento : documentos) {
                Perfil perfil = new Perfil(documento.getInteger("id_Perfil"), documento.getString("nombrePerfil"));
                listaPerfil.add(perfil);
            }
        } catch (MongoException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo cargar los registros, error: " + ex.toString());
        }

        return listaPerfil;
    }

    @Override
    public boolean InsertarPerfil(Perfil perfil) {
        Document documento;
        try {

            documento = new Document("id_Perfil", perfil.getId())
                    .append("nombrePerfil", perfil.getNombrePerfil());
            coleccion.insertOne(documento);
            return true;
        } catch (MongoException ex) {
            JOptionPane.showMessageDialog(null, "Error al insertar los datos " + ex.toString());
            return false;
        } finally {
            cierreConexion();
        }
    }

    @Override
    public boolean ActualizrPerfil(Perfil perfil) {
        Document filtro = new Document("id_Perfil", perfil.getId());
        Document documento = new Document("$set", new Document()
                .append("nombrePerfil", perfil.getNombrePerfil()));
        UpdateResult result = coleccion.updateOne(filtro, documento);
        if (result.getModifiedCount() > 0) {
            JOptionPane.showMessageDialog(null, "Se ha actualizado correctamente");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "No se ha podido actualizar el registro");
            return false;
        }
    }

    @Override
    public boolean EliminarPerfil(int idPerfil) {

        Document filtro = new Document("id_Perfil", idPerfil);
        DeleteResult result = coleccion.deleteOne(filtro);

        if (result.getDeletedCount() > 0) {
            JOptionPane.showMessageDialog(null, "Registro eliminado correctamente");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "No se encontro un registro para eliminar");
            return false;
        }
    }

    @Override
    public Perfil BuscarPerfil(int idPerfil) {
        Document filtro = new Document("id_Perfil",idPerfil);
        Perfil perfil = new Perfil();
        Document documento = coleccion.find(filtro).first();
        perfil.setId(documento.getInteger("id_Perfil"));
        perfil.setNombrePerfil(documento.getString("nombrePerfil"));
        return perfil;    
    }

}
