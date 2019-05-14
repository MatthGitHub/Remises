/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.remises;

import ar.com.remises.services.ZonaService;
import ar.com.remises.util.NewWindows;
import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.jmx.MXNodeAlgorithm;
import com.sun.javafx.jmx.MXNodeAlgorithmContext;
import com.sun.javafx.sg.prism.NGNode;
import com.sun.org.apache.xerces.internal.impl.xs.opti.DefaultNode;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
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
    private ListView ordenList;
    
    private Main application;
    
    public void setApp(Main application) {
        this.application = application;
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //ordenList.setItems(completarOrden());
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
    
    public int[] completarOrden(){
        int[] array = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25};
        return array;
    }
}
