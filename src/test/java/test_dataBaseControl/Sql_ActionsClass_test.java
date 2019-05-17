package test_dataBaseControl;

import databaseControl.ConnectionFactory;
import databaseControl.Sql_Actions;
import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import user.ProductInfo;

import java.sql.*;
import java.util.ArrayList;

public class Sql_ActionsClass_test {
    Statement stmt;
    PreparedStatement mockprpStatement;
    Connection connection;
    ConnectionFactory connection_factory;
    Sql_Actions realDB;
    ResultSet rs;
    @Before
    public void setUp() throws SQLException {
        connection = EasyMock.createMock(Connection.class);
        connection_factory = EasyMock.createMock(ConnectionFactory.class);
        ConnectionFactory.setInstance(connection_factory);
        realDB = new Sql_Actions();
        mockprpStatement = EasyMock.createMock(PreparedStatement.class);
        EasyMock.expect(connection_factory.getInstance().getConnection("jdbc:sqlite:marketRecord.db")).andReturn(connection).anyTimes();

    }
    @Test
    public void test_InsertCustomersProduct() throws SQLException {

        //Expectations
        EasyMock.expect(connection.prepareStatement( "INSERT INTO customersRecords(customerId, typeId, productsName, amount, price) VALUES(?,?,?,?,?)")).andReturn(mockprpStatement).once();
        mockprpStatement.setInt(1, 2346);
        EasyMock.expectLastCall();
        mockprpStatement.setInt(2, 1);
        EasyMock.expectLastCall();
        mockprpStatement.setString(3, "Orange");
        EasyMock.expectLastCall();
        mockprpStatement.setInt(4, 2);
        EasyMock.expectLastCall();
        mockprpStatement.setDouble(5, 1.23);
        EasyMock.expectLastCall();
        EasyMock.expect(mockprpStatement.executeUpdate()).andReturn(0);
        connection.close();
        EasyMock.expectLastCall();
        mockprpStatement.close();
        EasyMock.expectLastCall();
        //Test
        EasyMock.replay(connection, mockprpStatement,connection_factory);
        realDB.insertCustomersProduct(2346, 1, "Orange", 2, 1.23);
        EasyMock.verify(connection, mockprpStatement, connection_factory);
        EasyMock.reset(connection, mockprpStatement, connection_factory);
    }

