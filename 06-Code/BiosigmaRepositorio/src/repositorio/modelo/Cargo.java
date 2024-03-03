package repositorio.modelo;

public class Cargo {
    private String cargo, descripcion;
    private int idCargo;

    public Cargo() {
    }

    public Cargo(String cargo, String descripcion, int idCargo) {
        this.cargo = cargo;
        this.descripcion = descripcion;
        this.idCargo = idCargo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(int idCargo) {
        this.idCargo = idCargo;
    }
    
    
}
