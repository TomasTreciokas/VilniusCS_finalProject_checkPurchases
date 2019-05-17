package user;

public interface CustomerRequirements {
    public void add_item(String name,  double price, int amount,int product_Type_Id);
    public Boolean delete_item(int index);
}
