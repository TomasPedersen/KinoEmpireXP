package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import model.DBHelper;
import model.Movie;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class FilmNodesToFilmOversigt {


    /**
     * This is the method that when called with a date returns a gridpane
     * it uses createListOfFilmNodes() below to get a list of nodes that contain the movies of that date
     * */
    public static GridPane gridPaneOfFilmNodes(LocalDate date, GridPane gridPane) {
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
    public static ArrayList<Node> createListOfFilmNodes(LocalDate date){

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
            ImageView noPosterIW = new ImageView();
            Image noPosterImage = new Image("NoPosterAvailable.png");

            Button description = new Button("Beskrivelse");
            description.setId("filmoversigt_beskrivelse");
//            description.onActionProperty( e -> descriptionCalled(description));
// then I can call Node.getParent().. then call the children of the parent through id's
//  so I can find the title of the film along with the time and date.. so I can create the show object out of the row I find in the db

            Button reserverFilm = new Button("Reservér");
            reserverFilm.setId("filmoversigt_reserver");
            // this one should also have a listener

            vbox.getChildren().addAll(titleTF, noPosterIW, reserverFilm);

            listOfNodes.add(vbox);
        }

        return listOfNodes;
    }



    public void descriptionCalled(Button description) {
        try {
            Parent filmOversigtNode = FXMLLoader.load(getClass().getResource("view/MovieInfo.fxml"));
            BorderPane rootBorderPane = (BorderPane) description.getScene().getRoot();
            rootBorderPane.setCenter(filmOversigtNode);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void reserveSelected(Button reserve) {
        try {
            Parent filmOversigtNode = FXMLLoader.load(getClass().getResource("view/LilleSal.fxml"));
            BorderPane rootBorderPane = (BorderPane) reserve.getScene().getRoot();
            rootBorderPane.setCenter(filmOversigtNode);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
