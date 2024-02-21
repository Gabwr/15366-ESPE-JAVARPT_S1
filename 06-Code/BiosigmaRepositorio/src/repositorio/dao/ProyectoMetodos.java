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
import repositorio.modelo.Proyecto;

public class ProyectoMetodos implements IProyecto {

    Conexion conn = new Conexion();
    MongoDatabase database;
    private MongoCollection<Document> coleccion;

    public ProyectoMetodos() {
        if (conn != null) {
            this.conn = conn.crearConexion();
            this.database = conn.getDataB();
            this.coleccion = database.getCollection("proyecto");
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
    public List<Proyecto> ListarProyectos() {
        FindIterable<Document> documentos = coleccion.find();
        List<Proyecto> listaProyectos = new ArrayList<>();
        for (Document documento : documentos) {

            byte[] pdfPermisoAmbiental = null;
            if (documento.get("permisoAmbiental") != null) {
                Object objetoPermisoAmbiental = documento.get("permisoAmbiental");
                org.bson.types.Binary binarioPermisoAmbiental = (org.bson.types.Binary) objetoPermisoAmbiental;
                pdfPermisoAmbiental = binarioPermisoAmbiental.getData();
            }

            byte[] pdfPermisoAgua = null;
            if (documento.get("permisoAgua") != null) {
                Object objetoPermisoAgua = documento.get("permisoAgua");
                org.bson.types.Binary binarioPermisoAgua = (org.bson.types.Binary) objetoPermisoAgua;
                pdfPermisoAgua = binarioPermisoAgua.getData();
            }

            byte[] pdfAuditoria = null;
            if (documento.get("auditoria") != null) {
                Object objetoAuditoria = documento.get("auditoria");
                org.bson.types.Binary binarioAuditoria = (org.bson.types.Binary) objetoAuditoria;
                pdfAuditoria = binarioAuditoria.getData();
            }

            byte[] pdfMonitoreo = null;
            if (documento.get("monitoreo") != null) {
                Object objetoMonitoreo = documento.get("monitoreo");
                org.bson.types.Binary binarioMonitoreo = (org.bson.types.Binary) objetoMonitoreo;
                pdfMonitoreo = binarioMonitoreo.getData();
            }
            
            Proyecto proyecto = new Proyecto(documento.getString("id_Proyecto"), documento.getString("nombre"), documento.getString("descripcion"), documento.getString("recordatorio"), documento.getDate("fechaInicio"), documento.getDate("fechaFinal"), pdfPermisoAmbiental, pdfPermisoAgua, pdfAuditoria, pdfMonitoreo);
            listaProyectos.add(proyecto);
        }
        return listaProyectos;
    }

    @Override
    public boolean InsertarProyecto(Proyecto proyecto) {
        Document documento;
        try {
            documento = new Document("id_Proyecto", proyecto.getIdProyecto())
                    .append("nombre", proyecto.getNombreProyecto())
                    .append("descripcion", proyecto.getDescripcionProyecto())
                    .append("recordatorio", proyecto.getRecordatorioProyecto())
                    .append("fechaInicio", proyecto.getFechaInicio())
                    .append("fechaFinal", proyecto.getFechaFinal())
                    .append("permisoAmbiental", proyecto.getPermisoAmbiental())
                    .append("permisoAgua", proyecto.getPermisoAgua())
                    .append("auditoria", proyecto.getAuditoria())
                    .append("monitoreo", proyecto.getMonitoreo());
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
    public boolean ActualizarProyecto(Proyecto proyecto) {
        Document filtro = new Document("id_Proyecto", proyecto.getIdProyecto());
        Document documento = new Document("$set", new Document()
                .append("nombre", proyecto.getNombreProyecto())
                .append("descripcion", proyecto.getDescripcionProyecto())
                .append("recordatorio", proyecto.getRecordatorioProyecto())
                .append("fechaInicio", proyecto.getFechaInicio())
                .append("fechaFinal", proyecto.getFechaFinal())
                .append("permisoAmbiental", proyecto.getPermisoAmbiental())
                .append("permisoAgua", proyecto.getPermisoAgua())
                .append("auditoria", proyecto.getAuditoria())
                .append("monitoreo", proyecto.getMonitoreo()));

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
    public boolean EliminarProyecto(String idProyecto) {

        Document filtro = new Document("id_Proyecto", idProyecto);
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
    public boolean VerificarCodigoRepetido(String codigo) {
        Document filtro = new Document("id_Proyecto", codigo);
        Document resultado = coleccion.find(filtro).first();

        if (resultado != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Proyecto BuscarProyecto(String codigo) {
        Document filtro = new Document("id_Proyecto", codigo);
        Document documento = coleccion.find(filtro).first();
           
            byte[] pdfPermisoAmbiental = null;
            if (documento.get("permisoAmbiental") != null) {
                Object objetoPermisoAmbiental = documento.get("permisoAmbiental");
                org.bson.types.Binary binarioPermisoAmbiental = (org.bson.types.Binary) objetoPermisoAmbiental;
                pdfPermisoAmbiental = binarioPermisoAmbiental.getData();
            }

            byte[] pdfPermisoAgua = null;
            if (documento.get("permisoAgua") != null) {
                Object objetoPermisoAgua = documento.get("permisoAgua");
                org.bson.types.Binary binarioPermisoAgua = (org.bson.types.Binary) objetoPermisoAgua;
                pdfPermisoAgua = binarioPermisoAgua.getData();
            }

            byte[] pdfAuditoria = null;
            if (documento.get("auditoria") != null) {
                Object objetoAuditoria = documento.get("auditoria");
                org.bson.types.Binary binarioAuditoria = (org.bson.types.Binary) objetoAuditoria;
                pdfAuditoria = binarioAuditoria.getData();
            }

            byte[] pdfMonitoreo = null;
            if (documento.get("monitoreo") != null) {
                Object objetoMonitoreo = documento.get("monitoreo");
                org.bson.types.Binary binarioMonitoreo = (org.bson.types.Binary) objetoMonitoreo;
                pdfMonitoreo = binarioMonitoreo.getData();
            }
            
            Proyecto proyecto = new Proyecto(documento.getString("id_Proyecto"), documento.getString("nombre"), documento.getString("descripcion"), documento.getString("recordatorio"), documento.getDate("fechaInicio"), documento.getDate("fechaFinal"), pdfPermisoAmbiental, pdfPermisoAgua, pdfAuditoria, pdfMonitoreo);
            
            return proyecto;
    }

}
