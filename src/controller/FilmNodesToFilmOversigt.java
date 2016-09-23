package controller;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import model.DBHelper;
import model.Film;

import java.sql.ResultSet;
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
        //Create if statement so that if there are no movies to show then create message.

        ArrayList<Film> films = new ArrayList<>();
        DBHelper db = new DBHelper();
        // if only I could do this : db.selectFromMovies(null, null)  and get an arraylist of films
        // this method does not work for dates

        ArrayList<Node> listOfNodes = new ArrayList<>();

        for(int i = 0; i< films.size(); i++ ){
            //vbox holds the rest of the nodes
            VBox vbox = new VBox();
            //Nodes for vbox
            TextField titleTF = new TextField(films.get(i).getDanishTitle());
            ImageView noPosterIW = new ImageView();
            Image noPosterImage = new Image("NoPosterAvailable.png");

            Button reserverFilm = new Button("Reserver");

            vbox.getChildren().addAll(titleTF, noPosterIW, reserverFilm);

            listOfNodes.add(vbox);

        }
        return listOfNodes;
    }




}
