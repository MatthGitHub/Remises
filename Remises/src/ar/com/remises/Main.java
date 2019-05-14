/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.remises;

import ar.com.remises.model.Constants;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author Matth
 */
public class Main extends Application {
    
    private Stage stage;
    private double wStage;
    private double hStage;
    
    private final double MINIMUM_WINDOW_WIDTH = 450.0;
    private final double MINIMUM_WINDOW_HEIGHT = 450.0;
    
    @Override
    public void start(Stage primaryStage) {
        try {
            stage = primaryStage;
            stage.setTitle("Gestión Comd");
            stage.setMinWidth(Constants.GLOBAL_WINDOW_WIDTH);
            stage.setMinHeight(Constants.GLOBAL_WINDOW_HEIGHT);
            stage.getIcons().add(new Image("ar/com/tecnoaccion/comd/style/iconota.jpg"));
            stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent t) {
                    Platform.exit();
                    System.exit(0);
                }
            });
            gotoLogin();
            primaryStage.show();
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    private Initializable replaceSceneContent(String fxml, double width, double height) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        InputStream in = Main.class.getResourceAsStream(fxml);
        loader.setBuilderFactory(new JavaFXBuilderFactory());
        loader.setLocation(Main.class.getResource(fxml));
        AnchorPane page;
        try {
            page = (AnchorPane) loader.load(in);
        } finally {
            in.close();
        }
        Scene scene = new Scene(page, width, height);
        stage.setScene(scene);
        stage.sizeToScene();
        //stage.centerOnScreen();
        return (Initializable) loader.getController();
    }
    
    private void gotoLogin() {
        try {
            setwStage((stage != null && stage.getWidth() != Constants.GLOBAL_WINDOW_WIDTH) ? stage.getWidth() : Constants.GLOBAL_WINDOW_WIDTH);
            sethStage((stage != null && stage.getHeight() != Constants.GLOBAL_WINDOW_HEIGHT) ? stage.getHeight() : Constants.GLOBAL_WINDOW_HEIGHT);
            //double w = (stage != null && stage.getWidth() != Constants.GLOBAL_WINDOW_WIDTH) ? stage.getWidth() : Constants.GLOBAL_WINDOW_WIDTH;
            //double h = (stage != null && stage.getHeight() != Constants.GLOBAL_WINDOW_HEIGHT) ? stage.getHeight() : Constants.GLOBAL_WINDOW_HEIGHT;
            LoginController loginSicom = (LoginController) replaceSceneContent("loginSicom.fxml", getwStage(), gethStage());
            loginSicom.setApp(this);
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public double getwStage() {
        return wStage;
    }

    public void setwStage(double wStage) {
        this.wStage = wStage;
    }

    public double gethStage() {
        return hStage;
    }

    public void sethStage(double hStage) {
        this.hStage = hStage;
    }
    
}
