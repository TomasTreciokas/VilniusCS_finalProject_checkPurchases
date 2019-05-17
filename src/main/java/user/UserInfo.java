package user;

public class UserInfo {
    private Integer Id = 0;

    public void setId(Integer id)
    {
        if(id>0&& id!=1234)
        {
            this.Id = id;
        }
    }
    public Integer getId()
    {
        return this.Id;
    }
}