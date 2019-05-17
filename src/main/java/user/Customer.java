 package user;

import databaseControl.Sql_Actions;

 public class Customer extends UserInfo implements CustomerRequirements{

    public Sql_Actions dataBase = new Sql_Actions();//was changed from factory
    public YourBag myBag = new YourBag();//was change from factory

    @Override
    public void add_item(String name,  double price, int amount, int product_Type_Id)
    {
        myBag.setCustomerBagItem(new ProductInfo(name, price, amount, product_Type_Id));
        dataBase.insertCustomersProduct(getId(), product_Type_Id, name, amount, price);
    }

    @Override
    public Boolean delete_item(int index)
    {
        if(index>=0 && index < myBag.getCustomersBag().size())
        {
            myBag.removeCustomerBagItem(index);
            return true;
        }
        else{
            return false;
        }
    }
}