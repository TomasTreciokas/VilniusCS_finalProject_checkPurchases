package test_user;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Test;
import user.ProductInfo;
import user.YourBag;
import user.YourBagFactory;

import java.util.ArrayList;


public class YourBagClass_test {

    YourBag myBag;

    @Test
    public void test_setCustomersBagItem(){
        //Setup
        myBag = EasyMock.createMock(YourBag.class);
        YourBagFactory.setBag(myBag);
        //Expectations
        myBag.setCustomerBagItem(EasyMock.isA(ProductInfo.class));
        EasyMock.expectLastCall();
        //Tests
        EasyMock.replay(myBag);
        myBag.setCustomerBagItem(new ProductInfo("name", 2.49, 3, 1));
        EasyMock.verify(myBag);
        EasyMock.reset(myBag);
    }
    @Test
    public void test_removeCustomerBagItem(){
        //Setup
        myBag = EasyMock.createMock(YourBag.class);
        YourBagFactory.setBag(myBag);
        //Expectations
        EasyMock.expect(myBag.removeCustomerBagItem(1)).andReturn(true).once();
        EasyMock.expectLastCall();
        //Test
        EasyMock.replay(myBag);
        myBag.removeCustomerBagItem(1);
        EasyMock.verify(myBag);
        EasyMock.reset(myBag);
    }
    @Test
    public void test_removeCustomerBagItem_withNegative(){
        //Setup
        YourBag mockBag = new YourBag();
        //Test
        //Setup
        myBag = EasyMock.createMock(YourBag.class);
        YourBagFactory.setBag(myBag);
        //Expectations
        EasyMock.expect(myBag.removeCustomerBagItem(-1)).andReturn(false).once();
        EasyMock.expectLastCall();
        //Test
        EasyMock.replay(myBag);
        myBag.removeCustomerBagItem(-1);
        EasyMock.verify(myBag);
        EasyMock.reset(myBag);

    }
    @Test
    public void test_setCustomersBag(){
        //Setup
        myBag = EasyMock.createMock(YourBag.class);
        YourBagFactory.setBag(myBag);
        //Expectations
        myBag.setCustomersBag(EasyMock.isA(ArrayList.class));
        EasyMock.expectLastCall();
        //Test
        EasyMock.replay(myBag);
        myBag.setCustomersBag(new ArrayList<ProductInfo>());
        EasyMock.verify(myBag);
        EasyMock.reset(myBag);
    }
    @Test
    public void test_getCustomersBag(){
        //Setup
        myBag = EasyMock.createMock(YourBag.class);
        YourBagFactory.setBag(myBag);
        //Expectations
        EasyMock.expect(myBag.getCustomersBag()).andReturn(new ArrayList<ProductInfo>()).once();
        EasyMock.expectLastCall();
        //test
        EasyMock.replay(myBag);
        ArrayList<ProductInfo> answer = myBag.getCustomersBag();
        EasyMock.verify(myBag);
        EasyMock.reset(myBag);
        //Asserts
        Assert.assertEquals(new ArrayList<ProductInfo>(), answer);

    }
}
