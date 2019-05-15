/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.remises;

import ar.com.remises.model.Constants;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ObservableMap;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.AnchorPane;
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
    
    private static Scene scene;
    
    @Override
    public void start(Stage primaryStage) {
        try {
            stage = primaryStage;
            stage.setTitle("Remises");
            stage.setMinWidth(Constants.GLOBAL_WINDOW_WIDTH);
            stage.setMinHeight(Constants.GLOBAL_WINDOW_HEIGHT);
            stage.getIcons().add(new Image("ar/com/remises/resources/car-icon.png"));
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
        scene = new Scene(page, width, height);
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
            LoginController login = (LoginController) replaceSceneContent("views/login.fxml", getwStage(), gethStage());
            login.setApp(this);
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void gotoHome() {
        try {
            setwStage((stage != null && stage.getWidth() != Constants.GLOBAL_WINDOW_WIDTH) ? stage.getWidth() : Constants.GLOBAL_WINDOW_WIDTH);
            sethStage((stage != null && stage.getHeight() != Constants.GLOBAL_WINDOW_HEIGHT) ? stage.getHeight() : Constants.GLOBAL_WINDOW_HEIGHT);            
            HomeController home = (HomeController) replaceSceneContent("views/home.fxml", getwStage(), gethStage());
            home.setApp(Main.this);
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void backupLogin() {
        gotoLogin();
    }
    
    public static Scene getScene(){
        return scene;
    }
    
    public static void setAccelerator(KeyCombination kc,Runnable a){
        scene.getAccelerators().put(kc, a);
    }
    
    public static void openNewWindow(String title,String fxml,double width, double height){
        Parent root;
                try {
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
                    
                    Stage window = new Stage();
                    window.setTitle(title);
                    window.setScene(new Scene(page, width, width));
                    window.sizeToScene();
                    window.show();
                    // Hide this current window (if this is what you want)
                    //((Node)(event.getSource())).getScene().getWindow().hide();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
                
    }
}
