package com.ps.comunio;

/**
 * Created by Jorge on 24/11/2015.
 */
public class Usuario {

    private String user;
    private String pass;
    private String correo;
    private String fechaNacimiento;

    public Usuario(String user, String pass, String correo, String fechaNacimiento){
        this.user = user;
        this.pass = pass;
        this.correo = correo;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}
