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
import model.DBHelper;

import java.io.IOException;
import java.time.LocalDate;

public class FilmOversigtController {

    @FXML
    public void getDateFromFilmOversigt(MouseEvent event){
        BorderPane root = (BorderPane) event.getSource();
        DatePicker date = (DatePicker) root.lookup("#filmoversigt_date");
        addMoviesToTheGridpane(date.getValue(), root);

    }

    public void addMoviesToTheGridpane(LocalDate date, BorderPane root) {

        FilmNodesToFilmOversigt filmNodes = new FilmNodesToFilmOversigt();

        GridPane gridPane = (GridPane) root.lookup("#filmoversigt_gridpane");  // please change the ID accordingly
        filmNodes.gridPaneOfFilmNodes(date, gridPane);

    }


/*    @FXML
    public void instantiate() {
        BorderPane root = (BorderPane) Main.root;
        int id = 0;
        reservedSeatList.add(id);
        String idString = "#s" + id;
        ToggleButton toggleButton = (ToggleButton) root.lookup(idString);
        toggleButton.setStyle("-fx-graphic: url('../images/seat%20(red).png');");
        toggleButton.setSelected(true);
        toggleButton.setDisable(true);

    }*/


}
