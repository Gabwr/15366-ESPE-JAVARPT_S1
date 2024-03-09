package repositorio.modelo;

import java.util.Date;

public class PlanAmbiental {

    private String actividad, id;
    private Object idActividad;
    private byte[] evidencias;
    private boolean completado;

    public PlanAmbiental() {
    }

    public PlanAmbiental(String actividad, String id, Object idActividad, byte[] evidencias, boolean completado, Date fechaRealizada) {
        this.actividad = actividad;
        this.id = id;
        this.idActividad = idActividad;
        this.evidencias = evidencias;
        this.completado = completado;
        this.fechaRealizada = fechaRealizada;
    }

    public byte[] getEvidencias() {
        return evidencias;
    }

    public void setEvidencias(byte[] evidencias) {
        this.evidencias = evidencias;
    }

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

    public Object getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(Object idActividad) {
        this.idActividad = idActividad;
    }

    public boolean getCompletado() {
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
