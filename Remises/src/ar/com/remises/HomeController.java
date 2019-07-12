/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.remises;

import ar.com.remises.model.Asignacion;
import ar.com.remises.model.Chofer;
import ar.com.remises.model.Remis;
import ar.com.remises.model.Unidad;
import ar.com.remises.services.SeguridadService;
import java.net.URL;
import java.util.Calendar;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.util.Callback;

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
    private MenuItem bActivarUnidad,bAsignarServicio;
    @FXML
    private TableView<Asignacion> tblOperaciones;
    
    private static ObservableList<Asignacion> observableAsignaciones;
    
    private Main application;
    
    private static ObservableList<Remis> observableRemises;
    
    private static Integer orden = 1;
    
    public void setApp(Main application) {
        this.application = application;
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        inicializarObservables();
        //observableAsignaciones.add(new Asignacion());
        //tblOperaciones.getItems().add(new Asignacion());
        //ordenList.setFixedCellSize(25);
        logUser.setText(SeguridadService.getUsuarioLogueado().getNombre()+" "+SeguridadService.getUsuarioLogueado().getApellido());
        inicializarMenu();
    }
    
    public void inicializarObservables(){
        observableRemises = FXCollections.<Remis> observableArrayList();
        observableRemises.addListener(new ListChangeListener() {
            @Override
            public void onChanged(ListChangeListener.Change c) {
                ColumnConstraints col = new ColumnConstraints(25);
                grillaunidades.getColumnConstraints().addAll(col);
                grillaunidades.add(new Label(observableRemises.get(observableRemises.size()-1).getOrden().toString()),orden-1,0);
                grillaunidades.add(new Label(observableRemises.get(observableRemises.size()-1).getUnidad().getNroUnidad().toString()),orden-1,1);
                Label l = new Label(observableRemises.get(observableRemises.size()-1).getZona().getNroZona().toString());
                l.setStyle("-fx-text-fill: "+observableRemises.get(observableRemises.size()-1).getZona().getColor()+";");
                grillaunidades.add(l,orden-1,2);
                orden++;
                //disponibleList.getItems().add(observableRemises.get(observableRemises.size()-1));
            }
        });
        
        observableAsignaciones = FXCollections.<Asignacion> observableArrayList();
        Callback<TableColumn, TableCell> cellFactory = new Callback<TableColumn, TableCell>() {
                     
                    @Override
                    public TableCell call(TableColumn p) {

                        if((p.getText().equals("Origen"))||(p.getText().equals("Destino"))){
                            return new EditingCellString();
                        }else if(p.getText().equals("Mov")){
                            return new EditingCellNumber();
                        } else {
                            return new TableCell();
                        }
                    }
                };
        for(int i = 0; i <tblOperaciones.getColumns().size(); i ++){
            TableColumn tc = (TableColumn) tblOperaciones.getColumns().get(i);
            tc.setCellFactory(cellFactory);
        }
        tblOperaciones.setItems(observableAsignaciones);
        
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
        
        bAsignarServicio.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Aca deberia editar una fila");
                
                //observableAsignaciones.add(new Asignacion().cargarAsignacion(r, destino, origen));
                if(hayRemisesDsiponibles()){
                    tblOperaciones.getItems().add(new Asignacion());

                        TableColumn<Asignacion,?> tc = tblOperaciones.getColumns().get(2);
                        tblOperaciones.requestFocus();
                        tblOperaciones.getSelectionModel().select(tblOperaciones.getItems().size()-1,tc);
                        tblOperaciones.scrollTo(0);
                        TablePosition<Asignacion, ?> pos = tblOperaciones.getFocusModel().getFocusedCell() ;
                    Platform.runLater(() ->
                    {
                        if (pos != null) {
                            tblOperaciones.edit(pos.getRow(),pos.getTableColumn());
                        }
                    });

                }

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

    public Boolean hayRemisesDsiponibles(){
        if(observableRemises.isEmpty()){
            return false;
        }else{
            return true;
        }
    }

    public static Remis buscarRemis(Integer unidad){

        for(Remis r : observableRemises){
            if(r.getUnidad().getNroUnidad().equals(unidad)){
                return r;
            }
        }
        return null;
    }

    public static void agregarAsignacion(Asignacion nueva){

        observableAsignaciones.add(nueva);

    }

    public static boolean quitarDisponible(Remis r){
        if(observableRemises.contains(r)){
            observableRemises.remove(r);
            return true;
        }else{
            return false;
        }
    }
    
}

