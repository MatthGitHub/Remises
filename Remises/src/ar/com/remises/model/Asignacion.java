/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.remises.model;

import java.util.Date;

/**
 *
 * @author Matth
 */
public class Asignacion {
    
    
    private static Integer nroAsignacion;
    private Remis remis;
    private Zona origen;
    private Zona destino;
    private Date horaPedido;

    public Integer getNroAsignacion() {
        return nroAsignacion;
    }

    public void setNroAsignacion(Integer nroAsignacion) {
        this.nroAsignacion = nroAsignacion;
    }

    public Remis getRemis() {
        return remis;
    }

    public void setRemis(Remis remis) {
        this.remis = remis;
    }

    public Zona getOrigen() {
        return origen;
    }

    public void setOrigen(Zona origen) {
        this.origen = origen;
    }

    public Zona getDestino() {
        return destino;
    }

    public void setDestino(Zona destino) {
        this.destino = destino;
    }

    public Date getHoraPedido() {
        return horaPedido;
    }

    public void setHoraPedido(Date horaPedido) {
        this.horaPedido = horaPedido;
    }
    
    public Asignacion cargarAsignacion(Remis r,Zona destino,Zona origen){
        this.nroAsignacion = nroAsignacion++;
        this.destino = destino;
        this.origen = origen;
        this.horaPedido = new Date();
        this.remis = r;
        
        return this;
    }
    
}
