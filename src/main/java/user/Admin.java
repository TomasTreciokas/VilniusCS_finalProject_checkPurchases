package user;

import databaseControl.Sql_Actions;

public class Admin extends UserInfo{

    private int keyPass;//password typed in Admin_interface, transport to Enum later
    public Sql_Actions dataBase = new Sql_Actions();
    public int getKeyPass() {
        return keyPass;
    }

    public void setKeyPass(int keyPass) {
        if(keyPass==2222)
        {
            this.keyPass = keyPass;
        }
    }
}