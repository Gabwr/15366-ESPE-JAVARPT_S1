package repositorio.modelo;

import java.util.Date;

public class PlanAmbiental {
    private String actividad, id;
    private int indicador;
    boolean completado;
    Date fechaRealizada;

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getIndicador() {
        return indicador;
    }

    public void setIndicador(int indicador) {
        this.indicador = indicador;
    }

    public boolean isCompletado() {
        return completado;
    }

    public void setCompletado(boolean completado) {
        this.completado = completado;
    }

    public Date getFechaRealizada() {
        return fechaRealizada;
    }

    public void setFechaRealizada(Date fechaRealizada) {
        this.fechaRealizada = fechaRealizada;
    }
    
    
    
}
