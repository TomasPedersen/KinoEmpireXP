package controller;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import model.DBHelper;
import model.Movie;

import java.time.LocalDate;
import java.util.ArrayList;

public class FilmNodesToFilmOversigt {



    public static GridPane gridPaneOfFilmNodes(LocalDate date, GridPane gridPane) {
//        GridPane gridPane = new GridPane();
        ArrayList<Node> nodesToAdd = createListOfFilmNodes(date);

        int columnIndex = 0;
        int rowIndex = 0;

        if (nodesToAdd.size() == 0) {
            //lav et vindue der siger ingen film at vise
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
            Button reserverFilm = new Button("Reservér");
            reserverFilm.setId("filmoversigt_reserver");

            vbox.getChildren().addAll(titleTF, noPosterIW, reserverFilm);

            listOfNodes.add(vbox);
        }

        return listOfNodes;
    }

}
