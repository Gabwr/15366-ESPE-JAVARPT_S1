package repositorio.dao;

import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.UpdateResult;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.bson.Document;
import repositorio.modelo.PlanAmbiental;

/**
 *
 * @author hp
 */
public class ActividadMetodos implements IActividades {

    Conexion conn = new Conexion();
    MongoDatabase database;
    private MongoCollection<Document> coleccion;
    public static int encontrarid;

    public ActividadMetodos() {

        if (conn != null) {
            this.conn = conn.crearConexion();
            this.database = conn.getDataB();
            this.coleccion = database.getCollection("actividades");
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
    public List<PlanAmbiental> ListarActividades(String idProyecto) {

        Document filtro = null;
        Document resultado = null;

        filtro = new Document("id_Proyecto", idProyecto);

        FindIterable<Document> documentos = coleccion.find(filtro);

        List<PlanAmbiental> listaActividades = new ArrayList<>();

        for (Document documento : documentos) {
            PlanAmbiental proyecto = new PlanAmbiental();

            System.out.println(documento.getString("Error Actividad Metodos1"));

            byte[] pdfPermisoAmbiental = null;
            if (documento.get("evidencias") != null) {
                Object objetoPermisoAmbiental = documento.get("evidencias");
                org.bson.types.Binary binarioPermisoAmbiental = (org.bson.types.Binary) objetoPermisoAmbiental;
                pdfPermisoAmbiental = binarioPermisoAmbiental.getData();

            }

            proyecto = new PlanAmbiental(documento.getString("actividad"), documento.getString("id_Proyecto"), documento.get("_id"), pdfPermisoAmbiental, documento.getBoolean("completado"), documento.getDate("Fecha_Realizada"));
            listaActividades.add(proyecto);

        }

        return listaActividades;
    }

    @Override
    public boolean InsertarActividad(PlanAmbiental actividad) {
        Document documento;
        try {
            documento = new Document("id_Proyecto", actividad.getId())
                    .append("actividad", actividad.getActividad())
                    .append("Fecha_Realizada", actividad.getFechaRealizada())
                    .append("evidencias", actividad.getEvidencias())
                    .append("completado", actividad.getCompletado());
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
    public boolean ActualizarActividad(PlanAmbiental actividad) {

        Document filtro = new Document("_id", actividad.getIdActividad());
        Document documento = new Document("$set", new Document()
                .append("actividad", actividad.getActividad())
                .append("id_Proyecto", actividad.getId())
                .append("Fecha_Realizada", actividad.getFechaRealizada())
                .append("evidencias", actividad.getEvidencias())
                .append("completado", actividad.getCompletado()));

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
    public PlanAmbiental BuscarActividad(Object idActividad) {
        Document filtro = new Document("_id", idActividad);
        Document documento = coleccion.find(filtro).first();
        
        byte[] pdfPermisoAmbiental = null;
        
        if (documento.get("evidencias") != null) {
            Object objetoPermisoAmbiental = documento.get("evidencias");
            org.bson.types.Binary binarioPermisoAmbiental = (org.bson.types.Binary) objetoPermisoAmbiental;
            pdfPermisoAmbiental = binarioPermisoAmbiental.getData();

        }

        PlanAmbiental proyecto = new PlanAmbiental(documento.getString("actividad"), documento.getString("id_Proyecto"), documento.get("_id"), pdfPermisoAmbiental, documento.getBoolean("completado"), documento.getDate("Fecha_Realizada"));
        return proyecto;
    }
}
