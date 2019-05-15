/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.remises.services;

import ar.com.remises.model.Chofer;
import java.util.ArrayList;

/**
 *
 * @author Matth
 */
public class ChoferService {
    
    private static ChoferService singleton;
    
    private ChoferService(){
        
    }
    
    public static ChoferService getChoferService(){
        if(singleton == null){
            singleton = new ChoferService();
        }
        return singleton;
    }
    
    public ArrayList<Chofer> cargarChoferes(){
        
        ArrayList<Chofer> choferes = new ArrayList<Chofer>();
        choferes.add(new Chofer(1, "Jose Luis", "Perales", 47));
        choferes.add(new Chofer(2, "Gaston", "Romero", 26));
        choferes.add(new Chofer(3, "Juan Roman", "Riquelme", 41));
        choferes.add(new Chofer(4, "Damian", "Gessel", 21));
        choferes.add(new Chofer(5, "Romina", "Rosas", 25));
        
        return choferes;
    }
    
    public Chofer obtenerChoferPorNumero(Integer nroChofer){
        ArrayList<Chofer> choferes = cargarChoferes();
        for(Chofer c : choferes){
            if(c.getNroChofer()== nroChofer){
                return c;
            }
        }
        return null;
    }
    
    public Chofer obtenerChoferPorPatron(String patron){
        ArrayList<Chofer> unidades = cargarChoferes();
        for(Chofer c : unidades){
            if(c.getNombre().toLowerCase().contains(patron.toLowerCase()) || c.getApellido().toLowerCase().contains(patron.toLowerCase())){
                return c;
            }
        }
        return null;
    }
}
