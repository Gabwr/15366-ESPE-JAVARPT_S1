package repositorio.proyecto.complementos;

import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.client.MongoDatabase;
import javax.swing.JOptionPane;

public class Conexion {
    private MongoClient mongo;
    private MongoDatabase dataB;

    Conexion() {
       
    }

    public MongoClient getMONGO() {
        return mongo;
    }

    public MongoDatabase getDataB() {
        return dataB;
    }

    public Conexion(MongoClient mongoClient, MongoDatabase database) {
        this.mongo = mongoClient;
        this.dataB = database;
    }
    public Conexion crearConexion(){
    String servidor = "localhost";
    int puerto = 27017;
    try{
        mongo = new MongoClient(servidor,puerto);
        dataB = mongo.getDatabase("db_Biosigma");
        
    }catch(MongoException ex){
        JOptionPane.showMessageDialog(null, "Error en la conexión a Mongodb"+ex.toString());
    }
        return new Conexion(mongo,dataB);
    }
}
