import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebView;


import java.io.IOException;

public class Controller {

    /**
     * This is what happens when the user tries to log in
     * */
    @FXML
    public void logIn() {

        // http://stackoverflow.com/questions/34863425/javafx-scene-builder-how-switch-scene

              Parent loginRoot = Main.root;
        TextField username = (TextField) loginRoot.lookup("#login_username_field");
        PasswordField password = (PasswordField) loginRoot.lookup("#login_password_field");

        String usernameAsString = username.getText();
        String passwordAsString = password.getText();

        // todo make a check to see if the user exists in the database and create the user object
        // remember to sanitize the data

        try {

            Parent newRoot = FXMLLoader.load(getClass().getResource("view/MainLayout.fxml"));
            loginRoot.getScene().setRoot(newRoot);
            Main.root = newRoot;

        } catch (IOException e) {
            e.printStackTrace();
        }

    }




    /**
     * when the menu item Movie Oversigt is clicked
     * We load the content from the file and set it as center of our root layout (BorderPane)
     */
    @FXML
    public void selectingFilmOversigt() {

        try {
            Parent filmOversigtNode = FXMLLoader.load(getClass().getResource("view/FilmOversigt.fxml"));

            BorderPane rootBorderPane = (BorderPane) Main.root;
            rootBorderPane.setCenter(filmOversigtNode);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    @FXML
    public void selectingAdmin() {
        try {
            //Parent filmOversigtNode = FXMLLoader.load(getClass().getResource("Admin.fxml"));
            Parent filmOversigtNode = FXMLLoader.load(getClass().getResource("view/LilleSal.fxml"));
            BorderPane rootBorderPane = (BorderPane) Main.root;
            rootBorderPane.setCenter(filmOversigtNode);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    @FXML
    public void selectingStatistik() {
        try {
            Parent filmOversigtNode = FXMLLoader.load(getClass().getResource("view/Statistik.fxml"));
            BorderPane rootBorderPane = (BorderPane) Main.root;
            rootBorderPane.setCenter(filmOversigtNode);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    @FXML
    public void selectingKontakt() {
        try {
            Parent filmOversigtNode = FXMLLoader.load(getClass().getResource("view/Kontakt.fxml"));
            BorderPane rootBorderPane = (BorderPane) Main.root;
            rootBorderPane.setCenter(filmOversigtNode);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }





}