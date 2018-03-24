package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AdminDao {

    public Admin getData(int id) {
        Admin st=null;
        Connection con=ConnectionFactory.getConnection();
        try {
            Statement s=con.createStatement();
            s.execute("SELECT adminID,users.id,username,password,admin.name from admin join users on(users.id=admin.adminID) where adminID="+id);
            ResultSet rs=s.getResultSet();
            while(rs.next())
            {
                st=new Admin(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5));

            }
            ConnectionFactory.close(rs);
            ConnectionFactory.close(s);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            ConnectionFactory.close(con);
        }

        return st;
    }

}
