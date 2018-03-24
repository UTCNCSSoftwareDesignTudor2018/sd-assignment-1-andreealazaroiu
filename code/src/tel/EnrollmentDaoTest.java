package tel;

import dao.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EnrollmentDaoTest {

    @Test
    @Disabled
    public void getAllTest(){


        EnrollmentDao eo=new EnrollmentDao();

        Student s=new Student(1,1,"sebastianLungu","mypassw", "Sebastian Lungu",21013,1970514);
        Course c=new Course(1,"SoftWare Design",LocalDate.of(2022,02,20),LocalDate.of(2022,04,20));
        Exam e=new Exam(1,LocalDate.of(2022,02,19));
        Enrollment st = eo.getData(1);
        Enrollment en=new Enrollment(1,s,c,e,8);

        assert (e.equals(eo.getData(1)));


    }
    @Test
    @Disabled
    public void insertTest(){


        EnrollmentDao eo=new EnrollmentDao();



        Student s=new Student(1,1,"sebastianLungu","mypassw", "Sebastian Lungu",21013,1970514);
        Course c=new Course(2,"Software Engineering",LocalDate.of(2025,04,19),LocalDate.of(2025,8,21));
        Exam e=new Exam(1,LocalDate.of(2022,02,19));
        Enrollment st = eo.getData(1);
        Enrollment en=new Enrollment(2,s,c,e,9);

        eo.insert(en);
        Enrollment enn=eo.getData(2);

        assert(s.equals(enn));





    }

    @Test
    @Disabled
    public void updateTest(){

        EnrollmentDao eo=new EnrollmentDao();

        Student s=new Student(1,1,"sebastianLungu","mypassw", "Sebastian Lungu",21013,1970514);
        Course c=new Course(2,"Software Engineering",LocalDate.of(2025,04,19),LocalDate.of(2025,8,21));
        Exam e=new Exam(1,LocalDate.of(2022,02,19));
        Enrollment en=new Enrollment(2,s,c,e,10);


        eo.update(en);
        assert(!en.equals(eo.getData(2)));

    }

    @Test
    @Disabled
    public void deleteTest() {

        EnrollmentDao eo=new EnrollmentDao();

        Enrollment e = eo.getData(1);
        eo.delete(e);
        Enrollment e2 = null;
        assert (e2.equals(eo.getData(1)));


    }

    @Test
    @Disabled
    public void findAll()
    {
        EnrollmentDao eo=new EnrollmentDao();
        Enrollment e1=eo.getData(1);
        Enrollment e2=eo.getData(2);
        List<Enrollment> enrolls=new ArrayList<Enrollment>();
        enrolls.add(e1);
        enrolls.add(e2);
        assert (enrolls.equals(eo.getAll()));

    }

}
