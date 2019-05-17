package actionsPackage.customer;

import actionsPackage.login.LoginController;
import databaseControl.Sql_Actions;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import static actionsPackage.login.LoginController.customer;


public class CustomerController {
    String prcName, prcAmmount, prcPrice, prcGroup;

    ObservableList<String> choiceData = FXCollections.observableArrayList("Laisvalaikis", "Maistas", "Kita");

    private static ArrayList<String> choiceList = new ArrayList<>(); //For Groups -- Choice List
    Sql_Actions databaseInfo = new Sql_Actions();

    @FXML
    private Label nameLabel, amountLabel, priceLabel, groupLabel, dateLabel;

    @FXML
    private TextField nameField, amountField, priceField;

    @FXML
    private Button addPurchaseBtn, deletePurchaseBtn, diagramBtn, exitBtn, loadInfoDB;

    @FXML
    private ChoiceBox<String> chooseGroup;

    @FXML
    private ListView<String> purchaseList;


    @FXML
    void addPurchaseList(ActionEvent event) {

        prcName = nameField.getText();
        prcPrice = priceField.getText();
        prcAmmount = amountField.getText();
        prcGroup = chooseGroup.getValue();

        if(prcName.isEmpty() || prcPrice.isEmpty() || prcAmmount.isEmpty() || prcGroup.isEmpty() || prcName.contains(" ")) {

            System.out.println("You didn't typed data correctly, try again");

        }
        else {
            customer.add_item(prcName, Double.parseDouble(prcPrice), Integer.parseInt(prcAmmount), checkGroupId(prcGroup));
            String concStrings = prcName + " " + prcPrice + " " + prcAmmount + " " + prcGroup;

            purchaseList.getItems().add(concStrings);
        }
        nameField.setText("");
        amountField.setText("");
        priceField.setText("");
    }
    @FXML
    void deletePurchaseList(ActionEvent event) {

        String info = new String();
        String selectedStudent = purchaseList.getSelectionModel().getSelectedItem();

        info = purchaseList.getSelectionModel().getSelectedItem();
        String[] infoAr = info.split(" ");

        customer.dataBase.deleteCustomersProduct(customer.getId(), infoAr[0]);

        purchaseList.getItems().remove(purchaseList.getSelectionModel().getSelectedItem());
    }
    @FXML
    void addOptions()
    {
        chooseGroup.setItems(choiceData);
    }
    @FXML
    void show_Pie_Diagram(ActionEvent event)
    {
        Stage primaryStage = new Stage();
        PieChart pieChart = new PieChart();

        PieChart.Data slice1 = new PieChart.Data("Maistas", databaseInfo.loadCustomerDataItem(customer.getId(), 2));
        PieChart.Data slice2 = new PieChart.Data("Laisvalaikis", databaseInfo.loadCustomerDataItem(customer.getId(), 1));
        PieChart.Data slice3 = new PieChart.Data("Kita" , databaseInfo.loadCustomerDataItem(customer.getId(), 3));

        pieChart.getData().add(slice1);
        pieChart.getData().add(slice2);
        pieChart.getData().add(slice3);

        VBox vbox = new VBox(pieChart);

        Scene scene = new Scene(vbox, 500, 500);

        primaryStage.setScene(scene);
        primaryStage.setHeight(500);
        primaryStage.setWidth(500);

        primaryStage.show();
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
    void loadData()
    {
        loadInfoDB.setDisable(true);
        customer.myBag.setCustomersBag(LoginController.customer.dataBase.loadCustomerData(customer.getId()));
        purchaseList.getItems().clear();
        for(int i = 0; i < customer.myBag.getCustomersBag().size(); i++)
        {
            String object = customer.myBag.getCustomersBag().get(i).getName() + " " +
                    customer.myBag.getCustomersBag().get(i).getPrice() + " " +
                    customer.myBag.getCustomersBag().get(i).getAmount() + " " +
                    checkGroupId(customer.myBag.getCustomersBag().get(i).getProduct_Type_Id());

            purchaseList.getItems().add(object);
            }
    }


    public Integer checkGroupId(String type)//Tested method
    {
        int answerType;
        switch(type){
            case "Laisvalaikis":
                answerType =  1;
                break;
            case  "Maistas":
                answerType = 2;
                break;
            case "Kita":
                answerType = 3;
                break;
            default:
                answerType = -1;
                break;
        }
        return answerType;
    }

    public String checkGroupId(Integer index)//Tested method
    {
        String answerType;
        switch(index){
            case 1:
                answerType =  "Laisvalaikis";
                break;
            case  2:
                answerType = "Maistas";
                break;
            case 3:
                answerType ="Kita";
                break;
            default:
                answerType = "Not defined";
                break;
        }
        return answerType;
    }

}
