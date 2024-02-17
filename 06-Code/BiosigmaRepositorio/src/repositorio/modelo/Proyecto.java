package repositorio.modelo;

import java.util.Date;

public class Proyecto {
    private String idProyecto, nombreProyecto, descripcionProyecto, recordatorioProyecto;
    private Date fechaInicio, fechaFinal;
    private byte[] permisoAmbiental, permisoAgua, auditoria, monitoreo  ;

    public Proyecto() {
    }

    public Proyecto(String idProyecto, String nombreProyecto, String descripcionProyecto, String recordatorioProyecto, Date fechaInicio, Date fechaFinal, byte[] permisoAmbiental, byte[] permisoAgua, byte[] auditoria, byte[] monitoreo) {
        this.idProyecto = idProyecto;
        this.nombreProyecto = nombreProyecto;
        this.descripcionProyecto = descripcionProyecto;
        this.recordatorioProyecto = recordatorioProyecto;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.permisoAmbiental = permisoAmbiental;
        this.permisoAgua = permisoAgua;
        this.auditoria = auditoria;
        this.monitoreo = monitoreo;
    }

    public String getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(String idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public String getDescripcionProyecto() {
        return descripcionProyecto;
    }

    public void setDescripcionProyecto(String descripcionProyecto) {
        this.descripcionProyecto = descripcionProyecto;
    }

    public String getRecordatorioProyecto() {
        return recordatorioProyecto;
    }

    public void setRecordatorioProyecto(String recordatorioProyecto) {
        this.recordatorioProyecto = recordatorioProyecto;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public byte[] getPermisoAmbiental() {
        return permisoAmbiental;
    }

    public void setPermisoAmbiental(byte[] permisoAmbiental) {
        this.permisoAmbiental = permisoAmbiental;
    }

    public byte[] getPermisoAgua() {
        return permisoAgua;
    }

    public void setPermisoAgua(byte[] permisoAgua) {
        this.permisoAgua = permisoAgua;
    }

    public byte[] getAuditoria() {
        return auditoria;
    }

    public void setAuditoria(byte[] auditoria) {
        this.auditoria = auditoria;
    }

    public byte[] getMonitoreo() {
        return monitoreo;
    }

    public void setMonitoreo(byte[] monitoreo) {
        this.monitoreo = monitoreo;
    }

    @Override
    public String toString() {
        return "Proyecto{" + "idProyecto=" + idProyecto + ", nombreProyecto=" + nombreProyecto + ", descripcionProyecto=" + descripcionProyecto + ", recordatorioProyecto=" + recordatorioProyecto + ", fechaInicio=" + fechaInicio + ", fechaFinal=" + fechaFinal + ", permisoAmbiental=" + permisoAmbiental + ", permisoAgua=" + permisoAgua + ", auditoria=" + auditoria + ", monitoreo=" + monitoreo + '}';
    }  
    
}
