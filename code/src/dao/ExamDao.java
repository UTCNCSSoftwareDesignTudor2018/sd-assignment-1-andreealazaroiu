package dao;

import javax.xml.transform.Result;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ExamDao {

    public Exam getData(int id) {
        Exam st=null;
        Connection con=ConnectionFactory.getConnection();
        try {
            Statement s=con.createStatement();
            s.execute("SELECT * from exams where examID="+id);
            ResultSet rs=s.getResultSet();
            while(rs.next())
            {
                st=new Exam(rs.getInt(1),rs.getDate(2).toLocalDate());

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

    public Exam getDataName(LocalDate examName)
    {
        Exam st=null;
        Connection con=ConnectionFactory.getConnection();
        try {
            PreparedStatement s=con.prepareStatement("SELECT * from exams where dateExam=?");
            s.setDate(1,Date.valueOf(examName));
            ResultSet rs=s.getResultSet();
            while(rs.next())
            {
                st=new Exam(rs.getInt(1),rs.getDate(2).toLocalDate());

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


    public void insert(Exam  d) {

        Connection con=ConnectionFactory.getConnection();
        try{
            PreparedStatement s=con.prepareStatement("INSERT into exams (dateExam) VALUES(?)");
            s.setDate(1,Date.valueOf(d.getDateExam()));
            s.executeUpdate();
            s.close();
        }catch(SQLException e) {
            e.printStackTrace();
        }
        finally {
            ConnectionFactory.close(con);
        }

    }

    public void delete(Exam d) {

        Connection con=ConnectionFactory.getConnection();
        try{
            Statement s=con.createStatement();
            s.execute("DELETE from  exams where examID="+d.getId());
            ConnectionFactory.close(s);
        }catch(SQLException e) {
            e.printStackTrace();
        }
        finally {
            ConnectionFactory.close(con);
        }

    }


    public void update(Exam d) {
        Connection con = ConnectionFactory.getConnection();
        try {

            PreparedStatement st = con.prepareStatement("UPDATE exams SET  dateExam = ? WHERE examID= ?");
            st.setDate(1, Date.valueOf( d.getDateExam()));
            st.setInt(2,d.getId());
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.close(con);
        }

    }

    public List<Exam> getAll()
    {

        List<Exam> courses=new ArrayList<Exam>();

        Connection con = ConnectionFactory.getConnection();
        try {
            Statement st=con.createStatement();
            st.execute("SELECT *  from exams ");
            ResultSet rs=st.getResultSet();
            while(rs.next())
            {

                courses.add(new Exam(rs.getInt(1),rs.getDate(3).toLocalDate()));
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
