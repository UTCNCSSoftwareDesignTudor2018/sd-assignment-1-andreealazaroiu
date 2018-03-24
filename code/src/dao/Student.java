package dao;

import java.util.Objects;

public class Student extends User {

    private int id;
    private String name;
    private int cardNumber;
    private int pnc;


    public Student(int id,int userId,String username,String password,String name,int cardNumber, int pnc) {

        super(userId,username,password);
        this.id=id;
        this.name=name;
        this.cardNumber = cardNumber;
        this.pnc=pnc;

    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPnc() {
        return pnc;
    }

    public void setPnc(int pnc) {
        this.pnc = pnc;
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
        Student student = (Student) o;
        return id == student.id;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cardNumber=" + cardNumber +
                ", pnc=" + pnc +
                '}';
    }
}
