package Model;

import java.util.*;
import java.sql.*;

public class Administrator {

    private String email;
    private Set<Student> studentList;
    private Set<Course> courseList;    
    private static final Administrator admin = new Administrator();

    private Administrator() {}

    public Administrator getInstance() {
        return admin;
    }

    public String getEmail() {
        return email;
    }

    public Set<Student> getStudentList() {
        Set<Student> studentList = new HashSet<>();
        for (Student s : this.studentList) {
            studentList.add(s);
        }
        return studentList;
    }

    public Set<Course> getCourseList() {
        Set<Course> courseList = new HashSet<>();
        for (Course s : this.courseList) {
            courseList.add(s);
        }
        return courseList;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setStudentList(Set<Student> studentList) {
        for (Student s : studentList) {
            this.studentList.add(s);
        }
    }

    public void setCourseList(Set<Course> courseList) {
        for (Course s : courseList) {
            this.courseList.add(s);
        }
    }
    
    public void fillStudentsList() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:sql:" + Databases.STUDENT);
            Statement s = connection.createStatement();
            String sql = "SELECT * from students";
            ResultSet result = s.executeQuery(sql);

            while (result.next()) {
                String name = result.getString("first_name") + " " + result.getString("last_name");
                Student student = new Student(name, Long.parseLong(result.getString("student_no")), result.getString("email"));
                studentList.add(student);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void fillCoursesList() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:sql:" + Databases.COURSES);
            Statement s = connection.createStatement();
            String sql = "SELECT * from courses";
            ResultSet result = s.executeQuery(sql);

            while (result.next()) {
                Course course = new Course(result.getString("course_no"), result.getString("course_title"), "This is a course", Long.parseLong(result.getString("max_capacity")));
                courseList.add(course);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean register(String email, String password, String id) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:" + Databases.ACCOUNTS);
            Statement s = connection.createStatement();
            String sqlCheck = "SELECT email FROM account WHERE email = " + email + " AND password = " + password + " AND id = " + id;
            ResultSet result = s.executeQuery(sqlCheck);

            if (result.next()) {
                throw new Exception();
            }

            String sql = "INSERT INTO account(email, password, id) VALUES ('" + email + "', '" + password + "', '" + id + "');";
            s.executeUpdate(sql);
            return true;
        }
        catch (Exception e) {
            System.out.println("Your account exists, or there is an error with registration");
        }
        return false;
    }

    public void addCourse(Course course, Student student) {
        if (student.getCourseList().contains(course)) {
            System.out.println("The student has already been enrolled in the course");
        }

        else if (course.numberOfAvailableSpots == 0) {
            System.out.println("Im sorry, the course has been filled!");
        }
        else {
            this.courseList.add(course);
            course.numberOfAvailableSpots--;
            course.numberOfStudents++;
            course.setSituation(course.numberOfAvailableSpots == 0 ? "" + Situation.FULL : "" + Situation.AVAILABLE);
        }
    }

    public void dropCourse(Course course) {
        if (this.courseList.contains(course)) {
            this.courseList.remove(course);
            System.out.println("The course has been successfully dropped!");
            course.numberOfAvailableSpots++;
            course.numberOfStudents--;
            course.setSituation(course.numberOfAvailableSpots == 0 ? "" + Situation.FULL : "" + Situation.AVAILABLE);
        }
        else {
            System.out.println("The student is not enrolled in the course");
        }
    }

    public void viewCourses() {
        for (Course c:courseList) {
            System.out.println(c + " - " + c.getSituation() + "\n" + c.getCourseDescription());
        }
    }

}
