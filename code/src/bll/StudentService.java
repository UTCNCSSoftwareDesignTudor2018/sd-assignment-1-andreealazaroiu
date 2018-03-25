package bll;

import dao.Student;
import dao.StudentDao;

public class StudentService {


    public void createProfile(Student s)
    {
        StudentDao so=new StudentDao();
        so.insert(s);
    }

    public void updateProfile(Student s)
    {
        StudentDao so=new StudentDao();
        Student aux=so.getDataName(s.getName());
        so.update(aux);
    }

    public void deleteProfile(Student s)
    {
        StudentDao so=new StudentDao();
        so.delete(s);

    }

    public String viewProfile(Student s)
    {
        StudentDao so=new StudentDao();
        Student aux=so.getDataName(s.getName());
        return aux.toString();
    }

    public int getIdForNew()
    {
        StudentDao so=new StudentDao();
        return so.getAll().size();
    }

}
