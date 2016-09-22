import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import model.Seat;

import java.util.ArrayList;

public class LilleSalController {

    // get The film object
    // get the show object
    ArrayList<Integer> reservedSeatList = new ArrayList<>(); // get the seating arrangement
    ArrayList<Integer> choosenSeats = new ArrayList<>();

    private int amountOfSeatsChoosen = 0;
    private int price = 0;


    @FXML
    public void instantiate() {
        BorderPane root = (BorderPane) Main.root;
        int id = 0;
        reservedSeatList.add(id);
        String idString = "#s" + id;
        ToggleButton toggleButton = (ToggleButton) root.lookup(idString);
        toggleButton.setStyle("-fx-graphic: url('images/seat%20(red).png');");
        toggleButton.setSelected(true);
        toggleButton.setDisable(true);

    }


    @FXML
    public void toggleUpdate(MouseEvent event) {

        ToggleButton toggleButton = (ToggleButton) event.getSource();
        String idString = toggleButton.getId();
        int id = Integer.parseInt(idString.substring(1,idString.length()));
        System.out.println("The ID is: " + id);

        for (int reservedId: reservedSeatList) {
            if (id == reservedId) {
                return;
            }
        }


        // account for 0 index


        if(toggleButton.isSelected()) {

            choosenSeats.add(id);

            BorderPane root = (BorderPane) Main.root;
            amountOfSeatsChoosen++;
            Label labelSeatAmount = (Label) root.lookup("#valgte_saeder");
            labelSeatAmount.setText(Integer.toString(amountOfSeatsChoosen));
            //price += film.getPrice();
            Label labelPriceTotal = (Label) root.lookup("#total_pris");
            labelPriceTotal.setText(Integer.toString(price));

        } else {

            if(choosenSeats != null && choosenSeats.size() <= id) {
                choosenSeats.remove(id);
            }


            BorderPane root = (BorderPane) Main.root;
            amountOfSeatsChoosen--;
            Label labelSeatAmount = (Label) root.lookup("#valgte_saeder");
            labelSeatAmount.setText(Integer.toString(amountOfSeatsChoosen));
            //price -= film.getPrice();
            Label labelPriceTotal = (Label) root.lookup("#total_pris");
            labelPriceTotal.setText(Integer.toString(price));
        }
        event.consume();
    }


    @FXML
    public void godkendBetaling() {

        // todo remove this from here.. for testing purposes
        instantiate();

        // this is for when the godkend button is clicked
        // next fxml node will be called here and put on root.setCenter();
        // pass choosenSeats and save them in the db only AFTER the payment has been processed

    }




    /* How to get the node based on index
    *
    *   BorderPane root = (BorderPane) Main.root;
        root.lookup("#s1");
    *
    * */



}
