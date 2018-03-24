package dao;

import java.time.LocalDate;
import java.util.Objects;

public class Exam {

  private int id;
  private LocalDate dateExam;

    public Exam(int id,LocalDate dateExam) {

        this.id=id;
        this.dateExam = dateExam;
    }

    public LocalDate getDateExam() {
        return dateExam;
    }

    public void setDateExam(LocalDate dateExam) {
        this.dateExam = dateExam;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exam exam = (Exam) o;
        return id == exam.id;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Exam{" +
                "id=" + id +
                ", dateExam=" + dateExam +
                '}';
    }
}
