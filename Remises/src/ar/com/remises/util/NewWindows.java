/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.remises.util;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author claudio
 */
public class NewWindows {

    public static void openWindowsAcercaDe() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(NewWindows.class.getResource("/ar/com/tecnoaccion/comd/acercaDe.fxml"));
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
}
