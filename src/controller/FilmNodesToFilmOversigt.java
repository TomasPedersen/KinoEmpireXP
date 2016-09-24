package controller;

import javafx.event.Event;
import javafx.fxml.FXMLLoader;
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
import javafx.scene.layout.VBox;
import model.DBHelper;
import model.Movie;
import model.Seat;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class FilmNodesToFilmOversigt {


    /**
     * This is the method that when called with a date returns a gridpane
     * it uses createListOfFilmNodes() below to get a list of nodes that contain the movies of that date
     * */
    public GridPane gridPaneOfFilmNodes(LocalDate date, GridPane gridPane) {
//        GridPane gridPane = new GridPane();
        ArrayList<Node> nodesToAdd = createListOfFilmNodes(date);

        int columnIndex = 0;
        int rowIndex = 0;

        if (nodesToAdd.size() == 0) {
            Label noMoviesToday = new Label("There are no movies to show on this date");
            gridPane.add(noMoviesToday, columnIndex, rowIndex);
        }

        for (Node filmNode : nodesToAdd) {

            if(columnIndex == 2) {
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
            movies = db.moviesFromDatePicked(date);
        } catch(Exception e) {
            e.printStackTrace();
        }

        for(int i = 0; i< movies.size(); i++ ){
            //vbox holds the rest of the nodes
            VBox vbox = new VBox();
            //Nodes for vbox
            TextField titleTF = new TextField(movies.get(i).getDanishTitle());
            titleTF.setId("filmoversigt_title");
            ImageView noPosterIW = new ImageView();
            Image noPosterImage = new Image("NoPosterAvailable.png");

            Button description = new Button("Beskrivelse");
            description.setId("filmoversigt_beskrivelse");
            description.setOnAction( e -> selectingDescription(e));


            Button reserverFilm = new Button("Reservér");
            reserverFilm.setId("filmoversigt_reserver");
            reserverFilm.setOnAction( e -> selectingReserveSeats(e));


            vbox.getChildren().addAll(titleTF, noPosterIW, reserverFilm);

            listOfNodes.add(vbox);
        }

        return listOfNodes;
    }

// todo .. test the two methods below
    /**
     * For each film node.. if the description button is clicked
    *
    * */
    public void selectingDescription(Event event) {
        Button descriptionButton = (Button) event.getSource();
        BorderPane root = (BorderPane) descriptionButton.getScene().getRoot();

        try {

            Parent newRoot = FXMLLoader.load(getClass().getResource("../view/Description.fxml")); // later on check if the link is correct
            root.setCenter(newRoot);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * First show the lillesal seat arrangment screen when reserve button is clicked on the film node in the film oversigt
     * Then for each film node.. if a seat is reserved then make it red, disable clicking
     *
     * */
    public void selectingReserveSeats(Event event) {
        Button descriptionButton = (Button) event.getSource();
        BorderPane root = (BorderPane) descriptionButton.getScene().getRoot();
        VBox vBox = (VBox) descriptionButton.getParent();
        vBox.lookup("filmoversigt_title");

        DBHelper db = new DBHelper();
        // find show by title, date and time
        //db.findShowId();

        // now I should get an arraylist of seats (reserved or not)
        // db.seatFromDate()
        ArrayList<Seat> seats = new ArrayList<>();

        try {
            // hypothetically there would be an if check here to see what room the show is in
            Parent newRoot = FXMLLoader.load(getClass().getResource("../view/LilleSal.fxml"));
            root.setCenter(newRoot);

            //show.getLilleSalSeats();
            int amountOfSeats = 240;

            for (int i = 0; i < amountOfSeats; i++) {
                if (seats.get(i).isReserved()) {
                    String toggleButtonId = "#s" +i;
                    newRoot.lookup(toggleButtonId);
                    ToggleButton toggleButton = (ToggleButton) root.lookup(toggleButtonId);
                    toggleButton.setStyle("-fx-graphic: url('../images/seat%20(red).png');");
                    toggleButton.setSelected(true);
                    toggleButton.setDisable(true);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }











}
