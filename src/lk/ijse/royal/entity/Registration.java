package lk.ijse.royal.entity;

import javax.persistence.*;

@Entity
@Table(
        name="Registration",
        uniqueConstraints=
        @UniqueConstraint(columnNames={"studentID", "courseID"})
)
public class Registration {
    @Id
    private Integer regNo;
    private String regDate;
    private double regFree;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "studentID" , referencedColumnName = "id")
    private Student student;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "courseID" , referencedColumnName = "code")
    private Course course;

    public Registration() {
    }

    public Registration(Integer regNo, String regDate, double regFree, Student student, Course course) {
        this.regNo = regNo;
        this.regDate = regDate;
        this.regFree = regFree;
        this.student = student;
        this.course = course;
    }

    public Integer getRegNo() {
        return regNo;
    }

    public void setRegNo(Integer regNo) {
        this.regNo = regNo;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public double getRegFree() {
        return regFree;
    }

    public void setRegFree(double regFree) {
        this.regFree = regFree;
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

    @Override
    public String toString() {
        return "Registration{" +
                "regNo=" + regNo +
                ", regDate='" + regDate + '\'' +
                ", regFree=" + regFree +
                ", student=" + student +
                ", course=" + course +
                '}';
    }
}
