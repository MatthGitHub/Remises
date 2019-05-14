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
        }else{
            return singleton;
        }
    }
    
    private ZonaService(){
        
    }
    
    public ArrayList<Zona> cargarZonas(){
        
        ArrayList<Zona> zonas = new ArrayList<Zona>();
        
        zonas.add(new Zona(1,"Centro"));
        zonas.add(new Zona(2,"Alto"));
        zonas.add(new Zona(3,"Kilometros"));
        zonas.add(new Zona(4,"Peninsula"));
        zonas.add(new Zona(5,"Dina Huapi"));

        return zonas;
    }
    
}
