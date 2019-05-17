package user;


import java.util.ArrayList;

public class YourBag
{
    private ArrayList<ProductInfo> customersBag = new ArrayList<>();

    //Tested
    public ArrayList<ProductInfo> getCustomersBag() {
        return customersBag;
    }
    //Tested
    public void setCustomersBag(ArrayList<ProductInfo> customersBag){
        this.customersBag = customersBag;
    }
    //Tested
    public void setCustomerBagItem(ProductInfo product)
    {
        customersBag.add(product);
    }
    //Tested
    public boolean removeCustomerBagItem(int index)
    {
        if(index>=0) {
            customersBag.remove(index);
            return true;
        }
        else{
            return false;
        }
    }
}