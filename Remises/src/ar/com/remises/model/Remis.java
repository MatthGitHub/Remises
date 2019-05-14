/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.remises.model;

/**
 *
 * @author matias
 * 
 * Representa la relacion entre Vehiculo, Chofer y Zona.
 */
public class Remis {
    
    private Integer nroRemis;
    private Zona zona;
    private Chofer chofer;
    private Vehiculo vehiculo;
    private Integer orden;

    public Remis(Integer nroRemis, Zona zona, Chofer chofer, Vehiculo vehiculo,Integer orden) {
        this.nroRemis = nroRemis;
        this.zona = zona;
        this.chofer = chofer;
        this.vehiculo = vehiculo;
        this.orden = orden;
    }

    public Integer getNroRemis() {
        return nroRemis;
    }

    public void setNroRemis(Integer nroRemis) {
        this.nroRemis = nroRemis;
    }

    public Zona getZona() {
        return zona;
    }

    public void setZona(Zona zona) {
        this.zona = zona;
    }

    public Chofer getChofer() {
        return chofer;
    }

    public void setChofer(Chofer chofer) {
        this.chofer = chofer;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }
    
}
