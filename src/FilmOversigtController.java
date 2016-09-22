import controller.FilmNodesToFilmOversigt;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class FilmOversigtController {


    @FXML
    public void addMoviesToTheGridpane() {

        FilmNodesToFilmOversigt filmNodes = new FilmNodesToFilmOversigt();
        BorderPane root = (BorderPane) Main.root;
        GridPane gridPane = (GridPane) root.lookup("#GRIDPANEID");  // please change the ID accordingly
        gridPane = filmNodes.gridPaneOfFilmNodes();  // remember that this method will take localdate as parameter
        // create a combobox or datepicker from which you can get the date

        }




}