class EditingCellNumber extends TableCell<XYChart.Data, Number> {
          
        private TextField textField;
          
        public EditingCellNumber() {}
          
        @Override
        public void startEdit() {
              
            super.startEdit();
              
            if (textField == null) {
                createTextField();
            }
              
            setGraphic(textField);
            setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
            textField.selectAll();
        }
          
        @Override
        public void cancelEdit() {
            super.cancelEdit();
              
            setText(String.valueOf(getItem()));
            setContentDisplay(ContentDisplay.TEXT_ONLY);
        }
          
        @Override
        public void updateItem(Number item, boolean empty) {
            super.updateItem(item, empty);
              
            if (empty) {
                setText(null);
                setGraphic(null);
            } else {
                if (isEditing()) {
                    if (textField != null) {
                        //Buscar la asignacion

                        textField.setText(getString());
                    }
                    setGraphic(textField);
                    setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
                } else {
                    setText(getString());
                    setContentDisplay(ContentDisplay.TEXT_ONLY);
                }
            }
        }
          
        private void createTextField() {
            textField = new TextField(getString());
            textField.setMinWidth(this.getWidth() - this.getGraphicTextGap()*2);
            textField.setOnKeyPressed(new EventHandler<KeyEvent>() {
                  
                @Override
                public void handle(KeyEvent t) {
                    if (t.getCode() == KeyCode.ENTER) {
                        Remis r = HomeController.buscarRemis(Integer.parseInt(textField.getText()));
                        if(r != null){
                            Asignacion a = new Asignacion();
                            a.setHoraPedido(Calendar.getInstance().getTime());
                            a.setRemis(r);
                            HomeController.agregarAsignacion(a);
                        }else{
                            cancelEdit();
                        }

                    } else if (t.getCode() == KeyCode.ESCAPE) {
                        cancelEdit();
                    }
                }
            });
        }
          
        private String getString() {
            return getItem() == null ? "" : getItem().toString();
        }
    }


class EditingCellString extends TableCell<XYChart.Data, String> {
          
        private TextField textField;
          
        public EditingCellString() {}
          
        @Override
        public void startEdit() {
              
            super.startEdit();
              
            if (textField == null) {
                createTextField();
            }
              
            setGraphic(textField);
            setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
            textField.selectAll();
        }
          
        @Override
        public void cancelEdit() {
            super.cancelEdit();
              
            setText(String.valueOf(getItem()));
            setContentDisplay(ContentDisplay.TEXT_ONLY);
        }
          
        @Override
        public void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);
              
            if (empty) {
                setText(null);
                setGraphic(null);
            } else {
                if (isEditing()) {
                    if (textField != null) {
                        textField.setText(getString());
                    }
                    setGraphic(textField);
                    setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
                } else {
                    setText(getString());
                    setContentDisplay(ContentDisplay.TEXT_ONLY);
                }
            }
        }
          
        private void createTextField() {
            textField = new TextField(getString());
            textField.setMinWidth(this.getWidth() - this.getGraphicTextGap()*2);
            textField.setOnKeyPressed(new EventHandler<KeyEvent>() {
                  
                @Override
                public void handle(KeyEvent t) {
                    if (t.getCode() == KeyCode.ENTER) {
                        commitEdit(textField.getText());
                    } else if (t.getCode() == KeyCode.ESCAPE) {
                        cancelEdit();
                    }
                }
            });
        }
          
        private String getString() {
            return getItem() == null ? "" : getItem().toString();
        }

    }
