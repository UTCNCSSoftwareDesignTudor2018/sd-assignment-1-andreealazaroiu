package bll;

import dao.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class EnrollmentService {


    public void createEnrollment(String courseName,String studentName)
    {
        EnrollmentDao eo=new EnrollmentDao();
        StudentDao so=new StudentDao();
        UserDao uo=new UserDao();
        Student st=so.getData(uo.getDataName(studentName).getUserId());
        eo.insert(courseName,st.getName(),LocalDate.of(2018,01,01));

    }

    public void deleteEnrollment(String courseName,String studentName)
    {
        EnrollmentDao eo=new EnrollmentDao();
        StudentDao so=new StudentDao();
        UserDao uo=new UserDao();
        Student st=so.getData(uo.getDataName(studentName).getUserId());
        eo.delete(courseName,st.getName());
    }

    public void updateEnrollment(String student,String curs,String exam)
    {
        EnrollmentDao eo=new EnrollmentDao();
        StudentDao st=new StudentDao();
        CourseDao co=new CourseDao();
        Student s=st.getDataName(student);
        Course c=co.getDataName(curs);
        Enrollment en=eo.getDataName(s);
        DateTimeFormatter formatter_1= DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate_1= LocalDate.parse(exam,formatter_1);
        eo.update(s,c,localDate_1,en.getGrade());


    }
    public String getCourses(String studentName){

        EnrollmentDao eo=new EnrollmentDao();
        StudentDao so=new StudentDao();
        UserDao uo=new UserDao();
        Student st=so.getData(uo.getDataName(studentName).getUserId());
        CourseDao co=new CourseDao();

        String courses="All Courses are:\n";
        List<Enrollment> has=new ArrayList<Enrollment>();

        has=eo.getAll(st.getName());
        List<Course> curses =new ArrayList<Course>();
        curses=co.getAll();
        for(Course c:curses)
        {
            courses+=c.getName()+"\n";
        }
        courses+="\nAnd you are enrolled to the following courses: \n";
        for(Enrollment e: has)
        {
            courses+=e.getCourse().getName()+"\n";
        }

        return courses;
    }

    public String getEnrollments(String s)
    {
        EnrollmentDao eo=new EnrollmentDao();
        List<Enrollment> enrolls=new ArrayList<Enrollment>();
        enrolls=eo.getAll(s);
        String sfi="";
        String nono="There are no current enrollments";
        for(Enrollment e:enrolls)
            sfi+=e.toString();

        if(sfi.equals(""))
            return nono;

            return sfi;
    }


}
