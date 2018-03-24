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
             s.execute("SELECT idStudents,users.id,username, password,nameStudent,cardNumber,pnc from students join users on (students.idStudents=users.id) where idStudents="+id);
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


     public void insert(Student  d) {
         UserDao u=new UserDao();
         u.insert(new User(d.getUserId(),d.getUsername(),d.getPassword()));
         Connection con=ConnectionFactory.getConnection();
         try{
             PreparedStatement s=con.prepareStatement("INSERT into students (nameStudent,cardNumber,pnc,id) VALUES(?,?,?,?)");
             s.setString(1,d.getName());
             s.setInt(2,d.getCardNumber());
             s.setInt(3,d.getPnc());
             s.setInt(4,d.getUserId());
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
         u.delete(new User(d.getUserId(),d.getUsername(),d.getPassword()));
         Connection con=ConnectionFactory.getConnection();
         try{
             Statement s=con.createStatement();
             s.execute("DELETE from  students where idStudents="+d.getId());
             ConnectionFactory.close(s);
         }catch(SQLException e) {
             e.printStackTrace();
         }
         finally {
             ConnectionFactory.close(con);
         }

     }


     public void update(Student d) {

         UserDao u=new UserDao();
         u.update(d);
         Connection con = ConnectionFactory.getConnection();
         try {

             PreparedStatement st = con.prepareStatement("UPDATE students SET  nameStudent = ?, cardNumber=?,pnc=? WHERE idStudents= ?");
             st.setString(1, d.getName());
             st.setInt(2, d.getCardNumber());
             st.setInt(3,d.getPnc());
             st.setInt(4,d.getId());
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
             st.execute("SELECT idStudents,id,username, password,nameStudent,cardNumber,pnc  from students join users on(students.idStudents=users.id) ");
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
