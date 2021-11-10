package Controller;

import Model.Account;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;

import java.net.URL;
import java.util.ResourceBundle;

public class StudentPageController implements Initializable {

    @FXML
    Label name, studentID, email, courses;

    @FXML
    TabPane studentCourses;

    @FXML
    Button addCourse, dropCourse;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        name.setText(Account.getName(Controller.user));
        studentID.setText(Account.getSID(Controller.user));
        email.setText(Controller.user);
        courses.setText(Model.Student.viewCourses());
    }

    public void handleAddCourseButton(ActionEvent event) {
        //Only Admin and Student are allowed to add courses
    }

    public void handleDropCourseButton(ActionEvent Event) {
        //Only Admin and student are allowed to drop courses
    }

    public void changeName(String name) {
        //Only Admin
        this.name.setText(name);
    }

    public void changeStudentID(String id) {
        //Only Admin
        this.studentID.setText(id);
    }

    public void changeEmail(String email) {
        //Only Admin
        this.email.setText(email);
    }

}
