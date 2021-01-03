package lk.ijse.royal.dto;

public class RegistrationDTO {
    private Integer regNo;
    private String regDate;
    private double regFree;

    private String studentId;
    private String studentName;

    private String courseCode;
    private String courseName;

    public RegistrationDTO() {
    }

    public RegistrationDTO(Integer regNo, String regDate, double regFree, String studentId, String studentName, String courseCode, String courseName) {
        this.regNo = regNo;
        this.regDate = regDate;
        this.regFree = regFree;
        this.studentId = studentId;
        this.studentName = studentName;
        this.courseCode = courseCode;
        this.courseName = courseName;
    }

    //without Date
    public RegistrationDTO(Integer regNo, double regFree, String studentId, String studentName, String courseCode, String courseName) {
        this.regNo = regNo;
        this.regFree = regFree;
        this.studentId = studentId;
        this.studentName = studentName;
        this.courseCode = courseCode;
        this.courseName = courseName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
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

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    @Override
    public String toString() {
        return "RegistrationDTO{" +
                "regNo=" + regNo +
                ", regDate='" + regDate + '\'' +
                ", regFree=" + regFree +
                ", studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", courseCode='" + courseCode + '\'' +
                ", courseName='" + courseName + '\'' +
                '}';
    }
}
