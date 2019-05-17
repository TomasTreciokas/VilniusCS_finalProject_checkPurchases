package actionsPackage.admin;

import actionsPackage.login.LoginController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdminInterfaceController {
    @FXML
    private Label groupEditLabel;
    @FXML
    private Button customerDeleteBtn, exitBtn, loadInfo;
    @FXML
    private TextField groupEditField;
    @FXML
    private ListView<String> customersList;

    @FXML
    public void load(ActionEvent event) {
        loadInfo.setDisable(true);
        ArrayList<Integer> customers = LoginController.admin.dataBase.getCustomers();
        for (int i = 0; i < customers.size(); i++) {
            customersList.getItems().add(String.valueOf(customers.get(i)));
        }
    }

    @FXML
    void exit_to_Login(ActionEvent event)
    {
        try {
            ((Node)(event.getSource())).getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("../../Login_Customer.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 300, 200);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Failed to create new Window.", e);
        }
    }
    @FXML
    void deleteCustomerList(ActionEvent event) {

        String selectedCustomer = customersList.getSelectionModel().getSelectedItem();

        LoginController.customer.dataBase.deleteCustomer(Integer.parseInt(selectedCustomer));

        customersList.getItems().remove(customersList.getSelectionModel().getSelectedItem());
    }
}