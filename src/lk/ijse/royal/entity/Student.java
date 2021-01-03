package lk.ijse.royal.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Student {
    @Id
    private String id;
    private String studentName;
    private String address;
    private String contact;
    private String dob;
    private String gender;

    @OneToMany(mappedBy = "student",orphanRemoval = true, cascade = CascadeType.PERSIST)
    private List<Registration> studentRegistration=new ArrayList<>();

    public Student() {
    }

    public Student(String id, String studentName, String address, String contact, String dob, String gender) {
        this.id = id;
        this.studentName = studentName;
        this.address = address;
        this.contact = contact;
        this.dob = dob;
        this.gender = gender;
        this.studentRegistration = studentRegistration;
    }

    public List<Registration> getStudentRegistration() {
        return studentRegistration;
    }

    public void setStudentRegistration(List<Registration> studentRegistration) {
        this.studentRegistration = studentRegistration;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", studentName='" + studentName + '\'' +
                ", address='" + address + '\'' +
                ", contact='" + contact + '\'' +
                ", dob=" + dob +
                ", gender='" + gender + '\'' +
                '}';
    }
}
