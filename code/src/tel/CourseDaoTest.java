package tel;

import dao.Course;
import dao.CourseDao;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class CourseDaoTest {

    @Test
    public void getAllTest(){

        CourseDao c=new CourseDao();
        Course co=new Course(1,"Software Design",LocalDate.of(2022,02,20),LocalDate.of(2022,04,20));
        Course coco=c.getData(1);
        //System.out.println(co+"\n"+coco);

        //Course d=new Course("Fundamental Algorithms",new Date(2019,9,14),new Date(2020,2,15));
        assert(co.equals(coco));


    }
    @Test
    @Disabled
    public void insertTest() {

        CourseDao c=new CourseDao();
        LocalDate d1 = LocalDate.of(2022,04,19);
        LocalDate d2 = LocalDate.of(2022,8,21);
        c.insert(new Course(4,"Fundamental Algorithms",d1,d2));
        Course d=new Course(3,"Fundamental Algorithms",d1,d2);
        assert(d.equals(c.getData(3)));

    }

    @Test
    @Disabled
    public void updateTest() {

        CourseDao dao=new CourseDao();
        Course c1=dao.getData(2);
        LocalDate d1 = LocalDate.of(2025,4,19);
        LocalDate d2 = LocalDate.of(2025,8,21);
        Course c2=new Course(2,"Software Engineering",d1,d2);
        dao.update(c2);
        assert(!c1.equals(dao.getData(2)));


    }

    @Test
    @Disabled
    public void deleteTest() {

        CourseDao dao=new CourseDao();
        Course c=dao.getData(6);
        dao.delete(c);
        Course c2=null;
        assert(c2.equals(dao.getData(6)));
    }

    @Test
    public void findAllTest() {

        CourseDao dao=new CourseDao();
        List<Course > c=new ArrayList<Course>();
        Course c1=dao.getData(1);
        Course c2=dao.getData(2);
        Course c3=dao.getData(6);
        c.add(c1);
        c.add(c2);
        c.add(c3);
        assert(c.equals(dao.getAll()));

    }

}

