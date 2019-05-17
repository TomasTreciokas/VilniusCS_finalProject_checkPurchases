package test_user;

import databaseControl.ConnectionFactory;
import databaseControl.Sql_Actions;
import org.junit.Test;
import user.Customer;
import user.ProductInfo;
import user.YourBag;

import java.sql.*;
import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CustomerClass_test {

    YourBag myBag;
    Sql_Actions myDatabase;
    Statement stmt;
    PreparedStatement mockprpStatement;
    Connection connection;
    ConnectionFactory connection_factory;
    Sql_Actions realDB;
    ResultSet rs;

    @Test
    public void test_Delete_Item(){

        //Setup
        Customer fakeCst = new Customer();
        ArrayList<ProductInfo> fakeCst_Bag = new ArrayList<>();
        fakeCst_Bag.add(new ProductInfo("Orange", 2.46, 2, 1));
        fakeCst_Bag.add(new ProductInfo("Banana", 1.53, 4, 2));
        fakeCst.myBag.setCustomersBag(fakeCst_Bag);

        //Test
        boolean answer1 = fakeCst.delete_item(1);
        boolean answer2 = fakeCst.delete_item(49);

        //Assert
        assertTrue(answer1);
        assertFalse(answer2);
    }
}