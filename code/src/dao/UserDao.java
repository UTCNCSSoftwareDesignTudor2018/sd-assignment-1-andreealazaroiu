package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {


    public User getData(int id) {
        User st=null;
        Connection con=ConnectionFactory.getConnection();
        try {
            Statement s=con.createStatement();
            s.execute("SELECT * from users  where id="+id);
            ResultSet rs=s.getResultSet();
            while(rs.next())
            {
                st=new User(rs.getInt(1),rs.getString(2),rs.getString(3));

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


    public User getDataName(String user){


        User st=null;
        Connection con=ConnectionFactory.getConnection();
        try {
            PreparedStatement s=con.prepareStatement("SELECT * from users where username=? ");
            s.setString(1,user);
            ResultSet rs=s.executeQuery();
            while(rs.next())
            {
                st=new User(rs.getInt(1),rs.getString(2),rs.getString(3));

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


    public void insert(User  d) {

        Connection con=ConnectionFactory.getConnection();
        try{
            PreparedStatement s=con.prepareStatement("INSERT into users (username,password) VALUES(?,?)");
            s.setString(1,d.getUsername());
            s.setString(2,d.getPassword());
            s.executeUpdate();
            s.close();
        }catch(SQLException e) {
            e.printStackTrace();
        }
        finally {
            ConnectionFactory.close(con);
        }

    }

    public void delete(User d) {

       Connection con=ConnectionFactory.getConnection();
        try{
            PreparedStatement s=con.prepareStatement("Delete from users where username=?");
            s.setString(1,d.getUsername());
            s.executeUpdate();
            ConnectionFactory.close(s);
        }catch(SQLException e) {
            e.printStackTrace();
        }
        finally {
            ConnectionFactory.close(con);
        }

    }


        public void update(User d) {

        Connection con = ConnectionFactory.getConnection();
        try {

            PreparedStatement st = con.prepareStatement("UPDATE users SET  username= ?, password=? WHERE username= ?");
            st.setString(1, d.getUsername());
            st.setString(2, d.getPassword());
            st.setString(3,d.getUsername());
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.close(con);
        }

    }

    public List<User> getAll()
        {

        List<User> users=new ArrayList<User>();

        Connection con = ConnectionFactory.getConnection();
        try {
            Statement st=con.createStatement();
            st.execute("SELECT id,username, password  from users  ");
            ResultSet rs=st.getResultSet();
            while(rs.next())
            {

                users.add(new User(rs.getInt(1),rs.getString(2),rs.getString(3)));
            }

            ConnectionFactory.close(rs);
            ConnectionFactory.close(st);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.close(con);
        }


        return users;

    }


}
