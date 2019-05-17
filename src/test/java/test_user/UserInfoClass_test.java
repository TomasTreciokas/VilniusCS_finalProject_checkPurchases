package test_user;

import org.junit.Test;
import user.UserInfo;

import static org.junit.Assert.*;

public class UserInfoClass_test {
    @Test
    public void test_setId(){

        //setup
        UserInfo ui1 = new UserInfo();
        UserInfo ui2 = new UserInfo();
        UserInfo ui3 = new UserInfo();
        UserInfo ui4 = new UserInfo();

        //Testing
        //1. When good ID
        ui1.setId(1235);
        int answer1 = ui1.getId();
        //2. When negative ID
        ui2.setId(1235);
        ui2.setId(-1236);
        int answer2 = ui2.getId();
        //3. When zero ID
        ui3.setId(1235);
        ui3.setId(0000);
        int answer3 = ui3.getId();
        //4. If admin ID was set for customer by accident
        ui4.setId(1235);
        ui4.setId(1234);
        int answer4 = ui4.getId();

        //Asserts
        assertEquals(1235, answer1);
        assertEquals(1235, answer2);
        assertEquals(1235, answer3);
        assertEquals(1235, answer4);
    }
}
