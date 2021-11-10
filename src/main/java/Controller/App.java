package Controller;

import javafx.application.Application;
import javafx.stage.*;
import javafx.scene.*;
import javafx.fxml.FXMLLoader;

public class App extends Application {

    WindowEvent window;
	public static Stage stage;

	@Override
	public void start(Stage primaryStage) throws Exception {
		stage = primaryStage;
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("Model/intro.fxml"));
		Scene scene = new Scene(root, 935, 700);
		//scene.getStylesheets().add(getClass().getClassLoader().getResource("Model/intro.fxml").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		App.launch(App.class, args);
	}
    
}
