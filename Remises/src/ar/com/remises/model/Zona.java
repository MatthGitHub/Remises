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
public class Zona {
    
    private Integer nroZona;
    private String nombre;
    private String color;
    
    public Zona(){
        
    }
    
    public Zona(Integer nroZona, String nombre,String color) {
        this.nroZona = nroZona;
        this.nombre = nombre;
        this.color = color;
    }

    public Integer getNroZona() {
        return nroZona;
    }

    public void setNroZona(Integer nroZona) {
        this.nroZona = nroZona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
}
