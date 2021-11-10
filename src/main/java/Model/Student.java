package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class Student {
    
    private String name;
    private static long studentNumber;
    private static Set<Course> courseList;
    private String email;

    public Student(String name, long studentNumber, String email) {
        this.name = name;
        this.studentNumber = studentNumber;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public long getStudentNumber() {
        return studentNumber;
    }

    public static void getCourses() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:" + Databases.ENROLMENT);
            Statement s = connection.createStatement();
            String sql = "SELECT * FROM enrolled WHERE student = '" + studentNumber + "';";
            ResultSet result = s.executeQuery(sql);
            while (result.next()) {
                String courseNo = result.getString("courses");
                Connection c = DriverManager.getConnection("jdbc:sqlite:" + Databases.COURSES);
                Statement st = c.createStatement();
                String sql1 = "SELECT * FROM courses WHERE course_no = '" + courseNo + "';";
                ResultSet result1 = st.executeQuery(sql1);
                if (result1.next()) {
                    String description = result.getString("course_description");
                    String courseTitle = result.getString("course_title");
                    int maxCap = Integer.parseInt(result.getString("max_capacity"));
                    courseList.add(new Course(courseNo, courseTitle, description, maxCap));
                }
            }
        }
        catch (Exception e) {
            System.out.println("ID was not found or something occured in the accounts database");
            e.printStackTrace();
        }
    }

    public Set<Course> getCourseList() {
        Set<Course> courseList = new HashSet<>();
        for (Course c: this.courseList) {
            if (courseList.add(c)) {
                courseList.add(c);
                c.numberOfStudents++;
                c.numberOfAvailableSpots--;
            }
        }
        return courseList;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStudentNumber(long studentNumber) {
        this.studentNumber = studentNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCourseList(Set<Course> courseList) {
        this.courseList = new HashSet<>();
        for (Course c: courseList) {
            if (this.courseList.add(c)) {
                this.courseList.add(c);
                c.numberOfAvailableSpots--;
                c.numberOfStudents++;
            }
        }
    }

    /**
     * what should a student be able to do in a course management system? Add a course, drop a course, view courses, and their information on the GUI
     */

    public void addCourse(String courseID) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:" + Databases.COURSES);
            Statement s = connection.createStatement();
            String sql = "SELECT * FROM courses WHERE course_no = '" + courseID + "';";
            ResultSet result = s.executeQuery(sql);
            if (result.next()) {
                String courseNo = result.getString("course_no");
                String description = result.getString("course_description");
                String courseTitle = result.getString("course_title");
                int maxCap = Integer.parseInt(result.getString("max_capacity"));
                courseList.add(new Course(courseNo, courseTitle, description, maxCap));
            }
        }
        catch (Exception e) {
            System.out.println("ID was not found or something occured in the courses database");
            e.printStackTrace();
        }
    }

//     public void addCourse(Course course) {
//        if (this.courseList.contains(course)) {
//            System.out.println("You have already been enrolled in the course. Please try adding another course");
//        }
//        else if (course.numberOfAvailableSpots == 0) {
//            System.out.println("Im sorry, the course has been filled!");
//        }
//        else {
//            this.courseList.add(course);
//            course.numberOfAvailableSpots--;
//            course.numberOfStudents++;
//            course.setSituation(course.numberOfAvailableSpots == 0 ? "" + Situation.FULL : "" + Situation.AVAILABLE);
//        }
//    }

    public void dropCourse(Course course) {
        if (this.courseList.contains(course)) {
            this.courseList.remove(course);
            System.out.println("The course has been successfully dropped!");
            course.numberOfAvailableSpots++;
            course.numberOfStudents--;
            course.setSituation(course.numberOfAvailableSpots == 0 ? "" + Situation.FULL : "" + Situation.AVAILABLE);
        }
        else {
            System.out.println("You are not enrolled in the course, which is why you cannot drop it!");
        }
    }

    public static String viewCourses() {
        getCourses();
        String courses = "";
//        for (Course course: courseList) {
//            courses = course + "\n" + course.getCourseDescription() + "\n";
//        }
        return courses;
    }

    public String toString() {
        return name + ": " + studentNumber;
    }

}
