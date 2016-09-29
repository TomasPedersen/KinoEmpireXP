package view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebView;
import model.Customer;
import model.Seat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class LilleSalController {

    // get The film object
    // get the show object
    Seat[] reservedSeatList; // get the seating arrangement
    ArrayList<Integer> choosenSeats = new ArrayList<>();

    private int amountOfSeatsChoosen = 0;
    private int price = 0;

    private BorderPane root;  // can this be deleted?


    private Map<String, Object> session;

    public LilleSalController(Map<String, Object> session) {
        this.session = session;
    }



    @FXML
    public void toggleUpdate(MouseEvent event) {

        ToggleButton toggleButton = (ToggleButton) event.getSource();
        String idString = toggleButton.getId();
        int id = Integer.parseInt(idString.substring(1,idString.length()));

        //Hvorfor er det her?
//        for (Seat seat: reservedSeatList) {
//            if (seat.isReserved()) {
//                return;
//            }
//        }


        if(toggleButton.isSelected()) {

            choosenSeats.add(id);

            root = (BorderPane) toggleButton.getScene().getRoot();
            amountOfSeatsChoosen++;
            Label labelSeatAmount = (Label) root.lookup("#valgte_saeder");
            labelSeatAmount.setText(Integer.toString(amountOfSeatsChoosen));
            //price += film.getPrice();
            price += 80;
            Label labelPriceTotal = (Label) root.lookup("#total_pris");
            labelPriceTotal.setText(Integer.toString(price));

        } else {

            for(int i = 0; i < choosenSeats.size(); i++) {
                if(choosenSeats.get(i) == id) {
                    choosenSeats.remove(i);
                }
            }


            root = (BorderPane) toggleButton.getScene().getRoot();
            amountOfSeatsChoosen--;
            Label labelSeatAmount = (Label) root.lookup("#valgte_saeder");
            labelSeatAmount.setText(Integer.toString(amountOfSeatsChoosen));
            //price -= film.getPrice();
            price -= 80;
            Label labelPriceTotal = (Label) root.lookup("#total_pris");
            labelPriceTotal.setText(Integer.toString(price));
        }
        event.consume();
    }


    /**
     * this is for when the godkend button is clicked
     * pass choosenSeats and save them in the db only AFTER the payment has been processed ?
     * @param event
     */
    @FXML
    public void godkendBetaling(MouseEvent event) {

        Button godkendBetalingButton = (Button) event.getSource();
        root = (BorderPane) godkendBetalingButton.getScene().getRoot();

        if (amountOfSeatsChoosen > 0) {
            try {


                FXMLLoader paymentLoader = new FXMLLoader(getClass().getResource("ProcessPayment.fxml"));
                Controller controller = new Controller(session);  // Controller will act as a placeholder cause it needs to set a controller
                paymentLoader.setController(controller);
                BorderPane paymentBorderPane = paymentLoader.load();

                root.setCenter(paymentBorderPane);


                Label labelSeatAmount = (Label) root.lookup("#valgte_saeder");
                labelSeatAmount.setText(Integer.toString(amountOfSeatsChoosen));

                Label labelPriceTotal = (Label) root.lookup("#total_pris");
                labelPriceTotal.setText(Integer.toString(price));


/*                Customer customer = (Customer) session.get("customer_object");

                Label nameLabel = (Label) root.lookup("#process_payment_name");
                nameLabel.setText(customer.getName());
                Label emailLabel = (Label) root.lookup("#process_payment_email");
                emailLabel.setText(customer.getEmail());
                Label telephoneLabel = (Label) root.lookup("#process_payment_telephone_number");
                telephoneLabel.setText(customer.getPhoneNumber());
*/


            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {

            Label messageLabel = (Label) root.lookup("#accept_payment_seat_message");
            messageLabel.setText("You've not selected any seats.");
        }



    }






}
