package controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;

public class FXML_Administrador_PrincipalController implements Initializable {
    @FXML
    private Button boton_Farmacias;
    @FXML
    private FlowPane submenu_Farmacias;
    @FXML
    private Button boton_Todas_las_Farmacias;
    @FXML
    private Button boton_Agregar_Farmacia;
    @FXML
    private Button boton_Clientes;
    @FXML
    private FlowPane submenu_Clientes;
    @FXML
    private Button boton_Todos_los_Clientes;
    @FXML
    private Button boton_borrar_Clientes;
    @FXML
    private Button boton_Repartidores;
    @FXML
    private FlowPane submenu_Repartidores;
    @FXML
    private Button boton_Todos_los_Repartidores;
    @FXML
    private Button boton_borrar_Repartidores;

    public void ocultar_Submenus(){
        this.submenu_Farmacias.setVisible(false);
        this.submenu_Clientes.setVisible(true);
        this.submenu_Repartidores.setVisible(false);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.ocultar_Submenus();
    }    
    
}
