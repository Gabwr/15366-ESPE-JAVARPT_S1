package repositorio.modelo;

public class Perfil {
    private int id;
    private String nombrePerfil;

    public Perfil(int id, String nombrePerfil) {
        this.id = id;
        this.nombrePerfil = nombrePerfil;
    }

    public Perfil() {
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombrePerfil() {
        return nombrePerfil;
    }

    public void setNombrePerfil(String nombrePerfil) {
        this.nombrePerfil = nombrePerfil;
    }

    @Override
    public String toString() {
        return "Perfil{" + "id=" + id + ", nombrePerfil=" + nombrePerfil + '}';
    }
    
}
