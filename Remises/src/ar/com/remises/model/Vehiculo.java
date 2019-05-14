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
public class Vehiculo {
    

    private Integer nroVehiculo;
    private String modelo;
    private String marca;

    public Vehiculo(){
        
    }
    
    public Vehiculo(Integer nroVehiculo, String modelo, String marca) {
        this.nroVehiculo = nroVehiculo;
        this.modelo = modelo;
        this.marca = marca;
    }

    public Integer getNroVehiculo() {
        return nroVehiculo;
    }

    public void setNroVehiculo(Integer nroVehiculo) {
        this.nroVehiculo = nroVehiculo;
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
