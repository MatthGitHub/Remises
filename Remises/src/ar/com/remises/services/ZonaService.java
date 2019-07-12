/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.remises.services;

import ar.com.remises.model.Zona;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author matias
 */
public class ZonaService {
    
    private static ZonaService singleton;
    
    public static ZonaService getZonaService(){
        if(singleton == null){
            return singleton = new ZonaService();
        }
        return singleton;
    }
    
    private ZonaService(){
        
    }
    
    public ArrayList<Zona> cargarZonas(){
        
        ArrayList<Zona> zonas = new ArrayList<Zona>();
        
        zonas.add(new Zona(1,"Centro","green"));
        zonas.add(new Zona(2,"Alto","red"));
        zonas.add(new Zona(3,"Kilometros","blue"));
        zonas.add(new Zona(4,"Peninsula","aqua"));
        zonas.add(new Zona(5,"Dina Huapi","yellow"));

        return zonas;
    }
    
    public Zona obtenerZonaPorNumero(Integer nroZona){
        ArrayList<Zona> zonas = cargarZonas();
        for(Zona z : zonas){
            if(z.getNroZona()== nroZona){
                return z;
            }
        }
        return null;
    }
    
    public Zona obtenerZonaPorPatron(String patron){
        ArrayList<Zona> zonas = cargarZonas();
        for(Zona z : zonas){
            if(z.getNombre().toLowerCase().contains(patron.toLowerCase())){
                return z;
            }
        }
        return null;
    }
    
}
