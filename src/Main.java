import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main extends Application{

	public static void main(String[] args)  {
		//launch(args);
		DBHelper d = new DBHelper();
		Movie mov = new Movie("dansktitel7", "orginaltitl", "genr", 1235, "descript", LocalDate.now(), 15, "dirct", 18, "versn");
		Show sho = new Show(mov, LocalDate.now(), 123, 1);
		Customer cust = new Customer("mail@mail", "Torben", "12345687", "password101");
		Sale sal = new Sale(sho, cust, 12, LocalDateTime.now(), "status");
//		d.insertMovie(mov);
//		d.insertShow(sho);
//		d.insertCustomer(cust);
		d.insertSale(sal);
	}

	public static Parent root;
	public static Stage primaryStage;

	@Override
	public void start(Stage primaryStage) throws Exception {
//		root = FXMLLoader.load(getClass().getResource("view/Login.fxml"));   // for debug purposes this is commented out but it should start from here
		root = FXMLLoader.load(getClass().getResource("view/MainLayout.fxml"));
		primaryStage.setTitle("Kino EmpireXP");
		Scene scene = new Scene(root);
		primaryStage.getIcons().add(new Image("images/Logo.png"));
		primaryStage.setScene(scene);
		primaryStage.setMaximized(true);
		primaryStage.show();
	}

}
