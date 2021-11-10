package Model;

import java.sql.*;

public class Account {
    
    private String password;
    private String email;

    public Account(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public static boolean confirmLogin(String email, String password) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:" + Databases.ACCOUNTS);
            Statement s = connection.createStatement();
            String sql = "SELECT email FROM account WHERE email = '" + email + "' AND password = '" + password + "';";
            ResultSet result = s.executeQuery(sql);

            if (result.next()) {
                return true;
            }
        }
        catch (Exception e) {
            System.out.println("Account does not exist! Please email the admin to register your account!");
            e.printStackTrace();
        }
        return false;
    }

    public static String getID(String username, String password) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:" + Databases.ACCOUNTS);
            Statement s = connection.createStatement();
            String sql = "SELECT id FROM account WHERE email = '" + username + "' AND password = '" + password + "';";
            ResultSet result = s.executeQuery(sql);
            if (result.next()) {
                return result.getString("id");
            }
        }
        catch (Exception e) {
            System.out.println("ID was not found or something occured in the accounts database");
            e.printStackTrace();
        }
        return "no";
    }

    public static String getName(String username) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:" + Databases.ACCOUNTS);
            Statement s = connection.createStatement();
            String sql = "SELECT email FROM account WHERE email = '" + username + "';";
            ResultSet result = s.executeQuery(sql);
            if (result.next()) {
                try {
                    Connection c = DriverManager.getConnection("jdbc:sqlite:" + Databases.STUDENT);
                    Statement st = c.createStatement();
                    String sql1 = "SELECT * FROM students WHERE email = '" + username + "';";
                    ResultSet result1 = st.executeQuery(sql1);
                    if (result1.next()) {
                        return result1.getString("first_name") + " " + result1.getString("last_name");
                    }
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        catch (Exception e) {
            System.out.println("ID was not found or something occured in the accounts database");
            e.printStackTrace();
        }
        return "no";
    }

    public static String getSID(String username) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:" + Databases.ACCOUNTS);
            Statement s = connection.createStatement();
            String sql = "SELECT email FROM account WHERE email = '" + username + "';";
            ResultSet result = s.executeQuery(sql);
            if (result.next()) {
                try {
                    Connection c = DriverManager.getConnection("jdbc:sqlite:" + Databases.STUDENT);
                    Statement st = c.createStatement();
                    String sql1 = "SELECT * FROM students WHERE email = '" + username + "';";
                    ResultSet result1 = st.executeQuery(sql1);
                    if (result1.next()) {
                        return result1.getString("student_no");
                    }
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        catch (Exception e) {
            System.out.println("ID was not found or something occured in the accounts database");
            e.printStackTrace();
        }
        return "no";
    }

    public static String getCourses(String username) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:" + Databases.ACCOUNTS);
            Statement s = connection.createStatement();
            String sql = "SELECT email FROM account WHERE email = '" + username + "';";
            ResultSet result = s.executeQuery(sql);
            if (result.next()) {
                try {
                    Connection c = DriverManager.getConnection("jdbc:sqlite:" + Databases.STUDENT);
                    Statement st = c.createStatement();
                    String sql1 = "SELECT * FROM students WHERE email = '" + username + "';";
                    ResultSet result1 = st.executeQuery(sql1);
                    if (result1.next()) {
                        return result1.getString("student_no");
                    }
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        catch (Exception e) {
            System.out.println("ID was not found or something occured in the accounts database");
            e.printStackTrace();
        }
        return "no";
    }


}
