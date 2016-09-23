import controller.FilmNodesToFilmOversigt;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import model.DBHelper;

import java.time.LocalDate;

public class FilmOversigtController {

    @FXML
    public void getDateFromFilmOversigt(){
        BorderPane root = (BorderPane) Main.root;
        DatePicker datePicker = (DatePicker) root.lookup("#filmoversigt_date");

    }

    public void addMoviesToTheGridpane(LocalDate date) {

        FilmNodesToFilmOversigt filmNodes = new FilmNodesToFilmOversigt();
        BorderPane root = (BorderPane) Main.root;
        GridPane gridPane = (GridPane) root.lookup("#filmoversigt_gridpane");  // please change the ID accordingly
        gridPane.getStyleClass().add("grid");
        gridPane = filmNodes.gridPaneOfFilmNodes(date);


        FilmNodesToFilmOversigt.createListOfFilmNodes(date);
    }


}
