/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.remises;

import ar.com.remises.model.Chofer;
import ar.com.remises.model.Remis;
import ar.com.remises.model.Unidad;
import ar.com.remises.model.Zona;
import ar.com.remises.services.ChoferService;
import ar.com.remises.services.UnidadService;
import ar.com.remises.services.ZonaService;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Matth
 */
public class ActivarUnidadController implements Initializable {

    @FXML
    private TextField txtNroUnidad,txtNroChofer,txtNroZona;
    @FXML
    private TextArea txtDetalleUnidad,txtDetalleChofer,txtDetalleZona;
    @FXML
    private HBox hboxUnidad,hboxChofer,hboxZona;
    @FXML
    private Button btnActivarUnidad;
    @FXML
    private MenuItem btnCerrarActivarUnidad;
    @FXML
    private MenuBar mbarActivarUnidad;
    
    private Unidad unidad;
    private Chofer chofer;
    private Zona zona;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnCerrarActivarUnidad.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage = (Stage) mbarActivarUnidad.getScene().getWindow();
                stage.close();
            }
        });
        
    }    
    
    public void traerUnidad(){
        String nroUnidadTxt = txtNroUnidad.getText();
        if(!nroUnidadTxt.trim().isEmpty()){
            if(validate(nroUnidadTxt)){
                Integer nroUnidad = 0;
                nroUnidad = Integer.parseInt(nroUnidadTxt);
                unidad = UnidadService.getUnidadService().obtenerUnidadPorNumero(nroUnidad);
                if(unidad != null){
                    if(HomeController.verificarUnidad(unidad)){
                        Text t = new Text();
                        t.setText(unidad.getMarca()+" --- "+unidad.getModelo());
                        t.setFill(Color.RED);
                        txtDetalleUnidad.setStyle("-fx-text-inner-color: black;");
                        txtDetalleUnidad.setText(t.getText());
                        hboxChofer.setVisible(true);
                    }else{
                        Text t = new Text();
                        t.setText(unidad.getMarca()+" --- "+unidad.getModelo()+" : ESTA UNIDAD NO ESTA DISPONIBLE");
                        t.setFill(Color.RED);
                        txtDetalleUnidad.setStyle("-fx-text-inner-color: red;");
                        txtDetalleUnidad.setText(t.getText());
                        limpiarFormulario(2);
                    }
                    
                }
            }else{
                if(!nroUnidadTxt.trim().isEmpty()){
                    unidad = UnidadService.getUnidadService().obtenerUnidadPorPatron(nroUnidadTxt);
                    if(unidad != null){
                        txtDetalleUnidad.setText(unidad.getMarca()+" --- "+unidad.getModelo());
                        hboxChofer.setVisible(true);
                    }
                }
            }
        }
    }
    
    public void traerChofer(){
        String nroChoferTxt = txtNroChofer.getText();
        if(!nroChoferTxt.trim().isEmpty()){
            if(validate(nroChoferTxt)){
                Integer nroChofer = 0;
                nroChofer = Integer.parseInt(nroChoferTxt);
                chofer = ChoferService.getChoferService().obtenerChoferPorNumero(nroChofer);
                if(chofer != null){
                    if(HomeController.verificarChofer(chofer)){
                        Text t = new Text();
                        t.setText(chofer.getNombre()+" --- "+chofer.getApellido());
                        t.setFill(Color.RED);
                        txtDetalleChofer.setStyle("-fx-text-inner-color: black;");
                        txtDetalleChofer.setText(t.getText());
                        hboxZona.setVisible(true);
                    }else{
                        Text t = new Text();
                        t.setText(chofer.getNombre()+" --- "+chofer.getApellido()+" : ESTE CHOFER NO ESTA DISPONIBLE");
                        t.setFill(Color.RED);
                        txtDetalleChofer.setStyle("-fx-text-inner-color: red;");
                        txtDetalleChofer.setText(t.getText());
                        hboxZona.setVisible(true);
                        limpiarFormulario(3);
                    }
                    
                }
            }else{
                if(!nroChoferTxt.trim().isEmpty()){
                    chofer = ChoferService.getChoferService().obtenerChoferPorPatron(nroChoferTxt);
                    if(chofer != null){
                        txtDetalleChofer.setText(chofer.getNombre()+" --- "+chofer.getApellido());
                        hboxZona.setVisible(true);
                    }
                }
            }
        }
    }
    
    public void traerZona(){
        String nroZonaTxt = txtNroZona.getText();
        if(!nroZonaTxt.trim().isEmpty()){
            if(validate(nroZonaTxt)){
                Integer nroZona = 0;
                nroZona = Integer.parseInt(nroZonaTxt);
                zona = ZonaService.getZonaService().obtenerZonaPorNumero(nroZona);
                if(zona != null){
                    txtDetalleZona.setText(zona.getNombre());
                    btnActivarUnidad.setDisable(false);
                }
            }else{
                if(!nroZonaTxt.trim().isEmpty()){
                    zona = ZonaService.getZonaService().obtenerZonaPorPatron(nroZonaTxt);
                    if(zona != null){
                        txtDetalleZona.setText(zona.getNombre());
                        btnActivarUnidad.setDisable(false);
                    }
                }
            }
        }
    }
    
    public void activarUnidad(){
        if(!txtNroChofer.getText().isEmpty()&&!txtNroUnidad.getText().isEmpty()&&!txtNroZona.getText().isEmpty()){
            Remis remis = new Remis(zona, chofer, unidad,1);
            HomeController.agregarUnidad(remis);
            limpiarFormulario(1);
        }
    }
    
    private boolean validate(String text){
        return text.matches("[0-9]*");
    }
    
    private void limpiarFormulario(Integer choose){
        
        switch(choose){
            case 1: 
                txtNroChofer.setText("");
                txtNroUnidad.setText("");
                txtNroZona.setText("");
                txtDetalleUnidad.setText("");
                txtDetalleChofer.setText("");
                txtDetalleZona.setText("");
                hboxChofer.setVisible(false);
                hboxZona.setVisible(false);
                break;
            case 2:
                txtNroChofer.setText("");
                hboxChofer.setVisible(false);
                txtNroZona.setText("");
                hboxZona.setVisible(false);
                break;
            case 3:
                txtNroZona.setText("");
                hboxZona.setVisible(false);
                break;
        }
        
    }
    
}
