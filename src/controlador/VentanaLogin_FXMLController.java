package controlador;

import modelo.UsuarioLogin_VO;
import modelo.UsuarioLogin_DAO_Imp;
import modelo.Administrador_DAO_Imp;
import modelo.Administrador_VO;
import modelo.Farmacia_DAO_Imp;
import modelo.Farmacia_VO;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;

public class VentanaLogin_FXMLController implements Initializable {

    private UsuarioLogin_DAO_Imp implementacionDAO;
    private Administrador_DAO_Imp implementacionAdministradorDAO;
    private Farmacia_DAO_Imp implementacionFarmaciaDAO;
    //private UsuarioLogin_DAO_Imp implementacionDAO;
    private List<UsuarioLogin_VO> listaDeUsuarios;
    private List<Administrador_VO> listaDeAdministradores;
    private List<Farmacia_VO> listaDeFarmacias;
    //private List<UsuarioLogin_VO> listaDeUsuarios;
    private FXML_AdministradorController controlador;
    private Stage stage_Principal;
    private int tipo = 0;

    @FXML
    private TextField campoEmail;
    @FXML
    private TextField campoPassword;
    @FXML
    private Button botonIngresar;
    @FXML
    private Button botonRegistro;
    @FXML
    private CheckBox checkBoxCliente;
    @FXML
    private CheckBox checkBoxFarmacia;
    @FXML
    private CheckBox checkBoxRepartidor;
    @FXML
    private CheckBox checkBoxAdmin;

    public void setStagePrincipal(Stage principalStage) {
        this.stage_Principal = principalStage;
    }

    public void setControlador_Admin(FXML_AdministradorController controller) {
        this.controlador = controller;
    }

    @FXML
    void ingresarEvent(ActionEvent event) {
        
        int opc = this.tipo;
        System.out.println(opc);

        switch (opc) {
            case 1:
                System.out.println("AAAAAAAAAAAAAAAAAAAA");
                validarAdmin();
                break;

            case 2:
                validarFarmacia();
                break;
        
            default:
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText("Seleccion incorrecta");
                alert.setContentText("Sin item seleccionado");
                alert.showAndWait();
                break;
        }
        

        /*
        String usuarioID = campoEmail.getText();
        String password = campoPassword.getText();
        int i = 0;
        listaDeUsuarios = null;

        try {
            listaDeUsuarios = implementacionDAO.readAll();
        } catch (Exception e) {
            System.out.println("Error al leer la consulta");

        }
        Iterator it = listaDeUsuarios.iterator();
        try {
            while (it.hasNext()) {
                UsuarioLogin_VO usuarioAux = this.listaDeUsuarios.get(i);

                if (usuarioID.equals(usuarioAux.getLoginID()) && password.equals(usuarioAux.getPassword())) {

                    //Mostrar Ventana Principal para Admins
                    mostrarAdmin();
                    break;
                } else {
                    i++;
                }
            }
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("Datos de inicio incorrectos");
            alert.setContentText("Usuario o password desconocidos");
            alert.showAndWait();
        }
*/
         
    }
    
    public void validarAdmin(){
        String usuarioID = campoEmail.getText();
        String password = campoPassword.getText();
        int i = 0;
        listaDeAdministradores = null;

        try {
            listaDeAdministradores = implementacionAdministradorDAO.readAll();
            System.out.println("EEEEEEEEEEEEEEEE");
        } catch (Exception e) {
            System.out.println("Error al leer la consulta");
        }
        Iterator it = listaDeAdministradores.iterator();
        try {
            while (it.hasNext()) {
                Administrador_VO usuarioAux = this.listaDeAdministradores.get(i);

                if (usuarioID.equals(usuarioAux.getId()) && password.equals(usuarioAux.getPassword())) {
                            mostrarAdmin();
                            break;
                } else {
                    i++;
                }
            }
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("Datos de administrador incorrectos");
            alert.setContentText("Usuario o password desconocidos");
            alert.showAndWait();
        }
    }

    public void mostrarAdmin() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/vista/FXML_Administrador.fxml"));
            Parent dialogoPrincipal = (Parent) loader.load();
            Stage ventana = (Stage) botonIngresar.getScene().getWindow();
            ventana.close();
            Scene scene = new Scene(dialogoPrincipal);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setResizable(false);

            FXML_AdministradorController controlador = loader.getController();
            stage.show();
        } catch (Exception e) {
            System.out.println("Error al mostrar Ventana ");
        }
    }
    
    public void validarFarmacia(){
        String usuarioID = campoEmail.getText();
        String password = campoPassword.getText();
        int i = 0;
        listaDeFarmacias = null;

        try {
            listaDeFarmacias = implementacionFarmaciaDAO.readAll();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Error al leer las farmacias");

        }
        Iterator it = listaDeFarmacias.iterator();
        try {
            while (it.hasNext()) {
                Farmacia_VO usuarioAux = this.listaDeFarmacias.get(i);

                if (usuarioID.equals(usuarioAux.getId()) && password.equals(usuarioAux.getPassword())) {
                            mostrarFarmacia();
                } else {
                    i++;
                }
            }
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("Datos de farmacia incorrectos");
            alert.setContentText("Usuario o password desconocidos");
            alert.showAndWait();
        }
    }
    
    public void mostrarFarmacia(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Yes");
            alert.setHeaderText("Yes");
            alert.setContentText("Yes");
            alert.showAndWait();
    }

    @FXML
    void registroEvent(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.implementacionDAO = new UsuarioLogin_DAO_Imp();
        this.listaDeUsuarios = FXCollections.observableArrayList();
    }

    @FXML
    void checkAdmin(ActionEvent event) {
        unchekAll();
        this.checkBoxAdmin.setSelected(true);
        this.tipo = 1;
    }

    
    @FXML
    void checkFarmacia(ActionEvent event) {
        unchekAll();
        this.checkBoxFarmacia.setSelected(true);
        this.tipo = 2;
    }
    
    
    @FXML
    void checkCliente(ActionEvent event) {
        unchekAll();
        this.checkBoxCliente.setSelected(true);
        this.tipo = 3;
    }


    @FXML
    void checkRepartidor(ActionEvent event) {
        unchekAll();
        this.checkBoxRepartidor.setSelected(true);
        this.tipo = 4;
    }

    public void unchekAll() {
        this.checkBoxAdmin.setSelected(false);
        this.checkBoxCliente.setSelected(false);
        this.checkBoxFarmacia.setSelected(false);
        this.checkBoxRepartidor.setSelected(false);
    }
}
