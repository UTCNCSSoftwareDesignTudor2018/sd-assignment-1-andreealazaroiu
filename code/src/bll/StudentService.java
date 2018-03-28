package bll;

import dao.*;

import java.util.ArrayList;
import java.util.List;

public class StudentService {


    public void createProfile(Student s)
    {
        StudentDao so=new StudentDao();
        so.insert(s);
    }

    public void updateProfile(String us, String pass, String na,String ca,String pnc)
    {
        Student s=new Student(us,pass,na,Integer.parseInt(ca),Integer.parseInt(pnc));
        StudentDao so=new StudentDao();
        so.update(s);
    }


    public String viewProfile(String s)
    {
        StudentDao so=new StudentDao();
        UserDao uo=new UserDao();
        User u=uo.getDataName(s);
        Student stud=so.getData(u.getUserId());
        return stud.toString();
    }

    public int getIdForNew()
    {
        StudentDao so=new StudentDao();
        return so.getAll().size();
    }
    public Student createStudent(String student)
    {
        StudentDao so=new StudentDao();
        return so.getDataName(student);
    }

    public String generateEnrollments(String st)
    {
        EnrollmentService eo=new EnrollmentService();
        StudentDao so=new StudentDao();
        UserDao uo=new UserDao();
        Student s=so.getData(uo.getDataName(st).getUserId());

        return eo.getEnrollments(s.getName());

    }
    public User getUserObj(String username)
    {
        UserDao uo=new UserDao();
        return uo.getDataName(username);
    }

    public Student getStudentObj(User u)
    {
        StudentDao so=new StudentDao();
        return so.getData(u.getUserId());
    }

}
