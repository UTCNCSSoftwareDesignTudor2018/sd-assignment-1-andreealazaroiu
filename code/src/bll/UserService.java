package bll;

import dao.User;
import dao.UserDao;

public class UserService {


    //Login method
    //Boolean function that checks if the User is logged into the database

    public boolean verifyLogin(String username,String password)
    {
        User u1=new User(username,password);
        UserDao uo=new UserDao();
        User u2=uo.getDataName(username);
        if(u2!=null)
        return u2.equals(u1);
        else
            return false;

    }


}
