/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.remises;

import ar.com.remises.services.SeguridadService;
import ar.com.remises.util.NewWindows;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.Mnemonic;
import javafx.stage.Modality;
import javafx.stage.Stage;

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
    
    public void setApp(Main application) {
        this.application = application;
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //ObservableList<Integer> ordenar = FXCollections.<Integer>observableArrayList(completarOrden());
        ordenList.getItems().addAll(completarOrden());
        logUser.setText(SeguridadService.getUsuarioLogueado().getNombre()+" "+SeguridadService.getUsuarioLogueado().getApellido());
        inicializarMenu();
    }
    
    public void logOut(ActionEvent event){
        if(application!=null){

        }
    }
    
    public void acercaDe(ActionEvent event){
        NewWindows.openWindowsAcercaDe();
    }
    
    public static void openWindowsAcercaDe() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(NewWindows.class.getResource("/ar/com/remises/views/acercaDe.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setMaxWidth(400.0);
            stage.setMaxHeight(200.0);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Acerca de");
            stage.setScene(new Scene(root1));
            stage.centerOnScreen();
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(NewWindows.class.getName()).log(Level.SEVERE, null, ex);
        }

    }    
    
    public ArrayList<Integer> completarOrden(){
        ArrayList<Integer> array = new ArrayList<>();
        for(int i = 1 ; i < 26 ; i++){
            array.add(i);
        }
        
        return array;
    }
    
    private void inicializarMenu(){
        bActivarUnidad.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Main.openNewWindow("Activar unidad", "views/activarUnidad.fxml", 400, 400);
            }
        });
    }
    
}
