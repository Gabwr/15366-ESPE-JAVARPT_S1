package repositorio.modelo;

import java.util.Date;

public class PlanAmbiental {
    private String actividad, id;
    private int indicador;
     private byte[] evidencias;
     private boolean completado;
     

    public PlanAmbiental() {
    }

    public PlanAmbiental(String actividad, String id, int indicador, byte[] evidencias, boolean completado, Date fechaRealizada) {
        this.actividad = actividad;
        this.id = id;
        this.indicador = indicador;
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
    public void setIndicador(int indicador) {
        this.indicador = indicador;
    }

    public int getIndicador() {
        return indicador;
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
