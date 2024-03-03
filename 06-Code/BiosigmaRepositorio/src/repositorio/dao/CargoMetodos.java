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
import repositorio.modelo.Cargo;

public class CargoMetodos implements ICargo {

    Conexion conn = new Conexion();
    MongoDatabase database;
    private MongoCollection<Document> coleccion;

    public CargoMetodos() {
        if (conn != null) {
            this.conn = conn.crearConexion();
            this.database = conn.getDataB();
            this.coleccion = database.getCollection("cargo");
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
    public List<Cargo> ListarCargos() {
        FindIterable<Document> documentos = coleccion.find();
        List<Cargo> listaCargos = new ArrayList<>();

        try {
            for (Document documento : documentos) {
                Cargo cargo = new Cargo(documento.getString("nombreCargo"), documento.getString("descripcionCargo"),documento.getInteger("id_Cargo"));
                listaCargos.add(cargo);
            }
        } catch (MongoException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo cargar los registros, error: " + ex.toString());
        }

        return listaCargos;
    }

    @Override
    public boolean InsertarCargo(Cargo cargo) {
        Document documento;
        try {
            documento = new Document("id_Cargo", cargo.getIdCargo())
                    .append("nombreCargo", cargo.getCargo())
                    .append("descripcionCargo", cargo.getDescripcion());
            coleccion.insertOne(documento);
            return true;
        } catch (MongoException ex) {
            JOptionPane.showMessageDialog(null, "Error al insertar los datos " + ex.toString());
            return false;
        } finally {
            cierreConexion();
        }    }

    @Override
    public boolean ActualizrCargo(Cargo cargo) {
        Document filtro = new Document("id_Cargo", cargo.getIdCargo());
        Document documento = new Document("$set", new Document()
                .append("nombreCargo", cargo.getCargo())
                .append("descripcionCargo", cargo.getDescripcion()));
        UpdateResult result = coleccion.updateOne(filtro, documento);
        if (result.getModifiedCount() > 0) {
            JOptionPane.showMessageDialog(null, "Se ha actualizado correctamente");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "No se ha podido actualizar el registro");
            return false;
        }    }

    @Override
    public boolean EliminarCargo(int idCargo) {
        Document filtro = new Document("id_Cargo", idCargo);
        DeleteResult result = coleccion.deleteOne(filtro);

        if (result.getDeletedCount() > 0) {
            JOptionPane.showMessageDialog(null, "Registro eliminado correctamente");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "No se encontro un registro para eliminar");
            return false;
        }    }

    @Override
    public Cargo BuscarCargo(int idCargo) {
        Document filtro = new Document("id_Cargo", idCargo);
        Cargo cargo = new Cargo();
        Document documento = coleccion.find(filtro).first();
        cargo.setIdCargo(idCargo);
        cargo.setCargo(documento.getString("nombreCargo"));
        cargo.setDescripcion(documento.getString("descripcionCargo"));
        return cargo;    
    }

    @Override
    public boolean validarCodigo(int idCargo) {
        Document filtro = new Document("id_Cargo", idCargo);
        Document documento = coleccion.find(filtro).first();
        
        if(documento == null){
            System.out.println("No existen coincidencias");
            return true;
        }
        else{
            System.out.println("Hay coincidencia");
            return false;
        }    
    }

}
