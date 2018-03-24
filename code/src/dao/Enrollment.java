package dao;

import java.util.List;
import java.util.Objects;

public class Enrollment {

    private int enrollId;
    private int grade;
    private Student student;
    private Course course;
    private Exam exam;

    public Enrollment(int enrollId, Student student, Course course, Exam exam,int grade) {
        this.enrollId=enrollId;
        this.grade = grade;
        this.student = student;
        this.course = course;
        this.exam = exam;
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

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
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
        return "Enrollment{" +
                "enrollId=" + enrollId +
                ", grade=" + grade +
                ", student=" + student +
                ", course=" + course +
                ", exam=" + exam +
                '}';
    }
}
