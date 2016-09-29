import controller.MovieProgram;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.DBHelper;
import model.Movie;
import model.Seat;
import view.Controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main extends Application{

	public static void main(String[] args) {
		launch(args);
	}


	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("view/Login.fxml"));

		Map<String, Object> session = new HashMap<String, Object>();
		session.put("root_loader", loader);
		Controller mainController = new Controller(session);
		loader.setController(mainController);
		BorderPane root = loader.load();



		primaryStage.setTitle("Kino EmpireXP");
		Scene scene = new Scene(root);
		primaryStage.getIcons().add(new Image("images/Logo.png"));
		primaryStage.setScene(scene);
		primaryStage.setMaximized(true);
		primaryStage.show();
	}

}
