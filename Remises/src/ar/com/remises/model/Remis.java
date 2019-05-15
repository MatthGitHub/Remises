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
    
    private static int instanciasCreadas;
    private Integer nroRemis;
    private Zona zona;
    private Chofer chofer;
    private Unidad unidad;
    private Integer orden;

    public Remis(Zona zona, Chofer chofer, Unidad unidad,Integer orden) {
        this.nroRemis = instanciasCreadas++;
        this.zona = zona;
        this.chofer = chofer;
        this.unidad = unidad;
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

    public Unidad getUnidad() {
        return unidad;
    }

    public void setUnidad(Unidad unidad) {
        this.unidad = unidad;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }
    
    @Override
    public String toString(){
        return chofer.getNroChofer().toString();
    }
    
}
