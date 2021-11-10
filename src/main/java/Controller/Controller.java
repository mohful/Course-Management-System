package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;

import javafx.stage.*;
import javafx.scene.*;
import javafx.fxml.FXMLLoader;

public class Controller {

    static String user;

    @FXML
    TextArea username;

    @FXML
    PasswordField password;

    @FXML
    Button login;

    public void handleLoginButton(ActionEvent event) {
        String uName = username.getText();
        user = username.getText();
        String pWord = password.getText();
        boolean success = Model.Account.confirmLogin(uName, pWord);
        String id = Model.Account.getID(uName, pWord);
        if (success) {
            if (id.equals("student")) {
                try {
                    Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("Model/studentPage.fxml"));
                    Scene scene = new Scene(root, 935, 700);
                    //scene.getStylesheets().add(getClass().getClassLoader().getResource("Model/i.fxml").toExternalForm());
                    Stage primaryStage = new Stage();
                    primaryStage.setScene(scene);
                    primaryStage.show();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
            //call the next scene depending on the student or the professor
        }
        //otherwise alert the user that the account does not exist and they should email the administrator to speed up the process
    }

    
}
