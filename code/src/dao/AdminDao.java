package dao;

import java.sql.*;

public class AdminDao {

    public Admin getData(int id) {
        Admin st = null;
        Connection con = ConnectionFactory.getConnection();
        try {
            Statement s = con.createStatement();
            s.execute("SELECT adminID,users.id,username,password,admin.name from admin join users on(users.id=admin.adminID) where adminID=" + id);
            ResultSet rs = s.getResultSet();
            while (rs.next()) {
                st = new Admin(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5));

            }
            ConnectionFactory.close(rs);
            ConnectionFactory.close(s);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.close(con);
        }

        return st;
    }

    public Admin getDataName(String admin) {
        Admin st = null;
        Connection con = ConnectionFactory.getConnection();
        try {
            PreparedStatement s = con.prepareStatement("SELECT adminID,users.id,username,password,admin.name from admin join users on(users.id=admin.adminID) where name=?");
            s.setString(1,admin);
            ResultSet rs = s.executeQuery();
            while (rs.next()) {
                st = new Admin(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5));

            }
            ConnectionFactory.close(rs);
            ConnectionFactory.close(s);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.close(con);
        }

        return st;
    }

    public boolean verifyIfId(User admin)
    {
        Connection con=ConnectionFactory.getConnection();
        boolean yes=false;
       try{
            PreparedStatement s=con.prepareStatement("SELECT admin.id  from admin join users on (admin.adminID=users.id) where admin.id=?");
            s.setInt(1,admin.getUserId());
            ResultSet rs=s.executeQuery();
            if(rs.next())
                yes=true;
            else
                yes=false;
            ConnectionFactory.close(rs);
            ConnectionFactory.close(s);
            }
            catch (SQLException e) {
            e.printStackTrace();
            } finally {
        ConnectionFactory.close(con);
             }
             return yes;


    }
}

