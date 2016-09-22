import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.*;

import java.time.LocalDate;

public class Main extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	public static Parent root;

	@Override
	public void start(Stage primaryStage) throws Exception {
		root = FXMLLoader.load(getClass().getResource("MainLayout.fxml"));
		primaryStage.setTitle("Kino EmpireXP");
		Scene scene = new Scene(root);
		primaryStage.getIcons().add(new Image("images/Logo.png"));
		primaryStage.setScene(scene);
		primaryStage.setMaximized(true);
		primaryStage.show();
	}

}
