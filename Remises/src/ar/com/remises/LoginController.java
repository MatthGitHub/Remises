/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.remises;

import ar.com.remises.services.SeguridadService;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.util.Duration;

/**
 *
 * @author Matth
 */
public class LoginController implements Initializable {
    
    @FXML
    private TextField usuario;
    @FXML
    private PasswordField password;
    @FXML
    private Button login, confirmarServer;
    @FXML
    private Label labelError, errorMessage;
    
    private Main application;
    private SeguridadService seguridadService;
    
    public void setApp(Main application) {
        this.application = application;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        seguridadService = SeguridadService.getSeguridadService();
    }
    
    public void processLogin(ActionEvent event) {
        seguridadService.cargarUsuarios();
        if(seguridadService.login(usuario.getText(), password.getText())){
            application.gotoHome();
        }else{
            application.backupLogin();
            errorMessage.setText(seguridadService.getMensaje());
        }
    }
    
    public void logOut(ActionEvent event) {
        if (application != null) {
            
        } else {
            System.err.println("Application is null!!!");
        }
    }

    public TextField getUsuario() {
        return usuario;
    }

    public void setUsuario(TextField usuario) {
        this.usuario = usuario;
    }

    public PasswordField getPassword() {
        return password;
    }

    public void setPassword(PasswordField password) {
        this.password = password;
    }

    public Button getLogin() {
        return login;
    }

    public void setLogin(Button login) {
        this.login = login;
    }

    public Button getConfirmarServer() {
        return confirmarServer;
    }

    public void setConfirmarServer(Button confirmarServer) {
        this.confirmarServer = confirmarServer;
    }

    public Label getLabelError() {
        return labelError;
    }

    public void setLabelError(Label labelError) {
        this.labelError = labelError;
    }

    public Label getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(Label errorMessage) {
        this.errorMessage = errorMessage;
    }
    
    private void animateMessage(String evento) {
        if (evento != null && !evento.trim().isEmpty()) {
            errorMessage.setText(evento);
        }
        FadeTransition ft = new FadeTransition(Duration.millis(500), errorMessage);
        ft.setFromValue(0.0);
        ft.setToValue(1);
        ft.play();
    }
    
}
