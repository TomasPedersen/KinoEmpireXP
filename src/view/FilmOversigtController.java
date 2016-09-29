package view;

import controller.FilmNodesToFilmOversigt;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.web.WebView;
import model.DBHelper;
import model.Seat;

import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

public class FilmOversigtController {

    private Map<String, Object> session;

    public FilmOversigtController() {
    }

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




    /**
     * For each film node.. if the description button is clicked
     *
     * */
    public void selectingDescription(Event event) {
        Button descriptionButton = (Button) event.getSource();
        BorderPane root = (BorderPane) descriptionButton.getScene().getRoot();

        try {


            FXMLLoader movieDescriptionLoader = new FXMLLoader(getClass().getResource("MovieDescription.fxml"));
            FilmOversigtController filmOversigtController = new FilmOversigtController(session);
            movieDescriptionLoader.setController(filmOversigtController);
            Pane movieDescriptionPane = movieDescriptionLoader.load();

            root.setCenter(movieDescriptionPane);

            WebView webView = (WebView) root.lookup("#description_webview");
            webView.getEngine().load(
                    "http://www.dailymotion.com/embed/video/x3wnlqy_findet-dory-trailer-2016-disney_shortfilms"  //this will not work in recent javafx because format is not defined .. perhaps non-html5 video formatting is the reason

            );

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * First show the lillesal seat arrangment screen when reserve button is clicked on the film node in the film oversigt
     * Then for each film node.. if a seat is reserved then make it red, disable clicking
     *
     * */
    public void selectingReserveSeats(Event event, LocalDate date) {
        Button descriptionButton = (Button) event.getSource();
        BorderPane root = (BorderPane) descriptionButton.getScene().getRoot();

        VBox vBox = (VBox) descriptionButton.getParent();
        Label titleLabel = (Label) vBox.lookup("#filmoversigt_title");
        String title = titleLabel.getText();
        Label showTimeLabel = (Label) vBox.lookup("#filmoversigt_show_time");
        String showTime = showTimeLabel.getText();

        int showId;
        DBHelper db = new DBHelper();
        showId = db.findShowId(title, date, Integer.parseInt(showTime), 2);

        // now I should get an arraylist of seats (reserved or not)
        ArrayList<Seat> seats = new ArrayList<>();

        try {
            Seat[] seatArray = db.seatFromDate(showId);  // DOES NOT WORK
            for (int i = 0; i < seatArray.length; i++) {
                seats.add(seatArray[i]);
            }
        }catch(Exception e){
            e.printStackTrace();
        }


//            for (int i = 0; i < 240; i++) {
//                Seat seat = new Seat(false);
//                seats.add(seat);
//            }







            Button buttonClicked = (Button) event.getSource();
            BorderPane mainLayout = (BorderPane) buttonClicked.getScene().getRoot();

            FXMLLoader lilleSalLoader = new FXMLLoader(getClass().getResource("LilleSal.fxml"));
            LilleSalController lilleSalController = new LilleSalController(session);
            lilleSalLoader.setController(lilleSalController);
        BorderPane lilleSalBorderPane = null;
        try {
            lilleSalBorderPane = lilleSalLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        mainLayout.setCenter(lilleSalBorderPane);

        int amountOfSeats = 240;

        for (int i = 0; i < amountOfSeats; i++) {

            if (seats.get(i).isReserved()) {
                String toggleButtonId = "#s" + i;
                mainLayout.lookup(toggleButtonId);
                ToggleButton toggleButton = (ToggleButton) root.lookup(toggleButtonId);
                toggleButton.setStyle("-fx-graphic: url('images/seat%20(red).png');");
                toggleButton.setSelected(true);
                toggleButton.setDisable(true);
            }
        }


            // hypothetically there would be an if check here to see what room the show is in


            //show.getLilleSalSeats();
//            int amountOfSeats = 240;
//
//            for (int i = 0; i < amountOfSeats; i++) {
//
//                Random rand = new Random();
//                int randomNumber = rand.nextInt((6 - 1) + 1) + 1;
//                if (seats.get(i).isReserved() || i % randomNumber == 0) {
//                    String toggleButtonId = "#s" + i;
//                    mainLayout.lookup(toggleButtonId);
//                    ToggleButton toggleButton = (ToggleButton) root.lookup(toggleButtonId);
//                    toggleButton.setStyle("-fx-graphic: url('images/seat%20(red).png');");
//                    toggleButton.setSelected(true);
//                    toggleButton.setDisable(true);
//                }
//            }
    }


}
