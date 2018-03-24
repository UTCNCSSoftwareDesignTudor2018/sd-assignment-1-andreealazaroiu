package tel;

import dao.Course;
import dao.CourseDao;
import dao.Exam;
import dao.ExamDao;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ExamDaoTest {


    @Test
    @Disabled
    public void getAllTest(){

        ExamDao dao=new ExamDao();
        Exam e=new Exam(1,LocalDate.of(2022,02,18));
        Exam e2=dao.getData(1);
        assert(e.equals(e2));


    }
    @Test
    @Disabled
    public void insertTest() {

        ExamDao dao=new ExamDao();
        LocalDate d1 = LocalDate.of(2022,05,12);
        dao.insert(new Exam(3,d1));
        Exam d=new Exam(3,d1);
        assert(d.equals(dao.getData(3)));

    }

    @Test
    @Disabled
    public void updateTest() {

        ExamDao dao=new ExamDao();
        Exam e1=dao.getData(2);
        Exam e2=new Exam(2,LocalDate.of(2021,06,14));
        dao.update(e2);
        assert(!e1.equals(dao.getData(2)));


    }

    @Test
    @Disabled
    public void deleteTest() {

        ExamDao dao = new ExamDao();

        Exam e = dao.getData(2);
        dao.delete(e);
        Exam e2 = null;
        assert (e2.equals(dao.getData(2)));

    }

    @Test
    @Disabled
    public void findAllTest() {

        ExamDao dao=new ExamDao();
        List<Exam > e=new ArrayList<Exam>();
        Exam c1=dao.getData(1);
        Exam c2=dao.getData(3);
        e.add(c1);
        e.add(c2);
        assert(e.equals(dao.getAll()));

    }





}
