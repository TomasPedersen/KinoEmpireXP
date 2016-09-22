import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

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
		/*scene.getStylesheets().setAll(getClass().getResource("stylesheet.css").toExternalForm());*/
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
