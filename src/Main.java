import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.DBHelper;

public class Main extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	public static Parent root;

	@Override
	public void start(Stage primaryStage) throws Exception {
		// test if the connection works
		DBHelper.connect();

		root = FXMLLoader.load(getClass().getResource("view/MainLayout.fxml"));
		primaryStage.setTitle("Kino EmpireXP");
		primaryStage.setScene(new Scene(root));
		primaryStage.setMaximized(true);
		primaryStage.show();
	}




}
