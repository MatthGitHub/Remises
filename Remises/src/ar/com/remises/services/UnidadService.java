/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.remises.services;

import ar.com.remises.model.Unidad;
import java.util.ArrayList;

/**
 *
 * @author matias
 */
public class UnidadService {
    
    private static UnidadService singleton;
    
    private UnidadService(){
        
    }
    
    public static UnidadService getUnidadService(){
        if(singleton == null){
            singleton = new UnidadService();
        }
        return singleton;
    }
    
    public ArrayList<Unidad> cargarUnidades(){
        
        ArrayList<Unidad> vehiculos = new ArrayList<Unidad>();
        
        vehiculos.add(new Unidad(1, "Toyota", "Corolla"));
        vehiculos.add(new Unidad(2, "Renault", "Sandero"));
        vehiculos.add(new Unidad(3, "Fiat", "Siena"));
        vehiculos.add(new Unidad(4, "Renault", "Kangoo"));
        vehiculos.add(new Unidad(5, "Volkwagen", "Bora"));
        return vehiculos;
    }
    
    public Unidad obtenerUnidadPorNumero(Integer nroUnidad){
        ArrayList<Unidad> unidades = cargarUnidades();
        for(Unidad u : unidades){
            if(u.getNroUnidad() == nroUnidad){
                return u;
            }
        }
        return null;
    }
    
    public Unidad obtenerUnidadPorPatron(String patron){
        ArrayList<Unidad> unidades = cargarUnidades();
        for(Unidad u : unidades){
            if(u.getMarca().toLowerCase().contains(patron.toLowerCase()) || u.getModelo().toLowerCase().contains(patron.toLowerCase())){
                return u;
            }
        }
        return null;
    }
    
}
