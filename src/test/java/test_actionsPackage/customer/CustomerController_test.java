package test_actionsPackage.customer;

import actionsPackage.customer.CustomerController;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerController_test {

    @Test
    public void test_checkGroupId_When_PassingString()
    {
        //setup
        CustomerController fakeCntrl = new CustomerController();
        //test
        int answer1 = fakeCntrl.checkGroupId("Maistas");
        int answer2 = fakeCntrl.checkGroupId("Laisvalaikis");
        int answer3 = fakeCntrl.checkGroupId("Kita");
        int answer4 = fakeCntrl.checkGroupId("NotRealType");
        //asserts
        assertEquals(2, answer1);
        assertEquals(1, answer2);
        assertEquals(3, answer3);
        assertEquals(-1, answer4);

    }
    @Test
    public void test_checkGroupId_When_PassingInteger()
    {
        //setup
        CustomerController fakeCntrl = new CustomerController();
        //test
        String answer1 = fakeCntrl.checkGroupId(1);
        String answer2 = fakeCntrl.checkGroupId(2);
        String answer3 = fakeCntrl.checkGroupId(3);
        String answer4 = fakeCntrl.checkGroupId(5);
        //asserts
        assertEquals("Laisvalaikis", answer1);
        assertEquals("Maistas", answer2);
        assertEquals("Kita", answer3);
        assertEquals("Not defined", answer4);
    }
}