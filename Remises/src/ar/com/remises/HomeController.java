/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.remises;

import ar.com.remises.model.Chofer;
import ar.com.remises.model.Remis;
import ar.com.remises.model.Unidad;
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
import javafx.scene.control.MenuItem;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;

/**
 *
 * @author matias
 */
public class HomeController implements Initializable {

    
    @FXML
    private Label logUser,version;
    @FXML
    private GridPane grillaunidades;
    //private ListView disponibleList,zonaList,ordenList;
    @FXML
    private MenuItem bActivarUnidad;
    
    private Main application;
    
    private static ObservableList<Remis> observableRemises;
    
    private static Integer orden = 1;
    
    public void setApp(Main application) {
        this.application = application;
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        inicializarObservables();
        
        //ordenList.setFixedCellSize(25);
        logUser.setText(SeguridadService.getUsuarioLogueado().getNombre()+" "+SeguridadService.getUsuarioLogueado().getApellido());
        inicializarMenu();
    }
    
    public void inicializarObservables(){
        observableRemises = FXCollections.<Remis>observableArrayList();
        observableRemises.addListener(new ListChangeListener() {
            @Override
            public void onChanged(ListChangeListener.Change c) {
                ColumnConstraints col = new ColumnConstraints(25);
                grillaunidades.getColumnConstraints().addAll(col);
                grillaunidades.add(new Label(observableRemises.get(observableRemises.size()-1).getOrden().toString()),orden-1,0);
                grillaunidades.add(new Label(observableRemises.get(observableRemises.size()-1).getUnidad().getNroUnidad().toString()),orden-1,1);
                Label l = new Label(observableRemises.get(observableRemises.size()-1).getZona().getNroZona().toString());
                l.setStyle("-fx-text-inner-color: "+observableRemises.get(observableRemises.size()-1).getZona().getColor()+";");
                grillaunidades.add(l,orden-1,2);
                orden++;
                //disponibleList.getItems().add(observableRemises.get(observableRemises.size()-1));
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
        System.out.println("Orden: "+orden);
        nuevaUnidad.setOrden(orden);
        observableRemises.add(nuevaUnidad);
        System.out.println("Se agrega remo: "+nuevaUnidad.toString());
    }
    
    public static Boolean verificarRemis(Remis remis){
        for(Remis r : observableRemises){
            Chofer c = remis.getChofer();
            Unidad u = remis.getUnidad();
            if(r.getChofer().equals(c)){
                return false;
            }
            if(r.getUnidad().equals(u)){
                return false;
            }
        }
        return true;
    }
    
    public static Boolean verificarUnidad(Unidad unidad){
        for(Remis r : observableRemises){
            if(r.getUnidad().getNroUnidad() == unidad.getNroUnidad()){
                return false;
            }
        }
        return true;
    }
    
    public static Boolean verificarChofer(Chofer chofer){
        for(Remis r : observableRemises){
            if(r.getChofer().getNroChofer() == chofer.getNroChofer()){
                return false;
            }
        }
        return true;
    }
    
}
