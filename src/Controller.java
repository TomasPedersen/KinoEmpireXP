import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;


import java.io.IOException;

public class Controller{



    /**
     * What happens when the menu item Film Oversigt is clicked
     * We load the content from the file and set it as center of our root layout (BorderPane)
     */
    @FXML
    public void selectingFilmOversigt() {

        try {
            Parent filmOversigtNode = FXMLLoader.load(getClass().getResource("LilleSal.fxml"));
            //Parent filmOversigtNode = FXMLLoader.load(getClass().getResource("FilmOversigt.fxml"));


              BorderPane rootBorderPane = (BorderPane) Main.root;
            rootBorderPane.setCenter(filmOversigtNode);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    /**
     * What happens when the menu item Kontakt is clicked
     * We load the content from the file and set it as center of our root layout (BorderPane)
     */
    @FXML
    public void selectingKontakt() {
        try {
            Parent filmOversigtNode = FXMLLoader.load(getClass().getResource("Kontakt.fxml"));
/*            BorderPane rootBorderPane = (BorderPane) Main.root;
            rootBorderPane.setCenter(filmOversigtNode);*/
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    public void thisIsTheMethod() {
        System.out.println("hello");

    }



}