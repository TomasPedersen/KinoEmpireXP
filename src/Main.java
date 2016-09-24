import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application{

	public static void main(String[] args) {
		launch(args);

	}

	public static Parent root;
	public static Stage primaryStage;

	@Override
	public void start(Stage primaryStage) throws Exception {
//		root = FXMLLoader.load(getClass().getResource("view/Login.fxml"));   // for debug purposes this is commented out but it should start from here
		root = FXMLLoader.load(getClass().getResource("view/MainLayout.fxml"));
		Pane center = FXMLLoader.load(getClass().getResource("view/MovieDescription.fxml"));
		BorderPane borderPane = (BorderPane) root;
		borderPane.setCenter(center);

		primaryStage.setTitle("Kino EmpireXP");
		Scene scene = new Scene(root);
		primaryStage.getIcons().add(new Image("images/Logo.png"));
		primaryStage.setScene(scene);
		primaryStage.setMaximized(true);
		primaryStage.show();
	}

}
