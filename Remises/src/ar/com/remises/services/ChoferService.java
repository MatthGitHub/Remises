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
        choferes.add(new Chofer(1, "Gaston", "Romero", 26));
        choferes.add(new Chofer(1, "Juan Roman", "Riquelme", 41));
        choferes.add(new Chofer(1, "Damian", "Gessel", 21));
        choferes.add(new Chofer(1, "Romina", "Rosas", 25));
        
        return choferes;
    }
}
