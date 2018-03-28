package bll;

import dao.*;

import java.util.ArrayList;
import java.util.List;

public class AdminService {


    public String generateReport(String student)
    {
        EnrollmentDao eo=new EnrollmentDao();
        CourseDao co=new CourseDao();
        String st ="The student "+student+" is enrolled in ";
        List<Enrollment> enrolls=new ArrayList<Enrollment>();
        List<Course> courses=new ArrayList<Course>();
        int passedExams=0;
        int failedExams=0;
        int notTakenExams=0;
       // System.out.println(student);
        enrolls=eo.getAll(student);
        System.out.println(enrolls.toString());
        for(Enrollment e:enrolls)
        {
            courses.add(co.getDataName(e.getCourse().getName()));
            if(e.getGrade()>5)
                passedExams++;
            else if(e.getGrade()<5 && e.getGrade() !=0)
            {
                failedExams++;
            }
            else
                notTakenExams++;

        }
        String studCourses="";
        for(Course c:courses)
        studCourses+=c.getName()+", ";
        st +=courses.size()+"courses, which are:"+studCourses+" and has passed "+passedExams+", failed "+failedExams+" and not taken exams "+notTakenExams;

        return st;
    }
    public String generateAllStudents()
    {
        StudentDao so=new StudentDao();
        String str="All the registered students are: \n";
        List<Student> students=so.getAll();
        for(Student s:students)
        str+=s.getName()+"\n";
        return str;
    }
    public String viewStudent(String st)
    {
      EnrollmentService eo=new EnrollmentService();
      return eo.getEnrollments(st);

    }

    public String generateAllCourses()
    {
        String str="\nAll courses are :\n";
        CourseDao co=new CourseDao();
        List<Course> courses=new ArrayList<Course>();
        courses=co.getAll();
        for(Course c:courses)
            str+=c.getName()+"\n";
        return str;
    }

    public String generateExamDates()
    {
        return "";
    }

    public void grade(String student,String Course,int grade)
    {
        EnrollmentDao eo=new EnrollmentDao();

    }

    public void deleteStudent(String st)
    {
        StudentDao so=new StudentDao();
        Student s=so.getDataName(st);
        so.delete(s);
    }
    public void addExamdate(String s,String c,String e)
    {
        StudentService us=new StudentService();
        String si=us.createStudent(s).getName();
        EnrollmentService es=new EnrollmentService();
        es.updateEnrollment(si,c,e);
    }

}
