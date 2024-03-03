package repositorio.modelo;

import java.util.Date;

public class Personas {

    private int idPerfil, iDcargo;
    private String usuario, contrasenia, cedula, correo, nombre;
    private Date fechaNacimiento;

    //constructor trabajador para inserción
    public Personas(int idPerfil, String usuario, String contrasenia, String cedula, String correo, String nombre, int cargo, Date fechaNacimiento) {
        this.idPerfil = idPerfil;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.cedula = cedula;
        this.correo = correo;
        this.nombre = nombre;
        this.iDcargo = cargo;
        this.fechaNacimiento = fechaNacimiento;
    }
    //constructor admin y cliente para inserción

    public Personas(int idPerfil, String usuario, String contrasenia, String cedula, String correo, String nombre, Date fechaNacimiento) {
        this.idPerfil = idPerfil;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.cedula = cedula;
        this.correo = correo;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
    }

    //constructor sin contrasenia admins/clientes
    public Personas(int idPerfil, String usuario, String cedula, String correo, String nombre, Date fechaNacimiento) {
        this.idPerfil = idPerfil;
        this.usuario = usuario;
        this.cedula = cedula;
        this.correo = correo;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
    }

    //constructor sin contrasenia trabajadores
    public Personas(int idPerfil, String usuario, String cedula, String correo, String nombre, Date fechaNacimiento,
            int cargo) {
        this.idPerfil = idPerfil;
        this.usuario = usuario;
        this.cedula = cedula;
        this.correo = correo;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.iDcargo = cargo;
    }

    //para actualizar contraseña
    public Personas(String contrasenia, String cedula) {
        this.contrasenia = contrasenia;
        this.cedula = cedula;
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

    public int getCargo() {
        return iDcargo;
    }

    public void setCargo(int cargo) {
        this.iDcargo = cargo;
    }

    public int getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(int idPerfil) {
        this.idPerfil = idPerfil;
    }

    public String toString() {
        return idPerfil + usuario + contrasenia + cedula + correo + nombre + iDcargo + fechaNacimiento;
    }

}
