package bll;

import dao.EnrollmentDao;
import dao.Student;

public class AdminService {


    public String generateReport(Student s)
    {
        EnrollmentDao eo=new EnrollmentDao();
        String st = eo.getDataName(s).toString();
        return st;
    }


}
