package controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modelo.Farmacia_DAO_Imp;
import modelo.Farmacia_VO;

public class FXML_AdministradorController implements Initializable {
    private Farmacia_DAO_Imp farmacia_DAO;
    private ObservableList<Farmacia_VO> lista_de_Farmacias;
    private Stage stage_Principal;
    private FXML_EditarFarmaciaController controlador;
    
    @FXML
    private JFXButton boton_Farmacias;
    @FXML
    private JFXButton boton_Clientes;
    @FXML
    private JFXButton boton_Repartidores;
    @FXML
    private Pane panel_Farmacias;
    @FXML
    private Pane panel_Clientes;
    @FXML
    private Button btn_Borrar;
    @FXML
    private Pane panel_Repartidores;
    @FXML
    private JFXTextField txt_busqueda;
    @FXML
    private TableView<Farmacia_VO> tabla_Farmacias;
    @FXML
    private TableColumn<Farmacia_VO, String> colF_Id;
    @FXML
    private TableColumn<Farmacia_VO, String> colF_Nombre;
    @FXML
    private TableColumn<Farmacia_VO, String> colF_Password;
    @FXML
    private TableColumn<Farmacia_VO, String> colF_Direccion;
    @FXML
    private TableColumn<Farmacia_VO, String> colF_Cp;
    @FXML
    private TableColumn<Farmacia_VO, String> colF_Telefono;
    @FXML
    private Button btn_Agregar;
    
    public void setStagePrincipal(Stage principalStage){
        this.stage_Principal = principalStage;
    }
    
    public void setControlador(FXML_EditarFarmaciaController controller){
        this.controlador = controller;
    }
    
    public boolean mostrarEdicion(Farmacia_VO farmacia){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/vista/FXML_EditarFarmacia.fxml"));
            Parent dialogoEditar = (Parent) loader.load();
            Stage dialogoStage = new Stage();
            dialogoStage.setTitle("Farmacia");
            dialogoStage.initModality(Modality.WINDOW_MODAL);
            dialogoStage.initOwner(stage_Principal);
            Scene scene = new Scene(dialogoEditar);
            dialogoStage.setScene(scene);
            
            FXML_EditarFarmaciaController controlador = loader.getController();
            controlador.setStageEdicion(dialogoStage);
            this.setControlador(controlador);
            controlador.setFarmacia(farmacia);
            dialogoStage.showAndWait();
            return controlador.getEdicion();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public void obtenerFarmacias(){
        List lista_Consulta = null;
        try {
            lista_Consulta = farmacia_DAO.readAll();
        } catch (Exception e) {
            System.out.println("Error al leer la consulta");
        }
        Iterator it = lista_Consulta.iterator();
        lista_de_Farmacias.clear();
        while(it.hasNext()){
            lista_de_Farmacias.add((Farmacia_VO)it.next());
        }
    }
    
    public void colocarTablaFarmacias(){
        this.colF_Id.setCellValueFactory(new PropertyValueFactory<>("Id"));
        this.colF_Nombre.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
        this.colF_Password.setCellValueFactory(new PropertyValueFactory<>("Password"));
        this.colF_Direccion.setCellValueFactory(new PropertyValueFactory<>("Direccion"));
        this.colF_Cp.setCellValueFactory(new PropertyValueFactory<>("c_p"));
        this.colF_Telefono.setCellValueFactory(new PropertyValueFactory<>("Telefono"));
        this.tabla_Farmacias.setItems(lista_de_Farmacias);
    }
    
    @FXML
    private void agregar(ActionEvent event) {
        Farmacia_VO farmacia = new Farmacia_VO();
        boolean esEdicion = this.mostrarEdicion(farmacia);
        if(esEdicion){
            try{
                this.farmacia_DAO.create(farmacia);
            } catch(Exception e){
                System.out.println("Fallo en agregar");
            }
        this.obtenerFarmacias();
        this.colocarTablaFarmacias();
        this.tabla_Farmacias.getSelectionModel().selectLast();
        }
    }
    
    @FXML
    void borrar(ActionEvent event) {
        int selectedIndex = this.tabla_Farmacias.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            Farmacia_VO farmacia = this.tabla_Farmacias.getSelectionModel().getSelectedItem();
            this.tabla_Farmacias.getSelectionModel().selectLast();
            try {
                this.farmacia_DAO.delete(farmacia);
                this.obtenerFarmacias();
                this.colocarTablaFarmacias();
            } catch (Exception e) {
                System.out.println("Error al eliminar");
            }
            this.colocarTablaFarmacias();
            if (selectedIndex != 0) {
                selectedIndex--;
                this.tabla_Farmacias.getSelectionModel().select(selectedIndex);
            }
        }
    }
    
    @FXML
    void farmacias(ActionEvent event) {
        this.panel_Farmacias.toFront();
    }
    @FXML
    void clientes(ActionEvent event) {
        this.panel_Clientes.toFront();
    }
    @FXML
    void repartidores(ActionEvent event) {
        this.panel_Repartidores.toFront();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.farmacia_DAO = new Farmacia_DAO_Imp();
        this.lista_de_Farmacias = FXCollections.observableArrayList();
        this.obtenerFarmacias();
        this.colocarTablaFarmacias();
    }    
}