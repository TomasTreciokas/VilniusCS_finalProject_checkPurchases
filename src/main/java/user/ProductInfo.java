package user;

public class ProductInfo extends ProductRequirements{

    public ProductInfo(){

    }

    public ProductInfo(String name,  double price, int amount, int product_Type_Id)
    {
        setName(name);
        setAmount(amount);
        setPrice(price);
        setProduct_Type_Id(product_Type_Id);
    }
}