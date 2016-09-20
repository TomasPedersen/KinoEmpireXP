import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class Controller {

    private Main main;
    private BorderPane rootBorderPane = (BorderPane) Main.root;

    /**
     * What happenes when the menu item Film Oversigt is clicked
     * We load the content from the file and set it as center of our root layout (BorderPane)
     */
    @FXML
    public void selectingFilmOversigt() {

        try {
            Parent filmOversigtNode = FXMLLoader.load(getClass().getResource("view/FilmOversigt.fxml"));
            rootBorderPane.setCenter(filmOversigtNode);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    /**
     * What happenes when the menu item Kontakt is clicked
     * We load the content from the file and set it as center of our root layout (BorderPane)
     */
    @FXML
    public void selectingKontakt() {
        try {
            Parent filmOversigtNode = FXMLLoader.load(getClass().getResource("view/Kontakt.fxml"));
            rootBorderPane.setCenter(filmOversigtNode);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}