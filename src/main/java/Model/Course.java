package Model;

public class Course {

    private String courseNumber;
    private String description;
    private String name;
    private String situation;
    public long maximumCapacity;
    public int numberOfStudents;
    public int numberOfAvailableSpots;

    //need a visual indicator if the course is full or not in the GUI

    public Course(String courseNumber, String name, String description, long maximumCapacity) {
        this.courseNumber = courseNumber;
        this.name = name;
        this.description = description;
        this.maximumCapacity = maximumCapacity;
        //this.situation = situation;
    }

    public String getCourseDescription() {
        return description;
    }
    public String getSituation() {
        return situation;
    }

    public String getName() {
        return name;
    }

    public String getCourseNumber() {
        return courseNumber;
    }
    
    public long getMaximumCapacity() {
        return maximumCapacity;
    }

    public int getNumberOfAvailableSpots() {
        return numberOfAvailableSpots;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setCourseDescription(String courseDescription) {
        this.description = courseDescription;
    }

    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }

    public void setMaximumCapacity(long maximumCapacity) {
        this.maximumCapacity = maximumCapacity;
    }

    public void setNumberOfAvailableSpots(int numberOfAvailableSpots) {
        this.numberOfAvailableSpots = numberOfAvailableSpots;
    }

    public void setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }    

    public void setName(String name) {
        this.name = name;
    }

    public void setSituation(String situation) {
        this.situation = situation;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String toString() {
        return courseNumber + ": " + name;
    }
}
