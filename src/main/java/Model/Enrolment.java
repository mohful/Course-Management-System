package Model;

public class Enrolment {

    private long studentID;
    private String courseID;

    public Enrolment (long studentID, String courseID) {
        this.studentID = studentID;
        this.courseID = courseID;
    }

    public String getCourseID() {
        return courseID;
    }

    public long getStudentID() {
        return studentID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public void setStudentID(long studentID) {
        this.studentID = studentID;
    }
    
}
