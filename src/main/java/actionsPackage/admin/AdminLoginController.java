package actionsPackage.admin;
import actionsPackage.login.LoginController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdminLoginController {
    @FXML
    private Text keypassText;
    @FXML
    private TextField keypass;
    @FXML
    private Button submitBtn;

    @FXML
    void check_Password(ActionEvent event){
        if(Integer.parseInt(keypass.getText()) == 2222)
        {
            LoginController.admin.setKeyPass(2222);
            try{
                ((Node)(event.getSource())).getScene().getWindow().hide();
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("../../Admin_interface.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 328, 336);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();

            }catch (IOException e) {
                Logger logger = Logger.getLogger(getClass().getName());
                logger.log(Level.SEVERE, "Failed to create new Window.", e);
            }
        }
        else{
            try {
                ((Node)(event.getSource())).getScene().getWindow().hide();
                FXMLLoader fxmlLoad = new FXMLLoader();
                fxmlLoad.setLocation(getClass().getResource("../../Login_Customer.fxml"));
                Scene scene = new Scene(fxmlLoad.load(), 300, 200);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                Logger logger = Logger.getLogger(getClass().getName());
                logger.log(Level.SEVERE, "Failed to create new Window.", e);
            }
        }
    }
}
