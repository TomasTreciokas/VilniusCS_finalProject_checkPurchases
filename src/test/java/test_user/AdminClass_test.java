//Admin keyPass can only be 2222

package test_user;

import org.junit.Assert;
import org.junit.Test;
import user.Admin;

public class AdminClass_test {
   @Test
    public void test_setKeyPass_WhenValid(){
       //Setup
       Admin fakeAdmin = new Admin();
       //Test
       fakeAdmin.setKeyPass(2222);
       int answer = fakeAdmin.getKeyPass();
       //Assert
       Assert.assertEquals(2222, answer);
   }
    @Test
    public void test_setKeyPass_WhenPositive(){
        //Setup
        Admin fakeAdmin = new Admin();
        //Test
        fakeAdmin.setKeyPass(1237);
        int answer = fakeAdmin.getKeyPass();
        //Assert
        Assert.assertEquals(0, answer);
    }
    @Test
    public void test_setKeyPass_WhenNegative(){
        //Setup
        Admin fakeAdmin = new Admin();
        //Test
        fakeAdmin.setKeyPass(-1222);
        int answer = fakeAdmin.getKeyPass();
        //Assert
        Assert.assertEquals(0, answer);
    }
}