package view;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import model.Film;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class FilmNodesToFilmOversigt {


    public ArrayList<Node> createListOfNodes(ArrayList<Film> films){

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
