package Model;

import java.util.*;

public class Professor {

    private String name;
    private String email;
    private Set<Course> courseList;

    public Professor (String name, String email) {
        this.name = name;
        this.email = email;
        courseList = new HashSet<>();
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public List<Course> getCourseList() {
        List<Course> courseList = new ArrayList<>();
        for (Course c: this.courseList) {
            courseList.add(c);
        }
        return courseList;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCourseList(Set<Course> courseList) {
        this.courseList = new HashSet<>();
        for (Course c: courseList) {
            this.courseList.add(c);
        }
    }

    /**
     * What should the professor be able to do? View courses he is teaching, view students he is teaching
     */

    public void viewCourses() {
        for (Course course: this.courseList) {
            System.out.println(course.getCourseNumber() + "\t" + course.getName() + "\n" + course.getCourseDescription());
        }
    }

    //view students he is teaching - BONUS

   
}
