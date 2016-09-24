import controller.FilmNodesToFilmOversigt;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import model.DBHelper;

import java.io.IOException;
import java.time.LocalDate;

public class FilmOversigtController {

    @FXML
    public void getDateFromFilmOversigt(){
        BorderPane root = (BorderPane) Main.root;
        DatePicker date = (DatePicker) root.lookup("#filmoversigt_date");
        addMoviesToTheGridpane(date.getValue());

    }

    public void addMoviesToTheGridpane(LocalDate date) {

        FilmNodesToFilmOversigt filmNodes = new FilmNodesToFilmOversigt();
        BorderPane root = (BorderPane) Main.root;

        GridPane gridPane = (GridPane) root.lookup("#filmoversigt_gridpane");  // please change the ID accordingly
        filmNodes.gridPaneOfFilmNodes(date, gridPane);

    }





}
