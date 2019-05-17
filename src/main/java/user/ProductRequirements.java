package user;

abstract class ProductRequirements {

    private String name = new String();
    private Double price = 0.0;
    private int product_Type_Id = 0;
    private Integer amount = 0;

    public String getName() {
        return name;
    }

    public void setName(String name) {

        if(name!=null) {
            this.name = name;
        }
        else{
            this.name = "Not specified";
        }
    }

    public Integer getAmount() {

        return amount;

    }
    //Tested
    public void setAmount(Integer amount) {
        if(amount > 0) {
            this.amount = amount;
        }
    }

    public Double getPrice() {
        return price;
    }
    //Tested
    public void setPrice(Double price) {
        if(price>0) {
            this.price = price;
        }
    }

    public Integer getProduct_Type_Id() {
        return product_Type_Id;
    }
    //Tested
    public void setProduct_Type_Id(Integer product_Type_Id) {

        if(product_Type_Id ==1 || product_Type_Id == 2  || product_Type_Id ==3) {
            this.product_Type_Id = product_Type_Id;
        }
    }
}