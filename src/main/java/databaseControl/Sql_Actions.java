package databaseControl;

import user.ProductInfo;

import java.sql.*;
import java.util.ArrayList;

public class Sql_Actions {
     //Tested

        private Connection connect() {
            // SQLite connection string
            String url = "jdbc:sqlite:marketRecord.db";
            Connection conn = null;
            try {
                conn = ConnectionFactory.getInstance().getConnection("jdbc:sqlite:marketRecord.db");
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            return conn;
        }
   //Tested
    public void insertCustomersProduct(int customerId, int typeId, String productsName, int amount, double price) {

            String sql = "INSERT INTO customersRecords(customerId, typeId, productsName, amount, price) VALUES(?,?,?,?,?)";
        try (Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, customerId);
            pstmt.setInt(2, typeId);
            pstmt.setString(3, productsName);
            pstmt.setInt(4, amount);
            pstmt.setDouble(5, price);
            pstmt.executeUpdate();
            } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    //Tested
    public void deleteCustomersProduct(int customerId, String productName)
    {
        String sql = "DELETE FROM customersRecords WHERE customerId = ? AND productsName = ?";
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, customerId);
            pstmt.setString(2, productName);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    //Tested
    public void deleteCustomer(int id) {
        String sql = "DELETE FROM customersRecords WHERE customerId = ?";

        try (Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    //Tested
    public ArrayList<ProductInfo> loadCustomerData(int customerId){

        String sql = "SELECT * FROM customersRecords WHERE customerId = ?";

        ArrayList<ProductInfo> resultBag = new ArrayList<ProductInfo>();

        if (customerId == -1)
        {
            return null;
        }

        try (Connection conn = this.connect();
            PreparedStatement state = conn.prepareStatement(sql)){
            state.setInt(1, customerId);
            ResultSet rs = state.executeQuery();
            while(rs.next())
            {
                resultBag.add(new ProductInfo(rs.getString("productsName"),
                        rs.getDouble("price"),  rs.getInt("amount"),
                         rs.getInt("typeId") ));
            }
            rs.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return resultBag;
    }
    public ArrayList<Integer> getCustomers()
    {
        ArrayList<Integer> mockArray = new ArrayList<>();
        ArrayList<Integer> resultArray = new ArrayList<>();

        String sql = "SELECT customerId FROM customersRecords";

        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){

            while (rs.next()) {
                mockArray.add(rs.getInt("customerId"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        for (Integer element : mockArray) {

            if (!resultArray.contains(element)) {

                resultArray.add(element);
            }
        }
        return resultArray;
    }
    public Double loadCustomerDataItem (int customerId, int typeId){

        String sql = "SELECT price, amount FROM customersRecords WHERE typeId = ? AND customerId = ?";

        ArrayList<ProductInfo> resultBag = new ArrayList<ProductInfo>();

        double total = 0;

        if (customerId == -1)
        {
            return null;
        }

        try (Connection conn = this.connect();
            PreparedStatement state = conn.prepareStatement(sql)){
            state.setInt(1, typeId);
            state.setInt(2, customerId);
            ResultSet rs = state.executeQuery();
            while(rs.next())
            {
                total+=(rs.getDouble("price") *  rs.getInt("amount"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return total;
    }
}