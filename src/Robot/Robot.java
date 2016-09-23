package robot;

import model.Customer;
import model.Sale;
import model.Show;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;

public class Robot implements Runnable{


    /* Adding sales, buying or reserving tickets*/
    @Override
    public void run() {
        ArrayList<Show> shows = new ArrayList<>(); // get all shows
        ArrayList<Customer> customers = new ArrayList<>(); // get all customers from db
        ArrayList<String> status = new ArrayList<>();
        status.add("Reserved");
        status.add("Purchased");
        int amountOfSeats = 240;

        while(true) {
            LocalDateTime timeOfSale = LocalDateTime.now();
            Sale sale = new Sale(shows.get(ranNum(0, shows.size())), customers.get(ranNum(0, customers.size())),
                    ranNum(0, amountOfSeats-1), timeOfSale, status.get(ranNum(0, status.size())) );
        }
    }


    public int ranNum(int lowerLimit, int upperLimit) {

        Random rand = new Random();

        return rand.nextInt((upperLimit - lowerLimit) + 1) + lowerLimit;
    }
}
