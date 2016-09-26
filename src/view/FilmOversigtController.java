package view;

import controller.FilmNodesToFilmOversigt;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.web.WebView;
import model.DBHelper;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Map;

public class FilmOversigtController {

    private Map<String, Object> session;

    public FilmOversigtController(Map<String, Object> session) {
        this.session = session;
    }

    @FXML
    public void getDateFromFilmOversigt(){

        BorderPane root = (BorderPane) session.get("main_layout");
        DatePicker datePicker = (DatePicker) root.lookup("#filmoversigt_date");
        if(datePicker.getValue() != null) {   // this check is necessary cause on action is also called when you open datepicker before even choosing a date
            addMoviesToTheGridpane(datePicker.getValue(), root);
        }

    }

    public void addMoviesToTheGridpane(LocalDate date, BorderPane root) {

        FilmNodesToFilmOversigt filmNodes = new FilmNodesToFilmOversigt();

        GridPane gridPane = (GridPane) root.lookup("#filmoversigt_gridpane");
        filmNodes.gridPaneOfFilmNodes(date, gridPane);

    }





}
