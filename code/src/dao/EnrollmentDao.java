package dao;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EnrollmentDao {

    public Enrollment getData(int id) {

        StudentDao stud=new StudentDao();
        CourseDao co=new CourseDao();
        Enrollment st=null;
        Connection con=ConnectionFactory.getConnection();
        try {
            Statement s=con.createStatement();
            s.execute("SELECT * from enrollments  where enrollmentId="+id);
            ResultSet rs=s.getResultSet();
            while(rs.next())
            {
                st=new Enrollment(rs.getInt(5),stud.getData(rs.getInt(1)),co.getData(rs.getInt(2)),rs.getDate(3).toLocalDate(),rs.getInt(4));

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


    public Enrollment getDataName(Student stude) {

        StudentDao stud=new StudentDao();
        CourseDao co=new CourseDao();
        Enrollment st=null;
        Connection con=ConnectionFactory.getConnection();
        try {
            PreparedStatement s=con.prepareStatement("SELECT * from enrollments  where studentId=?");
            s.setInt(1,stude.getId());
            ResultSet rs=s.executeQuery();
            while(rs.next())
            {
                st=new Enrollment(rs.getInt(5),stud.getData(rs.getInt(1)),
                                            co.getData(rs.getInt(2)),null,
                                            rs.getInt(4));

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


    public void insert(String courseName,String studentName,LocalDate exam) {

        StudentDao stud=new StudentDao();
        CourseDao co=new CourseDao();
        Student st=stud.getDataName(studentName);
        Course c=co.getDataName(courseName);
        System.out.println(courseName+studentName);

        Connection con=ConnectionFactory.getConnection();
        try{
            PreparedStatement s=con.prepareStatement("INSERT into enrollments (studentId,courseId,grade,dateExam) VALUES(?,?,?,?)");
            s.setInt(1,st.getId());
            s.setInt(2,c.getId());
            s.setInt(3,0);
            s.setDate(4,Date.valueOf(exam));
            s.executeUpdate();
            s.close();
        }catch(SQLException e) {
            e.printStackTrace();
        }
        finally {
            ConnectionFactory.close(con);
        }

    }


    public void delete(String courseName,String nameStudent) {

        CourseDao co=new CourseDao();
        Course c=co.getDataName(courseName);
        StudentDao so=new StudentDao();
        Student st=so.getDataName(nameStudent);
        Connection con=ConnectionFactory.getConnection();
        try{
            PreparedStatement s=con.prepareStatement("Delete from enrollments where courseId=? and studentId=?");
            s.setInt(1,c.getId());
            s.setInt(2,st.getId());
            s.executeUpdate();
            ConnectionFactory.close(s);
        }catch(SQLException e) {
            e.printStackTrace();
        }
        finally {
            ConnectionFactory.close(con);
        }

    }


    public void update(Student s, Course c, LocalDate ex, int grade) {
        Connection con = ConnectionFactory.getConnection();
        try {


            PreparedStatement st = con.prepareStatement("UPDATE enrollments SET  studentId= ?, courseId=?,dateExam=?,grade=? WHERE studentId= ? and courseId=?");
            st.setInt(1, s.getId());
            st.setInt(2, c.getId());
            st.setDate(3,Date.valueOf(ex));
            st.setInt(4,grade);
            st.setInt(5,s.getId());
            st.setInt(6,c.getId());

            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.close(con);
        }

    }
    public void update(Enrollment eo) {
        Connection con = ConnectionFactory.getConnection();
        try {

            PreparedStatement st = con.prepareStatement("UPDATE enrollments SET  studentId= ?, courseId=?,dateExam=?,grade=? WHERE studentId= ? and courseId=?");
            st.setInt(1, eo.getStudent().getId());
            st.setInt(2, eo.getCourse().getId());
            st.setDate(3,Date.valueOf(eo.getExam()));
            st.setInt(4,eo.getGrade());
            st.setInt(5,eo.getStudent().getId());
            st.setInt(6,eo.getCourse().getId());

            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.close(con);
        }

    }


    public List<Enrollment> getAll(String studentName)
    {
        StudentDao stud=new StudentDao();
        CourseDao co=new CourseDao();
        Student student=stud.getDataName(studentName);

        List<Enrollment> enrollments=new ArrayList<Enrollment>();

        Connection con = ConnectionFactory.getConnection();
        try {
            PreparedStatement st=con.prepareStatement("SELECT studentId,courseId, dateExam ,grade,enrollmentId  from enrollments where studentId=?");
            st.setInt(1,student.getId());
            ResultSet rs=st.executeQuery();
            while(rs.next())
            {

                enrollments.add(new Enrollment(rs.getInt(5),stud.getData(rs.getInt(1)),
                                co.getData(rs.getInt(2)),rs.getDate(3).toLocalDate(),rs.getInt(4)));
            }

            ConnectionFactory.close(rs);
            ConnectionFactory.close(st);
        } catch (SQLException e) {
            e.getErrorCode();
            e.printStackTrace();
        } finally {
            ConnectionFactory.close(con);
        }

        return enrollments;
    }

    public List<Enrollment> getAll()
    {
        StudentDao stud=new StudentDao();
        CourseDao co=new CourseDao();

        List<Enrollment> enrollments=new ArrayList<Enrollment>();

        Connection con = ConnectionFactory.getConnection();
        try {
            Statement st=con.createStatement();
            st.execute("SELECT studentId,courseId,dateExam,grade,enrollmentId  from enrollments  ");
            ResultSet rs=st.getResultSet();
            while(rs.next())
            {
                //enrollments.add(new Enrollment(rs.getInt(5),stud.getData(rs.getInt(1)),co.getData(rs.getInt(2)),rs.getInt(4)));
                enrollments.add(new Enrollment(rs.getInt(5),stud.getData(rs.getInt(1)),co.getData(rs.getInt(2)),rs.getDate(3).toLocalDate(),rs.getInt(4)));
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
