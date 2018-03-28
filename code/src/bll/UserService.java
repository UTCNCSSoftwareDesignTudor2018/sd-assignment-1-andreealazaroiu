package bll;

import dao.AdminDao;
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

    public boolean isAdmin(String username,String password)
    {
        User u=new User(username,password);
        AdminDao a=new AdminDao();
        UserDao uo=new UserDao();
        User u2=uo.getDataName(username);
       return a.verifyIfId(u2);
    }


    /*public static void main(String [] args)
    {
        UserService us=new UserService();
        System.out.println(us.isAdmin("admin","verycomplicatedpassword"));
        System.out.println(us.isAdmin("paulaPinta","paula4ever"));
        System.out.println(us.isAdmin("floriGatu","easypassw"));

    }
    */

}
