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
public class Chofer {
    
    private Integer nroChofer;
    private String nombre;
    private String apellido;
    private Integer edad;

    public Chofer(){
        
    }
    
    public Chofer(Integer nroChofer, String nombre, String apellido, Integer edad) {
        this.nroChofer = nroChofer;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    public Integer getNroChofer() {
        return nroChofer;
    }

    public void setNroChofer(Integer nroChofer) {
        this.nroChofer = nroChofer;
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

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }
    
    
    
    
}
