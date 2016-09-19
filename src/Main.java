import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		BorderPane root = new BorderPane();
		Scene scene = new Scene(root);

		ToggleButton toggleButton = new ToggleButton();
		root.setCenter(toggleButton);

		primaryStage.setMaximized(true);
		scene.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
		primaryStage.setTitle("Kino EmpireXP");
		primaryStage.setScene(scene);
		primaryStage.show();
	}


}
