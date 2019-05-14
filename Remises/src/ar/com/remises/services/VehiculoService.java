/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.remises.services;

import ar.com.remises.model.Vehiculo;
import java.util.ArrayList;

/**
 *
 * @author matias
 */
public class VehiculoService {
    
    public ArrayList<Vehiculo> cargarVehiculos(){
        
        ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
        
        vehiculos.add(new Vehiculo(1, "Toyota", "Corolla"));
        vehiculos.add(new Vehiculo(2, "Renault", "Sandero"));
        vehiculos.add(new Vehiculo(3, "Fiat", "Siena"));
        vehiculos.add(new Vehiculo(4, "Renault", "Kangoo"));
        vehiculos.add(new Vehiculo(5, "Volkwagen", "Bora"));
        return vehiculos;
    }
    
}
