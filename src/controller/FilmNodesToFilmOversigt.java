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



    public GridPane gridPaneOfFilmNodes() {
        GridPane gridPane = new GridPane();

        // Localdate from combobox or datepicker
        LocalDate date = LocalDate.now();  // change this and give this method a parameter

        int columnIndex = 0;
        int rowIndex = 0;
        for (Node filmNode : createListOfFilmNodes(date)) {

            if(columnIndex == 2) {
                columnIndex = 0;
                rowIndex++;
            }
            gridPane.add(filmNode, columnIndex, rowIndex);
            columnIndex++;

        }
        return gridPane;
    }





    public ArrayList<Node> createListOfFilmNodes(LocalDate date){


        ArrayList<Movie> movies = new ArrayList<>();
        DBHelper db = new DBHelper();
        // if only I could do this : db.selectFromMovies(null, null)  and get an arraylist of movies
        // this method does not work for dates

        ArrayList<Node> listOfNodes = new ArrayList<>();

        for(int i = 0; i< movies.size(); i++ ){
            //vbox holds the rest of the nodes
            VBox vbox = new VBox();
            //Nodes for vbox
            TextField titleTF = new TextField(movies.get(i).getDanishTitle());
            ImageView noPosterIW = new ImageView();
            Image noPosterImage = new Image("NoPosterAvailable.png");

            Button reserverFilm = new Button("Reserver");

            vbox.getChildren().addAll(titleTF, noPosterIW, reserverFilm);

            listOfNodes.add(vbox);

            if(movies == null){
                //lav et vindue der siger ingen film at vise
                Label noMoviesToday = new Label("There are no movies to show on this date");
                noMoviesToday.setScaleX(3);

            }

        }
        return listOfNodes;
    }

}
