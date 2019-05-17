package test_user;

import org.junit.Assert;
import org.junit.Test;
import user.ProductInfo;

public class ProductInfoClass_test {
    @Test
    public void test_SetAmount_when_Positive(){
        //Setup
        ProductInfo fakeProdInfo = new ProductInfo();

        //Test
        fakeProdInfo.setAmount(3);
        int answer = fakeProdInfo.getAmount();

        //Assert
        Assert.assertEquals(3, answer);
    }
    @Test
    public void test_SetAmount_when_Negative(){
        //Setup
        ProductInfo fakeProdInfo = new ProductInfo();

        //Test
        fakeProdInfo.setAmount(-5);

        int answer = fakeProdInfo.getAmount();

        //Assert
        Assert.assertEquals(0, answer);
    }

    @Test
    public void test_SetAmount_when_Zero(){
        //Setup
        ProductInfo fakeProdInfo = new ProductInfo();

        //Test
        fakeProdInfo.setAmount(0);
        int answer = fakeProdInfo.getAmount();

        //Assert
        Assert.assertEquals(0, answer);
    }
    //setPrice Testing
    @Test
    public void test_SetPrice_when_Positive(){
        //Setup
        ProductInfo fakeProdInfo = new ProductInfo();

        //Test
        double answer = fakeProdInfo.getPrice();

        //Assert
        Assert.assertEquals(0.0, answer, 0.01);
    }
    @Test
    public void test_SetPrice_when_Negative(){
        //Setup
        ProductInfo fakeProdInfo = new ProductInfo();

        //Test
        fakeProdInfo.setPrice(-5.69);

        double answer = fakeProdInfo.getPrice();

        //Assert
        Assert.assertEquals(0.0, answer, 0.01);
    }

    //Testing setProduct_Type_Id
    @Test
    public void test_setProduct_Type_Id_WhenTypeIsValid(){
        //Setup
        ProductInfo prod1 = new ProductInfo();
        ProductInfo prod2 = new ProductInfo();
        ProductInfo prod3 = new ProductInfo();
        //Testi
        prod1.setProduct_Type_Id(1);
        prod2.setProduct_Type_Id(2);
        prod3.setProduct_Type_Id(3);
        int answer1 = prod1.getProduct_Type_Id();
        int answer2 = prod2.getProduct_Type_Id();
        int answer3 = prod3.getProduct_Type_Id();
        //Asserts
        Assert.assertEquals(1, answer1);
        Assert.assertEquals(2, answer2);
        Assert.assertEquals(3, answer3);
    }
    @Test
    public void test_setProduct_Type_Id_WhenTypeIsNotValid(){
        //Setup
        ProductInfo prod1 = new ProductInfo();
        ProductInfo prod2 = new ProductInfo();
        ProductInfo prod3 = new ProductInfo();
        //Test

        prod1.setProduct_Type_Id(100);
        prod2.setProduct_Type_Id(0);
        prod3.setProduct_Type_Id(-50);

        int answer1 = prod1.getProduct_Type_Id();
        int answer2 = prod2.getProduct_Type_Id();
        int answer3 = prod3.getProduct_Type_Id();
        //Asserts
        Assert.assertEquals(0, answer1);
        Assert.assertEquals(0, answer2);
        Assert.assertEquals(0, answer3);
    }
    @Test
    public void test_setName(){
        //Setup
        ProductInfo prod1 = new ProductInfo();
        ProductInfo prod2 = new ProductInfo();
        //Test
        prod1.setName("John");
        prod2.setName(null);
        String answer1 = prod1.getName();
        String answer2 = prod2.getName();
        //Assertions
        Assert.assertEquals("John", answer1);
        Assert.assertNotNull(answer2);
    }
}
