package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseDao {


    public Course getData(int id) {
        Course st=null;
        Connection con=ConnectionFactory.getConnection();
        try {
            Statement s=con.createStatement();
            s.execute("SELECT * from courses where courseId="+id);
            ResultSet rs=s.getResultSet();
            while(rs.next())
            {
                st=new Course(rs.getInt(1),rs.getString(2),rs.getDate(3).toLocalDate(),rs.getDate(4).toLocalDate());

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


    public void insert(Course  d) {

        Connection con=ConnectionFactory.getConnection();
        try{
            PreparedStatement s=con.prepareStatement("INSERT into courses (nameCourse,beginDate,endDate) VALUES(?,?,?)");
            s.setString(1,d.getName());
            s.setDate(2,Date.valueOf(d.getBeginDate()));
            s.setDate(3,Date.valueOf(d.getEndDate()));
            s.executeUpdate();
           s.close();
        }catch(SQLException e) {
            e.printStackTrace();
        }
        finally {
            ConnectionFactory.close(con);
        }

    }

    public void delete(Course d) {

        Connection con=ConnectionFactory.getConnection();
        try{
            Statement s=con.createStatement();
            s.execute("DELETE from  courses where courseId="+d.getId());
            ConnectionFactory.close(s);
        }catch(SQLException e) {
            e.printStackTrace();
        }
        finally {
            ConnectionFactory.close(con);
        }

    }


    public void update(Course d) {
        Connection con = ConnectionFactory.getConnection();
        try {

            PreparedStatement st = con.prepareStatement("UPDATE courses SET  beginDate = ?, endDate=?,nameCourse=? WHERE courseId= ?");
            st.setDate(1, Date.valueOf( d.getBeginDate()));
            st.setDate(2, Date.valueOf( d.getEndDate()));
            st.setString(3,d.getName());
            st.setInt(4,d.getId());
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.close(con);
        }

    }

    public List<Course> getAll()
    {

        List<Course> courses=new ArrayList<Course>();

        Connection con = ConnectionFactory.getConnection();
        try {
            Statement st=con.createStatement();
            st.execute("SELECT *  from courses ");
            ResultSet rs=st.getResultSet();
            while(rs.next())
            {

                courses.add(new Course(rs.getInt(1),rs.getString(2),rs.getDate(3).toLocalDate(),rs.getDate(4).toLocalDate()));
            }

            ConnectionFactory.close(rs);
            ConnectionFactory.close(st);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.close(con);
        }


        return courses;

    }




}
