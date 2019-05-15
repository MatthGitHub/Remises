/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.remises;

import ar.com.remises.model.Remis;
import ar.com.remises.model.Zona;
import ar.com.remises.services.SeguridadService;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;

/**
 *
 * @author matias
 */
public class HomeController implements Initializable {

    
    @FXML
    private Label logUser,version;
    @FXML
    private ListView disponibleList,zonaList,ordenList;
    @FXML
    private MenuItem bActivarUnidad;
    
    private Main application;
    
    private static ObservableList<Remis> observableRemises;
    private static ObservableList<Integer> observableOrden;
    private static ObservableList<Zona> observableZona;
    
    private static Integer orden = 1;
    
    public void setApp(Main application) {
        this.application = application;
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        inicializarObservables();
        logUser.setText(SeguridadService.getUsuarioLogueado().getNombre()+" "+SeguridadService.getUsuarioLogueado().getApellido());
        inicializarMenu();
    }
    
    public void inicializarObservables(){
        observableRemises = FXCollections.<Remis>observableArrayList();
        observableRemises.addListener(new ListChangeListener() {
            @Override
            public void onChanged(ListChangeListener.Change c) {
                disponibleList.getItems().add(observableRemises.get(observableRemises.size()-1));
            }
        });
        
        observableOrden = FXCollections.<Integer>observableArrayList();
        observableOrden.addListener(new ListChangeListener() {
            @Override
            public void onChanged(ListChangeListener.Change c) {
                ordenList.getItems().add(observableOrden.get(observableOrden.size()-1));
            }
        });
        
        observableZona = FXCollections.<Zona>observableArrayList();
        observableZona.addListener(new ListChangeListener() {
            @Override
            public void onChanged(ListChangeListener.Change c) {
                zonaList.getItems().add(observableZona.get(observableZona.size()-1));
            }
        });
    }
    
    public void logOut(ActionEvent event){
        if(application!=null){

        }
    }
    
    public void acercaDe(ActionEvent event){
        Main.openNewWindow("Acerca de", "views/acercaDe.fxml", 400, 200);
    }
    
    private void inicializarMenu(){
        bActivarUnidad.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Main.openNewWindow("Activar unidad", "views/activarUnidad.fxml", 400, 400);
            }
        });
    }
    
    public static void agregarUnidad(Remis nuevaUnidad){
        observableOrden.add(orden);
        System.out.println("Orden: "+orden);
        observableRemises.add(orden-1,nuevaUnidad);
        orden++;
        System.out.println("Se agrega remo: "+nuevaUnidad.toString());
    }
    
}
