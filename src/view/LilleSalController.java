package view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.util.ArrayList;

public class LilleSalController {

    // get The film object
    // get the show object
    ArrayList<Integer> reservedSeatList = new ArrayList<>(); // get the seating arrangement
    ArrayList<Integer> choosenSeats = new ArrayList<>();

    private int amountOfSeatsChoosen = 0;
    private int price = 0;

    private BorderPane root;  // can this be deleted?




    @FXML
    public void toggleUpdate(MouseEvent event) {

        ToggleButton toggleButton = (ToggleButton) event.getSource();
        String idString = toggleButton.getId();
        int id = Integer.parseInt(idString.substring(1,idString.length()));

        for (int reservedId: reservedSeatList) {
            if (id == reservedId) {
                return;
            }
        }


        // account for 0 index


        if(toggleButton.isSelected()) {

            choosenSeats.add(id);

            root = (BorderPane) toggleButton.getScene().getRoot();
            amountOfSeatsChoosen++;
            Label labelSeatAmount = (Label) root.lookup("#valgte_saeder");
            labelSeatAmount.setText(Integer.toString(amountOfSeatsChoosen));
            //price += film.getPrice();
            Label labelPriceTotal = (Label) root.lookup("#total_pris");
            labelPriceTotal.setText(Integer.toString(price));

        } else {

            for(int i = 0; i <= choosenSeats.size(); i++) {
                if(choosenSeats.get(i) == id) {
                    choosenSeats.remove(i);
                }
            }


            root = (BorderPane) toggleButton.getScene().getRoot();
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
    public void godkendBetaling(MouseEvent event) {

        Button godkendBetalingButton = (Button) event.getSource();
        root = (BorderPane) godkendBetalingButton.getScene().getRoot();

        if (amountOfSeatsChoosen > 0) {
            try {
                Parent filmOversigtNode = FXMLLoader.load(getClass().getResource("ProcessPayment.fxml"));
                root.setCenter(filmOversigtNode);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {

            Label messageLabel = (Label) root.lookup("#accept_payment_seat_message");
            messageLabel.setText("You've not selected any seats.");
        }


        // this is for when the godkend button is clicked
        // next fxml node will be called here and put on root.setCenter();
        // pass choosenSeats and save them in the db only AFTER the payment has been processed

    }








}
