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
public class Unidad {
    

    private Integer nroUnidad;
    private String modelo;
    private String marca;

    public Unidad(){
        
    }
    
    public Unidad(Integer nroVehiculo, String modelo, String marca) {
        this.nroUnidad = nroVehiculo;
        this.modelo = modelo;
        this.marca = marca;
    }

    public Integer getNroUnidad() {
        return nroUnidad;
    }

    public void setNroUnidad(Integer nroUnidad) {
        this.nroUnidad = nroUnidad;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    
}
