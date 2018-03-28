package dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Enrollment {

    private int enrollId;
    private int grade;
    private Student student;
    private Course course;
    private LocalDate exam;

    public Enrollment(int enrollId, Student student, Course course, LocalDate exam,int grade) {
        this.enrollId=enrollId;
        this.grade = grade;
        this.student = student;
        this.course = course;
        this.exam = exam;
    }

    public Enrollment(int enrollId, Student student, Course course,int grade) {
        this.enrollId=enrollId;
        this.grade = grade;
        this.student = student;
        this.course = course;
        this.exam = null;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public LocalDate getExam() {
        return exam;
    }

    public void setExam(LocalDate exam) {
        this.exam = exam;
    }

    public int getEnrollId() {
        return enrollId;
    }

    public void setEnrollId(int enrollId) {
        this.enrollId = enrollId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Enrollment that = (Enrollment) o;
        return enrollId == that.enrollId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(enrollId);
    }

    @Override
    public String toString() {
        String exe="";
        if (exam==null)
        {exe="Date not set yet";}
        else
            exe+=""+exam;

        return "Enrollment:" +
                "enrollment id =" + enrollId +
                ", grade for exam =" + grade +
                ", student name=" + student.getName() +
                ", course name=" + course.getName() +
                ", exam date =" + exe +
                "\n";
    }
}
