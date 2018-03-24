package tel;

import dao.Admin;
import dao.AdminDao;
import org.junit.jupiter.api.Test;

public class AdminDaoTest {

    @Test
    public void getAdmin(){

        AdminDao ao=new AdminDao();

        Admin a=ao.getData(1);
        Admin a2=new Admin(1,4,"admin","verycomplicatedpassword","admin");
        assert(a.equals(a2));



    }
}
