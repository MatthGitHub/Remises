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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

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

    private Unidad unidad;
    private Chofer chofer;
    private Zona zona;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    
    
    public void traerUnidad(){
        String nroUnidadTxt = txtNroUnidad.getText();
        if(!nroUnidadTxt.trim().isEmpty()){
            if(validate(nroUnidadTxt)){
                Integer nroUnidad = 0;
                nroUnidad = Integer.parseInt(nroUnidadTxt);
                unidad = UnidadService.getUnidadService().obtenerUnidadPorNumero(nroUnidad);
                if(unidad != null){
                    txtDetalleUnidad.setText(unidad.getMarca()+" --- "+unidad.getModelo());
                    hboxChofer.setVisible(true);
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
                    txtDetalleChofer.setText(chofer.getNombre()+" --- "+chofer.getApellido());
                    hboxZona.setVisible(true);
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
        Remis remis = new Remis(zona, chofer, unidad,1);
        HomeController.agregarUnidad(remis);
    }
    
    private boolean validate(String text){
        return text.matches("[0-9]*");
    }
    
}
