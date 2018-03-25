package bll;

import dao.Enrollment;
import dao.EnrollmentDao;

import java.util.List;

public class EnrollmentService {


    public void createEnrollment(Enrollment e)
    {
        EnrollmentDao eo=new EnrollmentDao();
        eo.insert(e);
    }

    public void deleteEnrollment(Enrollment e)
    {
        EnrollmentDao eo=new EnrollmentDao();
        eo.delete(e);
    }

    public void updateEnrollment(Enrollment e)
    {
        EnrollmentDao eo=new EnrollmentDao();
        eo.update(e);
    }
    public List<Enrollment> getAllEnrollments()
    {
        EnrollmentDao eo=new EnrollmentDao();
        return eo.getAll();

    }

}
