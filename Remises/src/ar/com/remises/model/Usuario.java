/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.remises.model;

/**
 *
 * @author matias
 */
public class Usuario {
    
    private Integer nroUsuario;
    private String nombre;
    private String apellido;
    private String nombreUsuario;
    private String claveUsuario;

    public Usuario(){
        
    }
    
    public Usuario(Integer nroUsuario, String nombre, String apellido, String nombreUsuario, String claveUsuario) {
        this.nroUsuario = nroUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nombreUsuario = nombreUsuario;
        this.claveUsuario = claveUsuario;
    }

    public Integer getNroUsuario() {
        return nroUsuario;
    }

    public void setNroUsuario(Integer nroUsuario) {
        this.nroUsuario = nroUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getClaveUsuario() {
        return claveUsuario;
    }

    public void setClaveUsuario(String claveUsuario) {
        this.claveUsuario = claveUsuario;
    }
    
    
    
}
