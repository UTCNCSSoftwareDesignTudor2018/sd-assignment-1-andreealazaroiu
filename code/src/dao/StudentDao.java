package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

  public class StudentDao  {

     public Student getData(int id) {
         Student st=null;
         Connection con=ConnectionFactory.getConnection();
         try {
             Statement s=con.createStatement();
             s.execute("SELECT idStudents,users.id,username, password,nameStudent,cardNumber,pnc from students join users on (students.idStudents=users.id) where users.id="+id);
             ResultSet rs=s.getResultSet();
             while(rs.next())
             {
                 st=new Student(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getInt(7));

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

     public Student getDataName(String studentName)
     {
         Student st=null;
         Connection con=ConnectionFactory.getConnection();

         try {
             PreparedStatement s=con.prepareStatement("SELECT idStudents,users.id,username, password,nameStudent,cardNumber,pnc from students join users on (students.idStudents=users.id) where nameStudent=?");
             s.setString(1,studentName);
             ResultSet rs=s.executeQuery();
             while(rs.next())
             {
                 st=new Student(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getInt(7));

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


     public void insert(Student  d) {
         UserDao u=new UserDao();
         u.insert(new User(d.getUsername(),d.getPassword()));
         int id=u.getDataName(d.getUsername()).getUserId();
         Connection con=ConnectionFactory.getConnection();
         try{
             PreparedStatement s=con.prepareStatement("INSERT into students (nameStudent,cardNumber,pnc,id) VALUES(?,?,?,?)");
             s.setString(1,d.getName());
             s.setInt(2,d.getCardNumber());
             s.setInt(3,d.getPnc());
             s.setInt(4,id);
             s.executeUpdate();
             s.close();
         }catch(SQLException e) {
             e.printStackTrace();
         }
         finally {
             ConnectionFactory.close(con);
         }

     }

     public void delete(Student d) {

         UserDao u=new UserDao();
         System.out.println(d.toString());
         User us=new User(d.getUserId(),d.getUsername(),d.getPassword());

         Connection con=ConnectionFactory.getConnection();
         try{
             PreparedStatement s=con.prepareStatement("DELETE from  students where nameStudent=?");
             s.setString(1,d.getName());
             s.executeUpdate();
             ConnectionFactory.close(s);
         }catch(SQLException e) {
             e.printStackTrace();
         }
         finally {
             ConnectionFactory.close(con);
             u.delete(us);
         }
         //

     }


     public void update(Student d) {

         UserDao u=new UserDao();
         u.update(d);
         Connection con = ConnectionFactory.getConnection();
         try {

             PreparedStatement st = con.prepareStatement("UPDATE students SET  nameStudent = ?, cardNumber=?,pnc=? WHERE nameStudent= ?");
             st.setString(1, d.getName());
             st.setInt(2, d.getCardNumber());
             st.setInt(3,d.getPnc());
             st.setString(4,d.getName());
             st.executeUpdate();
             st.close();
         } catch (SQLException e) {
             e.printStackTrace();
         } finally {
             ConnectionFactory.close(con);
         }

     }

     public List<Student> getAll()
     {

         List<Student> students=new ArrayList<Student>();

         Connection con = ConnectionFactory.getConnection();
         try {
             Statement st=con.createStatement();
             st.execute("SELECT idStudents,users.id,username, password,nameStudent,cardNumber,pnc  from students join users on(students.idStudents=users.id) ");
             ResultSet rs=st.getResultSet();
             while(rs.next())
             {

                 students.add(new Student(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getInt(7)));
             }

             ConnectionFactory.close(rs);
             ConnectionFactory.close(st);
         } catch (SQLException e) {
             e.printStackTrace();
         } finally {
             ConnectionFactory.close(con);
         }

         return students;

     }


 }
