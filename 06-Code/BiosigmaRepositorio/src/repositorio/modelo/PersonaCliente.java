package repositorio.modelo;

import java.util.Date;

public class PersonaCliente {
    private String usuario, contrasenia, cedula, correo, nombre;
    private Date fechaNacimiento;

    public PersonaCliente(String usuario, String contrasenia, String cedula, String correo, String nombre, Date fechaNacimiento) {
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.cedula = cedula;
        this.correo = correo;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
    }


    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    
    
}
