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
    // get the seating arrangement
    ArrayList<Seat> seatList = new ArrayList<>();

    private int amountOfSeatsChoosen = 0;
    private int price = 0;



    @FXML
    public void toggleUpdate(MouseEvent event) {

        ToggleButton toggleButton = (ToggleButton) event.getSource();
        String idString = toggleButton.getId();
        int id = Integer.parseInt(idString.substring(1,idString.length()));
        // remove the s
        // account for 0 index

        if(toggleButton.isSelected()) {

            System.out.println("is selected");

/*            Seat seat = seatList.get(id);
            seat.setReserved(true);
            seatList.set(id, seat);*/




            BorderPane root = (BorderPane) Main.root;
            amountOfSeatsChoosen++;
            Label labelSeatAmount = (Label) root.lookup("#valgte_saeder");
            labelSeatAmount.setText(Integer.toString(amountOfSeatsChoosen));
            //price += film.getPrice();
            Label labelPriceTotal = (Label) root.lookup("#total_pris");
            labelPriceTotal.setText(Integer.toString(price));

        } else {

            System.out.println("is NOT selected");

/*            Seat seat = seatList.get(id);
            seat.setReserved(false);
            seatList.set(id, seat);*/

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






    /* How to get the node based on index
    *
    *   BorderPane root = (BorderPane) Main.root;
        root.lookup("#s1");
    *
    * */



}
