package tel;


import dao.Student;
import dao.StudentDao;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class StudentDaoTest {


    @Test
    public void getAllTest() {

        StudentDao dao = new StudentDao();
        Student s = new Student(1,1 ,"sebastianLungu", "mypassw", "Sebastian Lungu", 21013, 1970514);
        Student st = dao.getData(1);
        assert (s.equals(st));


    }

    @Test
    @Disabled
    public void insertTest() {

        StudentDao dao=new StudentDao();

        Student s=new Student(3,3,"florinaGatu","flori2000","Florina Gatu",21123,2960813);
        dao.insert(s);
        Student d=dao.getData(s.getId());
        assert(s.equals(d));

    }

    @Test
    @Disabled
    public void updateTest() {

       StudentDao dao=new StudentDao();
        Student c1=dao.getData(2);
        Student c2=new Student(4,3,"floriGatu","easypassw","Florina Gatu",21145,2960812);
        dao.update(c2);
        assert(!c1.equals(dao.getData(3)));


    }


    @Test
    @Disabled
    public void deleteTest() {

        StudentDao dao=new StudentDao();

        Student s=new Student(4,3,"florinaGatu","flori2000","Florina Gatu",21123,2960813);
        int id=s.getId();
        Student c=dao.getData(id);
        dao.delete(s);
        Student c2=null;
        assert(c2.equals(dao.getData(id)));
    }

    @Test
    public void findAllTest() {

        StudentDao dao=new StudentDao();
        List<Student > c=new ArrayList<Student>();
        Student c1=dao.getData(1);
        Student c2=dao.getData(2);
        //Student c3=dao.getData(6);
        c.add(c1);
        c.add(c2);
        //c.add(c3);
        assert(c.equals(dao.getAll()));

    }


}
