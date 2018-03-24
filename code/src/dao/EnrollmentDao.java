package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EnrollmentDao {

    public Enrollment getData(int id) {

        StudentDao stud=new StudentDao();
        CourseDao co=new CourseDao();
        ExamDao ex=new ExamDao();

        Enrollment st=null;
        Connection con=ConnectionFactory.getConnection();
        try {
            Statement s=con.createStatement();
            s.execute("SELECT * from enrollments  where enrollmentId="+id);
            ResultSet rs=s.getResultSet();
            while(rs.next())
            {
                st=new Enrollment(rs.getInt(5),stud.getData(rs.getInt(1)),co.getData(rs.getInt(2)),ex.getData(rs.getInt(3)),rs.getInt(4));

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


    public void insert(Enrollment  d) {


        StudentDao stud=new StudentDao();
        CourseDao co=new CourseDao();
        ExamDao ex=new ExamDao();

        Connection con=ConnectionFactory.getConnection();
        try{
            PreparedStatement s=con.prepareStatement("INSERT into enrollments (studentId,courseId,examId,grade) VALUES(?,?,?,?)");
            s.setInt(1,d.getStudent().getId());
            s.setInt(2,d.getCourse().getId());
            s.setInt(3,d.getExam().getId());
            s.setInt(4,d.getGrade());
            s.executeUpdate();
            s.close();
        }catch(SQLException e) {
            e.printStackTrace();
        }
        finally {
            ConnectionFactory.close(con);
        }

    }


    public void delete(Enrollment d) {


        Connection con=ConnectionFactory.getConnection();
        try{
            Statement s=con.createStatement();
            s.execute("DELETE from  enrollments where enrollmentId="+d.getEnrollId());
            ConnectionFactory.close(s);
        }catch(SQLException e) {
            e.printStackTrace();
        }
        finally {
            ConnectionFactory.close(con);
        }

    }


    public void update(Enrollment d) {

        Connection con = ConnectionFactory.getConnection();
        try {

            PreparedStatement st = con.prepareStatement("UPDATE enrollments SET  studentId= ?, courseId=?,examId=?,grade=? WHERE enrollmentId= ?");
            st.setInt(1, d.getStudent().getId());
            st.setInt(2, d.getCourse().getId());
            st.setInt(3,d.getExam().getId());
            st.setInt(4,d.getGrade());
            st.setInt(5,d.getEnrollId());

            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.close(con);
        }

    }


    public List<Enrollment> getAll()
    {
        StudentDao stud=new StudentDao();
        CourseDao co=new CourseDao();
        ExamDao ex=new ExamDao();

        List<Enrollment> enrollments=new ArrayList<Enrollment>();

        Connection con = ConnectionFactory.getConnection();
        try {
            Statement st=con.createStatement();
            st.execute("SELECT studentId,courseId,examId,grade,enrollmentId  from enrollments");
            ResultSet rs=st.getResultSet();
            while(rs.next())
            {

                enrollments.add(new Enrollment(rs.getInt(5),stud.getData(rs.getInt(1)),co.getData(rs.getInt(2)),ex.getData(rs.getInt(3)),rs.getInt(4)));
            }

            ConnectionFactory.close(rs);
            ConnectionFactory.close(st);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.close(con);
        }


        return enrollments;

    }
}
