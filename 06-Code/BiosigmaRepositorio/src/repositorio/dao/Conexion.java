package repositorio.dao;

import com.mongodb.client.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.client.MongoClients;
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
    String servidor = "mongodb+srv://mdmedranda1:Mateo2004md@biosigma.gqpxdcz.mongodb.net/?retryWrites=true&w=majority&appName=BIOSIGMA";

    try{
        mongo = MongoClients.create(servidor);
        dataB = mongo.getDatabase("db_Biosigma");
        
    }catch(MongoException ex){
        JOptionPane.showMessageDialog(null, "Error en la conexión a Mongodb"+ex.toString());
    }
        return new Conexion(mongo,dataB);
    }

}
