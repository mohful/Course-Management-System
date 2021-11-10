package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

    public static void main (String[] args) {
        String jdbcUrl = "jdbc:sqlite:/Users/mohammedfulwala/Documents/Stratus360 Case Study/universityenrolment/src/main/java/Model/courses.db";
        try {    
            Connection connection = DriverManager.getConnection(jdbcUrl); 

            String sql = "SELECT * from courses";
            Statement statement = connection.createStatement();
            String sql1 = "INSERT INTO courses (course_no, course_title, max_capacity) VALUES ('CS-104', 'Introduction To Computer Science 4', 6);";
            statement.executeUpdate(sql1);
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                String firstName = result.getString("course_no");
                String lastName = result.getString("course_title");
                System.out.println(firstName + "|" + lastName);
            }
        }
        catch (Exception e) {
            System.out.println("Error connecting to the database");
            e.printStackTrace();
        }
    }
    
}