    @Test
    public void test_deleteCustomersProduct() throws SQLException {
        //Expectations
        EasyMock.expect(connection.prepareStatement( "DELETE FROM customersRecords WHERE customerId = ? AND productsName = ?")).andReturn(mockprpStatement).once();
        mockprpStatement.setInt(1, 2346);
        EasyMock.expectLastCall();
        mockprpStatement.setString(2, "Orange");
        EasyMock.expectLastCall();
        EasyMock.expect(mockprpStatement.executeUpdate()).andReturn(1);
        connection.close();
        EasyMock.expectLastCall();
        mockprpStatement.close();
        EasyMock.expectLastCall();

        //Test
        EasyMock.replay(connection, mockprpStatement,connection_factory);
        realDB.deleteCustomersProduct(2346, "Orange");
        EasyMock.verify(connection, mockprpStatement, connection_factory);
        EasyMock.reset(connection, mockprpStatement, connection_factory);

    }
    @Test
    public void test_deleteCustomer() throws SQLException {
        //Expectations
        EasyMock.expect(connection.prepareStatement( "DELETE FROM customersRecords WHERE customerId = ?")).andReturn(mockprpStatement).once();
        mockprpStatement.setInt(1, 2346);
        EasyMock.expectLastCall();
        EasyMock.expect(mockprpStatement.executeUpdate()).andReturn(0);
        connection.close();
        EasyMock.expectLastCall();
        mockprpStatement.close();
        EasyMock.expectLastCall();

        //Test
        EasyMock.replay(connection, mockprpStatement, connection_factory);
        realDB.deleteCustomer(2346);
        EasyMock.verify(connection, mockprpStatement, connection_factory);
        EasyMock.reset(connection, mockprpStatement, connection_factory);

    }
    @Test
    public void test_loadCustomerData() throws SQLException {
        //Setup
        ArrayList<ProductInfo> resultCst = new ArrayList<>();
        rs = EasyMock.createMock(ResultSet.class);
        ProductInfo prodInf = EasyMock.createMock(ProductInfo.class);
        //Expectations
        EasyMock.expect(connection.prepareStatement( "SELECT * FROM customersRecords WHERE customerId = ?")).andReturn(mockprpStatement).once();
        mockprpStatement.setInt(1, 2346);
        EasyMock.expectLastCall();
        EasyMock.expect(mockprpStatement.executeQuery()).andReturn(rs).once();
        EasyMock.expect(rs.next()).andReturn(true).once();
        EasyMock.expect(rs.getString("productsName")).andReturn("Orange").once();
        EasyMock.expect(rs.getDouble("price")).andReturn(6.5).once();
        EasyMock.expect(rs.getInt("amount")).andReturn(1).once();
        EasyMock.expect(rs.getInt("typeId")).andReturn(1).once();
        resultCst.add(prodInf);
        EasyMock.expectLastCall();
        EasyMock.expect(rs.next()).andReturn(false).once();

        connection.close();
        EasyMock.expectLastCall();
        mockprpStatement.close();
        EasyMock.expectLastCall();
        rs.close();
        EasyMock.expectLastCall();

        //Test
        EasyMock.replay(connection, mockprpStatement,rs, connection_factory);
        ArrayList<ProductInfo> answer = realDB.loadCustomerData(2346);
        EasyMock.verify(connection, mockprpStatement,rs, connection_factory);
        EasyMock.reset(connection, mockprpStatement, rs, connection_factory);
        //Asssert
        Assert.assertNotNull(answer);
    }
    @Test
    public void test_getCustomers() throws SQLException {
        ArrayList<ProductInfo> resultCst = new ArrayList<>();
        ArrayList<Integer> mockArray = new ArrayList<>();

        stmt = EasyMock.createMock(Statement.class);
        rs = EasyMock.createMock(ResultSet.class);
        //Expectations
        EasyMock.expect(connection.createStatement()).andReturn(stmt).once();
        EasyMock.expect(stmt.executeQuery("SELECT customerId FROM customersRecords")).andReturn(rs).once();

        EasyMock.expect(rs.next()).andReturn(true).once();
        EasyMock.expect(rs.getInt("customerId")).andReturn(2346).once();
        mockArray.add(2346);
        EasyMock.expectLastCall();
        EasyMock.expect(rs.next()).andReturn(false).once();

        connection.close();
        EasyMock.expectLastCall();
        stmt.close();
        EasyMock.expectLastCall();
        rs.close();
        EasyMock.expectLastCall();

        //Test
        EasyMock.replay(connection, stmt,rs, connection_factory);
        ArrayList<Integer> answer = realDB. getCustomers();
        EasyMock.verify(connection, stmt, rs, connection_factory);
        EasyMock.reset(connection, stmt, rs, connection_factory);
        //Assert
        Assert.assertNotNull(answer);
    }

    @Test
    public void test_loadCustomerDataItem() throws SQLException {
        //Setup
        rs = EasyMock.createMock(ResultSet.class);

        //Expectations
        EasyMock.expect(connection.prepareStatement( "SELECT price, amount FROM customersRecords WHERE typeId = ? AND customerId = ?")).andReturn(mockprpStatement).once();
        mockprpStatement.setInt(1, 1);
        EasyMock.expectLastCall();
        mockprpStatement.setInt(2, 2346);
        EasyMock.expectLastCall();
        EasyMock.expect(mockprpStatement.executeQuery()).andReturn(rs).once();

        EasyMock.expect(rs.next()).andReturn(true).once();
        EasyMock.expect(rs.getDouble("price")).andReturn(10.43).once();
        EasyMock.expect(rs.getInt("amount")).andReturn(3).once();
        EasyMock.expect(rs.next()).andReturn(false).once();

        connection.close();
        EasyMock.expectLastCall();
        mockprpStatement.close();

        //Test
        EasyMock.replay(connection, mockprpStatement, connection_factory);
        Double answer = realDB.loadCustomerDataItem(2346, 1);
        EasyMock.verify(connection, mockprpStatement, connection_factory);
        EasyMock.reset(connection, mockprpStatement, connection_factory);
        //Asserts
        Assert.assertNotNull(answer);
    }
}
