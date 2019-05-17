package actionsPackage.login;

import user.Admin;
import user.Customer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class LoginController {

    public static Admin admin = new Admin();
    public static Customer customer = new Customer();

    @FXML
    private Button submitBtn;

    @FXML
    private Text yourIdLabel;

    @FXML
    private TextField yourId;

    @FXML
    void submitAction(ActionEvent event)
    {
        if(Integer.parseInt(yourId.getText()) == 1234)
        {
            admin.setId(Integer.parseInt(yourId.getText()));
            System.out.println("Admins id was set to: " + yourId.getText() );
            try{
                ((Node) (event.getSource())).getScene().getWindow().hide();
                FXMLLoader fxmlLoade = new FXMLLoader();
                fxmlLoade.setLocation(getClass().getResource("../../Login_Admin.fxml"));
                Scene scene = new Scene(fxmlLoade.load(), 300, 200);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();

            }catch (IOException e) {
                Logger logge = Logger.getLogger(getClass().getName());
                logge.log(Level.SEVERE, "Failed to create new Window.", e);
            }
        }
        else{
            customer.setId(Integer.parseInt(yourId.getText()));
            System.out.println("Customers id was set to: " + yourId.getText() );
            try {
                ((Node) (event.getSource())).getScene().getWindow().hide();
                FXMLLoader fxmlLoad = new FXMLLoader();
                fxmlLoad.setLocation(getClass().getResource("../../Customer's_Interface.fxml"));
                Scene scene = new Scene(fxmlLoad.load(), 585, 654);
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
