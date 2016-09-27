package controller;

import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;
import model.DBHelper;
import model.Movie;
import model.Seat;
import view.FilmOversigtController;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class FilmNodesToFilmOversigt {


    /**
     * This is the method that when called with a date returns a gridpane
     * it uses createListOfFilmNodes() below to get a list of nodes that contain the movies of that date
     * */
    public GridPane gridPaneOfFilmNodes(LocalDate date, GridPane gridPane) {

        ArrayList<Node> nodesToAdd = createListOfFilmNodes(date);

        int columnIndex = 0;
        int rowIndex = 0;

        if (nodesToAdd.size() == 0) {
            Label noMoviesToday = new Label("There are no movies to show on this date");
            gridPane.add(noMoviesToday, columnIndex, rowIndex);
        }

        for (Node filmNode : nodesToAdd) {

            if(columnIndex == 4) {
                columnIndex = 0;
                rowIndex++;
            }
            gridPane.add(filmNode, columnIndex, rowIndex);
            columnIndex++;

        }
        return gridPane;
    }




    /**
     * of all movies in the database in a certain date we return an array of nodes
     * these nodes show the film and and additional information in filmoversigt
     * */
    public ArrayList<Node> createListOfFilmNodes(LocalDate date){

        ArrayList<Node> listOfNodes = new ArrayList<>(); // we will fill it with node where each node will take up one space in
        ArrayList<Movie> movies = new ArrayList<>(); // have to instantiate it here
        DBHelper db = new DBHelper();
        try {
            movies = db.fromTitlesToMovies(db.titlesFromDatePicked(date));
        } catch(Exception e) {
            e.printStackTrace();
        }

        FilmOversigtController filmOversigtController = new FilmOversigtController();

        for(int i = 0; i< movies.size(); i++ ){
            //vbox holds the rest of the nodes
            VBox vbox = new VBox();
            //Nodes for vbox
            Label titleLabel = new Label(movies.get(i).getDanishTitle());
            titleLabel.setPrefWidth(Double.MAX_VALUE);
            titleLabel.setId("filmoversigt_title");
            titleLabel.setAlignment(Pos.CENTER);

            Image noPosterImage = new Image("/images/NoPosterAvailable.png");
            ImageView noPosterIW = new ImageView(noPosterImage);
            noPosterIW.setPreserveRatio(true);
            noPosterIW.fitWidthProperty().setValue(140);

            StackPane stackPane = new StackPane();
            stackPane.getChildren().add(noPosterIW);

            Label showTime = new Label("I can't access the show time");
            showTime.setId("filmoversigt_show_time");


            Button description = new Button("Beskrivelse");
            description.setPrefWidth(Double.MAX_VALUE);
            description.setId("filmoversigt_beskrivelse");
            description.setId("glass-red");
            description.setOnAction( e -> filmOversigtController.selectingDescription(e));
            description.getStyleClass().add("red_button");

            Button reserverFilm = new Button("Reservér");
            reserverFilm.setPrefWidth(Double.MAX_VALUE);
            reserverFilm.setId("filmoversigt_reserver");
            reserverFilm.setId("glass-red");
            reserverFilm.setOnAction( e -> filmOversigtController.selectingReserveSeats(e));
            reserverFilm.getStyleClass().add("red_button");

            vbox.getChildren().addAll(titleLabel, stackPane, description, reserverFilm);

            listOfNodes.add(vbox);
        }


        if(true){  // this will run once and will be overwritten if there is something to show
            VBox vbox = new VBox();
            //Nodes for vbox
            Label titleTF = new Label("Find Dory");
            titleTF.setPrefWidth(Double.MAX_VALUE);
            titleTF.setId("filmoversigt_title");
            titleTF.setAlignment(Pos.CENTER);

            Image noPosterImage = new Image("http://i.imgur.com/8WwLmKA.jpg");
            ImageView noPosterIW = new ImageView(noPosterImage);
            noPosterIW.setPreserveRatio(true);
            noPosterIW.fitWidthProperty().setValue(140);

            StackPane stackPane = new StackPane();
            stackPane.getChildren().add(noPosterIW);


            Label showTime = new Label("I can't access the show time");
            showTime.setId("filmoversigt_show_time");

            Button description = new Button("Beskrivelse");
            description.setPrefWidth(Double.MAX_VALUE);
            description.setId("filmoversigt_beskrivelse");
            description.setId("glass-red");
            description.setOnAction( e -> filmOversigtController.selectingDescription(e));


            Button reserverFilm = new Button("Reservér");
            reserverFilm.setPrefWidth(Double.MAX_VALUE);
            reserverFilm.setId("filmoversigt_reserver");
            reserverFilm.setId("glass-red");
            reserverFilm.setOnAction( e -> filmOversigtController.selectingReserveSeats(e));


            vbox.getChildren().addAll(titleTF, stackPane, description, reserverFilm);

            listOfNodes.add(vbox);
        }


        return listOfNodes;
    }













}
