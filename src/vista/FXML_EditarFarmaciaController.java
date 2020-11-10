package controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import modelo.Farmacia_VO;

public class FXML_EditarFarmaciaController implements Initializable {
    private Farmacia_VO farmacia;
    private boolean edicion;
    private Stage stage_Edicion;
    
    @FXML
    private JFXTextField txt_ID;
    @FXML
    private JFXTextField txt_Nombre;
    @FXML
    private JFXTextField txt_Password;
    @FXML
    private JFXTextField txt_Direccion;
    @FXML
    private JFXTextField txt_CP;
    @FXML
    private JFXTextField txt_Telefono;
    @FXML
    private Button btn_Aceptar;
    @FXML
    private Button btn_Cancelar;
    
    
    public boolean getEdicion(){
        return this.edicion;
    }
    
    public void setStageEdicion(Stage editionStage){
        this.stage_Edicion = editionStage;
    }
    
    public void setFarmacia(Farmacia_VO d_Store){
        if(d_Store != null){
            this.farmacia = d_Store;
            this.txt_ID.setText(this.farmacia.getId());
            this.txt_Nombre.setText(this.farmacia.getNombre());
            this.txt_Password.setText(this.farmacia.getPassword());
            this.txt_Direccion.setText(this.farmacia.getDireccion());
            this.txt_CP.setText(this.farmacia.getC_p());
            this.txt_Telefono.setText(this.farmacia.getTelefono());
        }
    }
    
    @FXML
    void aceptar(ActionEvent event) {
        this.farmacia.setId(this.txt_ID.getText());
        this.farmacia.setNombre(this.txt_Nombre.getText());
        this.farmacia.setPassword(this.txt_Password.getText());
        this.farmacia.setDireccion(this.txt_Direccion.getText());
        this.farmacia.setC_p(this.txt_CP.getText());
        this.farmacia.setTelefono(this.txt_Telefono.getText());
        this.edicion = true;
        this.stage_Edicion.close();
    }

    @FXML
    void cancelar(ActionEvent event) {
        stage_Edicion.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.edicion = false;
    }   
}