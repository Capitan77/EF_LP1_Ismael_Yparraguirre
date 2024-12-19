package com.cibertec.models;

public class Usuario {

    private int id;
    private String nombre;
    private String apellido;
    private String correo;
    private String clave;
    private boolean activo;

    public Usuario() {
    }

    public Usuario(int id, String nombre, String apellido, String correo, String clave, boolean activo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.clave = clave;
        this.activo = activo;
    }

    public Usuario(String nombre, String apellido, String correo, String clave, boolean activo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.clave = clave;
        this.activo = activo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public String getClave() {
        return clave;
    }

    public boolean isActivo() {
        return activo;
    }
}
